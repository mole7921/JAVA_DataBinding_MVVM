package com.example.connectframework;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ImageCache.DoubleCache;
import com.example.ImageCache.ImageLoader;
import com.example.ImageCache.MemoryCache;
import com.example.connectframework.databinding.FragmentDetailBinding;
import com.example.connectframework.databinding.FragmentPhotoBinding;
import com.example.viewmodel.NavgateTo;
import com.example.viewmodel.PhotoDetailViewModel;
import com.example.viewmodel.PhotoViewModel;
import com.example.vo.Photo;


public class detailFragment extends BaseFragment implements NavgateTo {

    private FragmentDetailBinding fragmentDetailBinding;
    private PhotoDetailViewModel photoDetailViewModel;
    private Bundle bundle;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        startDataBinding();
    }

    private void getExtrasFromBundle() {
        bundle = getArguments();
        Photo photo = (Photo) bundle.getSerializable("photo");
        photoDetailViewModel = new PhotoDetailViewModel(photo);
        photoDetailViewModel.setNavgateTo(this);
        fragmentDetailBinding.setPhotoDetailViewModel(photoDetailViewModel);
    }


    private void startDataBinding() {
        fragmentDetailBinding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_detail);
        getExtrasFromBundle();
    }

    @Override
    public void naviTo(Bundle bundle) {
           nav().popBackStack();
    }
}