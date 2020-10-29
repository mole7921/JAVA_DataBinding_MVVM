package com.example.connectframework;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.adapter.PhotoAdapter;
import com.example.connectframework.databinding.FragmentPhotoBinding;
import com.example.viewmodel.NavgateTo;
import com.example.viewmodel.PhotoItemViewModel;
import com.example.viewmodel.PhotoViewModel;
import java.util.Observable;
import java.util.Observer;



public class photoFragment extends BaseFragment implements Observer, NavgateTo {

    private FragmentPhotoBinding fragmentPhotoBinding;
    private PhotoViewModel photoViewModel;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        startDataBinding();
        createPhotoList(fragmentPhotoBinding.recycleView);
        setUpObserver(photoViewModel);

    }


    private void startDataBinding() {

        fragmentPhotoBinding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_photo);
        photoViewModel = new PhotoViewModel(getActivity());
        fragmentPhotoBinding.setPhotoViewModel(photoViewModel);
    }

    private void createPhotoList(RecyclerView photoList) {
        PhotoAdapter adapter = new PhotoAdapter(this);
        photoList.setAdapter(adapter);
        photoList.setLayoutManager(new GridLayoutManager(getActivity(), 4));
    }


    private void setUpObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object data) {
        if (observable instanceof PhotoViewModel) {
            PhotoAdapter photoAdapter = (PhotoAdapter) fragmentPhotoBinding.recycleView.getAdapter();
            PhotoViewModel photoViewModel = (PhotoViewModel) observable;
            photoAdapter.setPhotos(photoViewModel.getPhotos());
        }
    }


    @Override
    public void naviTo(Bundle bundle) {
            nav().navigate(R.id.action_photoFragment_to_detailFragment,bundle);
    }

}