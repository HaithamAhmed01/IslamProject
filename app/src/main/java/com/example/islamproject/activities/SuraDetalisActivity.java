package com.example.islamproject.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.islamproject.R;
import com.example.islamproject.adapters.VersesAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SuraDetalisActivity extends AppCompatActivity {

    int pos;
    String name;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    TextView suraName ;
    VersesAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura_detalis);
        recyclerView=findViewById(R.id.recyclerView);
        suraName=findViewById(R.id.sura_Name);
        pos =getIntent().getIntExtra("position",-1);
        name=getIntent().getStringExtra("name");
        suraName.setText(name);
        List<String> data= readSurafromAssets((pos+1)+".txt");
        layoutManager= new LinearLayoutManager(this);
        adapter=new VersesAdapter(data);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
    List<String> readSurafromAssets(String fileName){
        List<String> allLines=new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(fileName)));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                allLines.add(mLine);

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
        return allLines;
    }
}
