package com.example.contactapp;

import android.database.Cursor;
import android.os.Bundle;


import android.provider.CallLog;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link historyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class historyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View v;
    private RecyclerView recyclerView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public historyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment historyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static historyFragment newInstance(String param1, String param2) {
        historyFragment fragment = new historyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView = v.findViewById(R.id.history_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        customAdapterOfCallHistory adapter= new customAdapterOfCallHistory(getCallLogs(),getContext());
        recyclerView.setAdapter(adapter);

        return v;
    }

    private ArrayList<ModelCalls> getCallLogs(){

        ArrayList<ModelCalls> list = new ArrayList<>();
        Cursor cursor =getContext().getContentResolver().query(CallLog.Calls.CONTENT_URI,null,null
        ,null,CallLog.Calls.DATE);

        int number = cursor.getColumnIndex(CallLog.Calls.NUMBER);
        int duration = cursor.getColumnIndex(CallLog.Calls.DURATION);
        int date_idx = cursor.getColumnIndex(CallLog.Calls.DATE);

        cursor.moveToFirst();
        while (cursor.moveToNext()){

            Date date = new Date(Long.valueOf(cursor.getString(date_idx)));

            String mnth_date,week_day,month,day;
            mnth_date= (String) DateFormat.format("dd",date);
            week_day= (String) DateFormat.format("EEEE",date);
            month= (String) DateFormat.format("MMM",date);

                    list.add(new ModelCalls(cursor.getString(number),cursor.getString(duration),
                    week_day +" "+ mnth_date +" " + month));
            Log.d("MiC:: ",cursor.getString(number));
        }
        return list;
    }
}