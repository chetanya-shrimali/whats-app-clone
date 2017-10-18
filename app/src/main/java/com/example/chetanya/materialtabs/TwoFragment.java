package com.example.chetanya.materialtabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

//import info.androidhive.materialtabs.R;


public class TwoFragment extends Fragment{
    ArrayList<String> Name =new ArrayList<>();
    ArrayList<String> date =new ArrayList<>();
    ArrayList<String> Message =new ArrayList<>();

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        Name.add("chetanya");
        Name.add(" Chetanya");
        date.add("Today");
        date.add("yesterday");
        Message.add("Heyy");
        Message.add("Hello");
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.rv);
       // recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(TwoFragment.this.getActivity().getApplicationContext());

        ChatAdapter chatAdapter = new ChatAdapter(TwoFragment.this.getActivity(), Name, date, Message);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(chatAdapter);
        return view;

    }
}