package com.example.batikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends AppCompatActivity {
    ApiInterface apiInterface;
    Hasil databatiknya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new AmbilData().execute();
    }
    private class AmbilData extends AsyncTask<Void,Void,Void> {


        @Override
        protected Void doInBackground(Void... voids) {
            apiInterface=ApiClient.ambilBatik().create(ApiInterface.class);
            Call<Hasil> call=apiInterface.GetBatik();
            call.enqueue(new Callback<Hasil>() {
                @Override
                public void onResponse(Call<Hasil> call, Response<Hasil> response) {
                    databatiknya=response.body();
                    List<Batik> yangKubutuhkan=databatiknya.getHasil();
                    Intent kirim = new Intent(SplashScreen.this,MainActivity.class);
                    kirim.putExtra("batikku", (Serializable) yangKubutuhkan);
                    startActivity(kirim);
                    finish();


                }

                @Override
                public void onFailure(Call<Hasil> call, Throwable t) {
                    Toast.makeText(SplashScreen.this,"tidak dapet data",Toast.LENGTH_LONG).show();
                }
            });
            return null;
        }
    }
}
