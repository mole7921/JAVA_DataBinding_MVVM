package com.example.connectframework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.ImageCache.DoubleCache;
import com.example.ImageCache.ImageLoader;
import com.example.okhttp.okhttpUtil;
import com.example.viewmodel.NavgateTo;

import java.io.IOException;

//主Activity、Fragment Host
public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_EXTERNAL_STORAGE_CODE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS,
    };

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE_CODE
            );
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verifyStoragePermissions(this);
    }


}