package com.example.connectframework;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.connectframework.databinding.FragmentDetailBinding;
import com.example.viewmodel.NavgateTo;
import com.example.viewmodel.PhotoDetailViewModel;
import com.example.vo.Photo;

//宮格圖片點擊呈現的內頁
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