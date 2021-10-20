
package com.example.contactapp;

        import android.os.Bundle;

        import androidx.fragment.app.Fragment;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link favFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class favFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String favName,favNumber;
    RecyclerView recyclerView;
    ArrayList<dataModelOfContact> FavList;

    public favFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment favFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static favFragment newInstance(String param1, String param2) {
        favFragment fragment = new favFragment();
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
        View view = inflater.inflate(R.layout.fragment_fav, container, false);
        recyclerView = view.findViewById(R.id.FavList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        FavList = new ArrayList<>();
        //FavList.add(new dataModelOfContact(0,"Ambulance","108"));

        favVariable db = new favVariable(getContext());
        FavList=db.getAllRecords();
        FavList.add(new dataModelOfContact(0,"Ambulance","108"));
        recyclerView.setAdapter(new customAdapterOfFavFragment(FavList));

        return view;

    }


}