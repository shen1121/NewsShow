package com.example.newsshow.utils;

import com.example.newsshow.MyApplication;

/**
 * Created by Administrator on 2017/11/20.
 */

public class DeminUtils {

    public static float dp2px(float dp) {
        final float scale = MyApplication.getInstance().getResources().getDisplayMetrics().densityDpi;
        return dp * scale + 0.5f;
    }

    public  static  float sp2ox(float sp){
       final float scale = MyApplication.getInstance().getResources().getDisplayMetrics().scaledDensity;
        return  sp*scale+0.5f;
    }

    public  static  int getSreenSize(){
        return  MyApplication.getInstance().getResources().getDisplayMetrics().widthPixels;
    }
}
