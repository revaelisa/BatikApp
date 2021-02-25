package com.example.batikapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvnya;
    Hasil databatiknya;
    RecyclerView.LayoutManager layoutManager;
    ApiInterface apiInterface;
    BatikAdapter batikAdapter;
    List<Batik> yangKudapatkan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvnya=(RecyclerView)findViewById(R.id.rv_Batik);
        layoutManager=new LinearLayoutManager(this);
        rvnya.setLayoutManager(layoutManager);
        Intent dapet=getIntent();
        yangKudapatkan= (List<Batik>) dapet.getSerializableExtra("batikku");
        batikAdapter=new BatikAdapter(yangKudapatkan,MainActivity.this);
        rvnya.setAdapter(batikAdapter);

    }
}
