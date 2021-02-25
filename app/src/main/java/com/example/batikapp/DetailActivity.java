package com.example.batikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    TextView txtnamanya,txtdaerahnya,txtmaknabatiknya,txthargarendah,txthargatinggi;
    ImageView imgbatiknya;
    public static String KEY_ACTIVITY="msg";
    Batik batiknya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtnamanya=(TextView)findViewById(R.id.textView8);
        txtdaerahnya=(TextView)findViewById(R.id.textView9);
        txtmaknabatiknya=(TextView)findViewById(R.id.textView10);
        txthargarendah=(TextView)findViewById(R.id.txt_rendah);
        txthargatinggi=(TextView)findViewById(R.id.txt_tinggi);
        imgbatiknya=(ImageView)findViewById(R.id.img_batiknya);
        Intent intent=getIntent();
        batiknya= (Batik) intent.getSerializableExtra(KEY_ACTIVITY);
        txtnamanya.setText(batiknya.getNama_batik());
        txtdaerahnya.setText(batiknya.getDaerah_batik());
        txtmaknabatiknya.setText(batiknya.getMakna_batik());
        txthargarendah.setText(batiknya.getHarga_rendah());
        txthargatinggi.setText(batiknya.getHarga_tinggi());
        Picasso.with(this).load(batiknya.getLink_batik()).into(imgbatiknya);
        imgbatiknya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kirim=new Intent(DetailActivity.this,GambarActivity.class);
                kirim.putExtra("gambar",batiknya);
                startActivity(kirim);
            }
        });
    }
}
