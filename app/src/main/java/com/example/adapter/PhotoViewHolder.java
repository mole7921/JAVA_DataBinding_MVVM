package com.example.adapter;

import android.app.Activity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.connectframework.databinding.ItemViewBinding;
import com.example.viewmodel.NavgateTo;
import com.example.viewmodel.PhotoItemViewModel;
import com.example.vo.Photo;

public class PhotoViewHolder extends RecyclerView.ViewHolder{
    private ItemViewBinding itemViewBinding;


    public PhotoViewHolder(ItemViewBinding itemViewBinding) {
        super(itemViewBinding.itemPhoto);
        this.itemViewBinding = itemViewBinding;
    }

    void bindPhoto(Photo photo, NavgateTo navgateTo) {
        if (itemViewBinding.getPhotoItemViewModel() == null) {
            itemViewBinding.setPhotoItemViewModel(new PhotoItemViewModel(photo,navgateTo));
        } else {
            itemViewBinding.getPhotoItemViewModel().setPhoto(photo);
        }
    }
}
