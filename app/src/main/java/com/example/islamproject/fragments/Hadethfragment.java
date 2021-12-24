package com.example.islamproject.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.islamproject.R;
import com.example.islamproject.adapters.HadethListAdapter;
import com.example.islamproject.adapters.VersesAdapter;
import com.example.islamproject.model.HadethItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Hadethfragment extends Fragment {
    int pos;
    String name;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    TextView HadethName ;
    HadethListAdapter adapter;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.recyclerView);
        HadethName=view.findViewById(R.id.Hadeth_Name);
        pos =getActivity().getIntent().getIntExtra("position",-1);
        name=getActivity().getIntent().getStringExtra("name");
        HadethName.setText(name);
        //readAllHadeth();
        layoutManager= new LinearLayoutManager(getContext());
        adapter= new HadethListAdapter(readAllHadeth());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }


    public Hadethfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hadethfragment, container, false);
    }
   public List<HadethItem> readAllHadeth(){
        List<HadethItem> allHadeth =new ArrayList<>();

       BufferedReader reader = null;
       try {
           reader = new BufferedReader(
                   new InputStreamReader(getActivity().getAssets().open("ahadeth.txt")));

           // do reading, usually loop until end of file reading
           String mLine;
           while ((mLine = reader.readLine()) != null) {
               //process line
               String title=mLine;
               String content="";
               while ((mLine = reader.readLine()) != null) {
                   if(mLine.trim().equals("#")) break;
                content=content+" "+mLine;
               }

               allHadeth.add(new HadethItem(title,content));



           }
       } catch (IOException e) {
           //log the exception
       } finally {
           if (reader != null) {
               try {
                   reader.close();
               } catch (IOException e) {
                   //log the exception
               }
           }
       }
       return allHadeth;
   }

   }

