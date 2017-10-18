package com.example.chetanya.materialtabs;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.TreeMap;

//import info.androidhive.materialtabs.R;


public class OneFragment extends Fragment {
    TreeMap<String, String> treeMap = new TreeMap<>();
    ArrayList<String> Names = new ArrayList<>();
    ArrayList<String> Status = new ArrayList<>();
    Cursor cursor;

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvCall);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(OneFragment.this.getActivity().getApplicationContext());
        getCallList();
        CallAdapter callAdapter = new CallAdapter(Names, Status);
        recyclerView.setAdapter(callAdapter);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    private void getCallList() {
        if (ActivityCompat.checkSelfPermission(OneFragment.this.getActivity(), Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        cursor = OneFragment.this.getActivity().getApplicationContext().getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, CallLog.Calls.DATE + " DESC");
        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                /*treeMap.put(
                        cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER)),
                        cursor.getString(cursor.getColumnIndex(CallLog.Calls.TYPE)));*/
                Names.add(cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER)));
                Status.add(cursor.getString(cursor.getColumnIndex(CallLog.Calls.TYPE)));
            }
        }
        cursor.close();
    }

}