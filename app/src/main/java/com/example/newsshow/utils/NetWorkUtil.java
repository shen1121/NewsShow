package com.example.newsshow.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.example.newsshow.MyApplication;

/**
 * Created by Administrator on 2017/11/16.
 */

public class NetWorkUtil {

/*
  检查网络是否有效
 */
    public  static  boolean isNetworkAvaiable(){
        ConnectivityManager connectivityManager = (ConnectivityManager) MyApplication.getInstance().
                getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (connectivityManager!=null){
            NetworkInfo Info = connectivityManager.getActiveNetworkInfo();
            if (Info!=null&&Info.isConnected()){
                 if (Info.getState()==NetworkInfo.State.CONNECTED){
                     return  true;
                 }
            }
        }
        return false;
    }

    /*
      网络错误信息
     */
    public  static  boolean isNetworkErrShowMsg(){

        if (!isNetworkAvaiable()){
            ToastUtils.shortToast(MyApplication.getInstance(),"网络连接错误");
            return false;
        }
        return true;

    }


}
