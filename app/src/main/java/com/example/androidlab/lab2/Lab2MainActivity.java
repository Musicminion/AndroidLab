package com.example.androidlab.lab2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidlab.R;

import java.util.ArrayList;
import java.util.List;

public class Lab2MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Lab2Adapter lab2Adapter = new Lab2Adapter(Lab2MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_main);

        recyclerView = (RecyclerView) super.findViewById(R.id.Lab2_mainView_recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(lab2Adapter);

        List<String> allItems = new ArrayList<>();
        for (int i=0; i<100; i++){
            allItems.add(String.valueOf(i));
        }
        lab2Adapter.notifyItems(allItems);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null){
            if( data.getStringExtra("index") != null && data.getStringExtra("newInfo") != null){
                String index =data.getStringExtra("index");
                String info = data.getStringExtra("newInfo");
                lab2Adapter.singleItemUpdate(Integer.parseInt(index),info);
            }
        }
    }
}
