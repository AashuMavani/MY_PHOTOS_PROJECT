package com.app.my_photos_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Re_Adapter extends RecyclerView.Adapter<Re_Adapter.Holder> {
    MainActivity mainActivity;
    List<Model> classList;
    public Re_Adapter(MainActivity mainActivity, List<Model> classList) {
        this.mainActivity=mainActivity;
        this.classList=classList;
    }

    @NonNull
    @Override
    public Re_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mainActivity).inflate(R.layout.item_file,parent,false);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Re_Adapter.Holder holder, int position) {
        holder.t1.setText(""+classList.get(position).getTitle());
        Glide
                .with(mainActivity)
                .load(classList.get(position).getUrl())
                .centerCrop()
                .placeholder(R.drawable.rotation)
                .into(holder.img1);
        Glide
                .with(mainActivity)
                .load(classList.get(position).getThumbnailUrl())
                .centerCrop()
                .placeholder(R.drawable.rotation)
                .into(holder.img2);

    }

    @Override
    public int getItemCount() {
        return classList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView t1;
        ImageView img1,img2;
        public Holder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.t1);
            img1=itemView.findViewById(R.id.img1);
            img2=itemView.findViewById(R.id.img2);

        }
    }
}
