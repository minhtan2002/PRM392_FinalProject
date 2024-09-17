package com.example.prm392_finalproject;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class HolderBundle extends RecyclerView.ViewHolder {
    private ImageView img;
    private TextView tvname;
    private TextView tvprice;


    private Context context;

    private void bindingView() {
        img = itemView.findViewById(R.id.img);
        tvname = itemView.findViewById(R.id.tvTitle);
        tvprice = itemView.findViewById(R.id.tvPrice);
    }
    public HolderBundle(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        bindingView();

    }
    private void bindImgLinkToImageView(String link, ImageView imageView) {
        Glide
                .with(context)
                .load(link)
                .placeholder(R.drawable.img_loading)
                .error(R.drawable.img_crash)
                .into(imageView);
    }
    public void setBundle(Bundle bundles) {
        bindImgLinkToImageView(bundles.getImage(),img);
        tvname.setText(bundles.getName());
        tvprice.setId(bundles.getPrice());
    }
}
