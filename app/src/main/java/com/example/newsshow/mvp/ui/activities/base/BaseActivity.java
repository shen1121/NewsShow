package com.example.newsshow.mvp.ui.activities.base;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.example.newsshow.MainActivity;
import com.example.newsshow.R;
import com.example.newsshow.di.component.AppComponent;
import com.example.newsshow.mvp.presenter.interfaces.BasePresenter;
import com.example.newsshow.utils.SharePreferenceUtils;

import rx.Subscription;

/**
 * Created by Administrator on 2017/11/15.
 */

public  abstract class BaseActivity<T extends BasePresenter>  extends AppCompatActivity {
     protected  T mPresneter;
    public  abstract int getLayoutId();
    public  abstract void initVariable();
    public  abstract  void  initView();
    public Subscription subscription;
    private  boolean ismIsAddView;
    private View mNightView;
    private WindowManager mWindowManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
          setNigthorDayMode();//设置主题
        //填充布局
      int layoutId =  getLayoutId();
        setContentView(layoutId);
        //定义变量或读取传递参数
        initVariable();
        //初始化view
        initView();
        initToolBar();
        initData();

    }

    private void initToolBar() {
            if (!(this instanceof MainActivity)){
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);
            }

    }


    //提供AppComponent(提供所有的单例对象)给子类，进行Component依赖
    protected abstract void setupActivityComponent(AppComponent appComponent);

    private void setNigthorDayMode() {
        if (SharePreferenceUtils.isNigthMode()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
          initNightView();
           mNightView.setBackgroundResource(R.color.night_mask);
        }else{

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

    }

    public  boolean ismIsAddView(){
        return  ismIsAddView;
    }

    public  void setIsAddView(boolean isAddView){
        this.ismIsAddView=isAddView;
    }

    private void  initNightView() {
        if (ismIsAddView){
            return ;
        }
        WindowManager.LayoutParams ningthViewParams=  new WindowManager.LayoutParams(
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSPARENT
        );
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mNightView = new View(this);
        mWindowManager.addView(mNightView,ningthViewParams);
     ismIsAddView=true;
    }


    protected void initData(){
        if (mPresneter!=null){
            mPresneter.onDestory();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresneter!=null){
            mPresneter.onDestory();
        }
        removeNigthModel();
        if (subscription!=null&&subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }

    private void  removeNigthModel() {
        if (ismIsAddView){
            mWindowManager.removeViewImmediate(mNightView);
            mWindowManager=null;
            mNightView=null;

        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home_news:
                if (Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP){
                    finishAfterTransition();
                }else{
                   finish();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
