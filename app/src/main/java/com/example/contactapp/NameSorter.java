package com.example.contactapp;

import java.util.Comparator;

public class NameSorter implements Comparator<dataModelOfContact> {

    @Override
    public int compare(dataModelOfContact o1, dataModelOfContact o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
