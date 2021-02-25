package com.example.batikapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BatikAdapter extends RecyclerView.Adapter<BatikAdapter.BatikHolder>{
        List<Batik>daftarBatik;
        Activity activity;

    public BatikAdapter(List<Batik> daftarBatik, Activity activity) {
        this.daftarBatik = daftarBatik;
        this.activity = activity;
    }

    @NonNull
    @Override
    public BatikHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.rv_batik,parent,false);
        return new BatikHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BatikHolder holder, final int position) {
            holder.txtDaerah.setText(daftarBatik.get(position).getDaerah_batik());
            holder.txtNama.setText(daftarBatik.get(position).getNama_batik());

            Picasso.with(activity).load(daftarBatik.get(position).getLink_batik()).into(holder.imgBatik);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Batik batik=daftarBatik.get(position);
                    Intent intent=new Intent(activity,DetailActivity.class);
                    intent.putExtra(DetailActivity.KEY_ACTIVITY,batik);
                    v.getContext().startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return daftarBatik.size() ;
    }

    static class BatikHolder extends RecyclerView.ViewHolder{
        ImageView imgBatik,imgback;
        TextView txtDaerah,txtNama;

        public BatikHolder(@NonNull View itemView) {
            super(itemView);
            imgBatik=(ImageView)itemView.findViewById(R.id.img_batik);

            txtDaerah=(TextView)itemView.findViewById(R.id.txt_daerah);
            txtNama=(TextView)itemView.findViewById(R.id.txt_nama);

        }
    }
}
