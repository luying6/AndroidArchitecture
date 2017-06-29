package com.luying.androidarchitecture;

import android.support.v4.util.ArrayMap;

import com.luying.a_base.ModuleManagerActivity;

import java.util.ArrayList;

/**
 * 创建人：luying
 * 创建时间：2017/6/29
 * 类说明：
 */

public class ModuleMainActivity extends ModuleManagerActivity{

    @Override
    public int getContentViewId() {
        return 0;
    }

    @Override
    public ArrayMap<String, ArrayList<Integer>> moduleConfig() {
        return null;
    }
}
