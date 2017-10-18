package com.example.chetanya.materialtabs;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.TreeMap;

//import info.androidhive.materialtabs.R;


public class ThreeFragment extends Fragment{
    TreeMap<String, String> treeMap = new TreeMap<>();
    ArrayList<String> Destination = new ArrayList<>();
    //ArrayList<ImageView> imageViews = new ArrayList<>();
    Cursor cursor;


    public ThreeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        getPhoneContacts();
        //ContentResolver contentResolver = getActivity().getContentResolver();

        RecyclerView recyclerView =(RecyclerView)view.findViewById(R.id.rvContacts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ThreeFragment.this.getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ContctAdapter contctAdapter = new ContctAdapter(ThreeFragment.this.getActivity(), Destination, treeMap );
        recyclerView.setAdapter(contctAdapter);
        return view;
    }

    private void getPhoneContacts() {
        cursor = ThreeFragment.this.getActivity().getApplicationContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        if (cursor.getCount() != 0 ) {
            while (cursor.moveToNext()){
                /*Names.add(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)));
                Status.add(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));*/

                Destination.add(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.LAST_TIME_CONTACTED)));

                treeMap.put(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)),
                        cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));

                //imageViews.add(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Photo.PHOTO)));
            }
        }
    }

}