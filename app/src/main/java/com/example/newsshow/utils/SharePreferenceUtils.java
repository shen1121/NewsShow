package com.example.newsshow.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.newsshow.MyApplication;

/**
 * Created by Administrator on 2017/11/15.
 */

public class SharePreferenceUtils {

    public  static  final  String SHARE_NEWS = "share_news";
    public  static  final  String NIGTH_THEME_MODE="night_theme_mode";

    public  static SharedPreferences getSharePreference(){
        return MyApplication.getInstance().getSharedPreferences(SHARE_NEWS, Context.MODE_PRIVATE);
    }

    public  static  boolean isNigthMode(){
        return  getSharePreference().getBoolean(NIGTH_THEME_MODE,false);
    }

    public  static  void saveNigthMode(boolean isNigth){
         getSharePreference().edit().putBoolean(NIGTH_THEME_MODE,isNigth).apply();
    }
}
