package com.luying.a_base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.util.SparseArrayCompat;
import android.view.ViewGroup;

/**
 * 创建人：luying
 * 创建时间：2017/6/28
 * 类说明：用来保存activity类里面的内容
 * 1
 */

public class ELModuleContext {
    public static final int TOP_VIEW_GROUP = 0;
    public static final int BOTTOM_VIEW_GROUP = 1;
    public static final int PLUGIN_CENTER_VIEW = 2;
    private Activity context;
    private Bundle saveInstance;
    private SparseArrayCompat<ViewGroup> viewGroups = new SparseArrayCompat<>();

    public Activity getContext() {
        return context;
    }

    public void setContext(Activity context) {
        this.context = context;
    }

    public Bundle getSaveInstance() {
        return saveInstance;
    }

    public void setSaveInstance(Bundle saveInstance) {
        this.saveInstance = saveInstance;
    }

    public SparseArrayCompat<ViewGroup> getViewGroups() {
        return viewGroups;
    }

    public void setViewGroups(SparseArrayCompat<ViewGroup> viewGroups) {
        this.viewGroups = viewGroups;
    }
}
