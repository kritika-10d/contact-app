package com.example.contactapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class pageAdapter extends FragmentStateAdapter {


    public pageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position) {
            case 0:
                return new historyFragment();
            case 1:
                return new contactsFragment();
            case 2:
                return new favFragment();
            default:
                return null;
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
