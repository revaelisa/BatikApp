package com.example.batikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class GambarActivity extends AppCompatActivity {
    ImageView imgGede;
    Batik xxx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambar);
        imgGede=(ImageView)findViewById(R.id.img_besar);
        Intent dapet=getIntent();
        xxx= (Batik) dapet.getSerializableExtra("gambar");
        Picasso.with(this).load(xxx.getLink_batik()).into(imgGede);

    }
}
