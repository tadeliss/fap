package com.example.tadsr.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.PhotoHolder>{

    private List<RecentPhotosResponse.Photo> mPhotos;

    public RecyclerAdapter(List<RecentPhotosResponse.Photo> photos) {

        mPhotos = photos;

    }

    public static class PhotoHolder extends RecyclerView.ViewHolder {

        private ImageView mItemImage;
        private Context context;

        public PhotoHolder(View v) {
            super(v);

            context = v.getContext();
            mItemImage = (ImageView) v.findViewById(R.id.item_image);

        }

        public void bindData(RecentPhotosResponse.Photo mPhoto) {

            Picasso.with(context).load(mPhoto.getUrlC()).into(mItemImage);
        }
    }

    @Override
    public RecyclerAdapter.PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflatedView = LayoutInflater.from(parent.getContext())

            .inflate(R.layout.recyclerview_item_row, parent, false);

        return new PhotoHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.PhotoHolder holder, int position) {
        holder.bindData(mPhotos.get(position));
    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }
}
