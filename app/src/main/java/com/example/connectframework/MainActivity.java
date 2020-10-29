package com.example.connectframework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.ImageCache.DoubleCache;
import com.example.ImageCache.ImageLoader;
import com.example.okhttp.okhttpUtil;
import com.example.viewmodel.NavgateTo;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}