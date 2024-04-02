package com.example.recycleviewdancardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SkincareAdapter extends RecyclerView.Adapter<SkincareAdapter.ViewHolder> {
    private RecyclerViewClickListener listener;

    private ArrayList <SkincareModel> dataItem;

    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView namaSkincare;
        ImageView gambarSkincare;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            namaSkincare = itemView.findViewById(R.id.nama_skincare);
            gambarSkincare = itemView.findViewById(R.id.gambar_skincare);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            listener.onClick(v,getAdapterPosition());
        }
    }

    SkincareAdapter(Context context, ArrayList <SkincareModel> dataItem, RecyclerViewClickListener listener){
        this.context = context;
        this.dataItem = dataItem;
        this.listener = listener;
    }



    @NonNull
    @Override
    public SkincareAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkincareAdapter.ViewHolder holder, int position) {
        TextView namaSkincare= holder.namaSkincare;
        ImageView gambarSkincare = holder.gambarSkincare;


        namaSkincare.setText(dataItem.get(position).getNamaSkincare());
        gambarSkincare.setImageResource(dataItem.get(position).getGambarSkincare());
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }



    public interface RecyclerViewClickListener {
        void onClick(View v, int position);
    }
}
