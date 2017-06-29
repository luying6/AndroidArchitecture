package com.luying.androidarchitecture;

import android.support.v4.util.ArrayMap;

import com.luying.b_core.ModuleManagerActivity;

import java.util.ArrayList;

/**
 * 创建人：luying
 * 创建时间：2017/6/29
 * 类说明：
 */

public class ModuleMainActivity extends ModuleManagerActivity {

    @Override
    public int getContentViewId() {
        return R.layout.activity_main_module;
    }

    @Override
    public ArrayMap<String, ArrayList<Integer>> moduleConfig() {
        ArrayMap<String, ArrayList<Integer>> map = new ArrayMap<>();
//        map.put()
        return null;
    }
}
