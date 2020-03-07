package com.lint0t.myimageloader;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Bitmap> a;


    public MyAdapter(List<Bitmap> imgs) {
        this.a = imgs;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        return new MyAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        if (a.size() != 0) {
            holder.mimg.setImageBitmap(a.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if (a.size() == 0)
            return 1;
        else
            return a.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView mimg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mimg = itemView.findViewById(R.id.img_item);
        }

    }
}
