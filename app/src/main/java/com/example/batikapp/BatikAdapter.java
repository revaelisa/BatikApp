package com.example.batikapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
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
            if(position%7==0){
                holder.crd.setCardBackgroundColor(ContextCompat.getColor(activity,R.color.colorkuningtua));
            }else if(position%7==1){
                holder.crd.setCardBackgroundColor(ContextCompat.getColor(activity,R.color.colorijau) );
            }else if(position%7==2){
                holder.crd.setCardBackgroundColor(ContextCompat.getColor(activity,R.color.colormerahungu));
            }else if (position%7==3){
                holder.crd.setCardBackgroundColor(ContextCompat.getColor(activity,R.color.colorhitam));
            }else if (position%7==4){
                holder.crd.setCardBackgroundColor(ContextCompat.getColor(activity,R.color.colorhijau2));
            }else if (position%7==5){
                holder.crd.setCardBackgroundColor(ContextCompat.getColor(activity,R.color.colorkuningmuda));
            }else if (position%7==6){
                holder.crd.setCardBackgroundColor(ContextCompat.getColor(activity,R.color.colorpinksalem));
            }
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
        CardView crd;

        public BatikHolder(@NonNull View itemView) {
            super(itemView);
            imgBatik=(ImageView)itemView.findViewById(R.id.img_batik);

            txtDaerah=(TextView)itemView.findViewById(R.id.txt_daerah);
            txtNama=(TextView)itemView.findViewById(R.id.txt_nama);
            crd=(CardView)itemView.findViewById(R.id.card_id);

        }
    }
}
