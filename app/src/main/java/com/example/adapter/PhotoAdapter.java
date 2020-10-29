package com.example.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.connectframework.R;
import com.example.connectframework.databinding.ItemViewBinding;
import com.example.viewmodel.NavgateTo;
import com.example.vo.Photo;

import java.util.Collections;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoViewHolder>{
    private List<Photo> photos;
    private NavgateTo navgateTo;


    public PhotoAdapter(NavgateTo navgateTo) {
        this.photos = Collections.emptyList();
        this.navgateTo = navgateTo;
    }

    @Override
    @NonNull
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemViewBinding itemViewBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_view,
                parent, false
        );
        return new PhotoViewHolder(itemViewBinding);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        holder.bindPhoto(photos.get(position), navgateTo);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
        notifyDataSetChanged();
    }


}
