package com.luying.b_core;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

/**
 * 创建人：luying
 * 创建时间：2017/6/29
 * 类说明：嵌入到一个抽象base的基类，用于回调setContentView和moduleConfig的信息（具体基类的实现也可以用接口的方式组合实现）,
 * 那么到只要再继承于这基类的Activity，那么module就可以拥有Activity共享的生命周期了。
 * 6
 */

public abstract class ModuleManagerActivity extends AppCompatActivity{
    private ActivityModuleManager moduleManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        long ti = System.currentTimeMillis();
        moduleManager = new ActivityModuleManager();
        moduleManager.initModules(savedInstanceState, this, moduleConfig());
        Log.v("ModuleManageActivity","init use time = "+(System.currentTimeMillis() - ti));
    }

    @LayoutRes
    public abstract int getContentViewId();

    public abstract ArrayMap<String, ArrayList<Integer>> moduleConfig();

    @Override
    protected void onResume() {
        super.onResume();
        moduleManager.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        moduleManager.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        moduleManager.onDestroy();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        moduleManager.onConfigurationChanged(newConfig);
    }
}
