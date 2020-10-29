package com.example.viewmodel;

import android.view.View;
import java.util.Observable;

public class MainViewModel extends Observable {
    private NavgateTo navgateTo;

    public void setNavgateTo(NavgateTo navgateTo){
        this.navgateTo = navgateTo;
    }

    public void onItemClick(View view) {
        navgateTo.naviTo(null);
    }

}
