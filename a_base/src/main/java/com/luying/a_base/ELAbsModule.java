package com.luying.a_base;

import android.os.Bundle;

/**
 * 创建人：luying
 * 创建时间：2017/6/28
 * 类说明：仿activity常用生命周期定制module的生命周期
 * 2
 */

public abstract class ELAbsModule {
    public abstract void init(ELModuleContext moduleContext, String extend);
    public abstract void onSaveInstanceState(Bundle outState);
    public abstract void onResume();
    public abstract void onPause();
    public abstract void onStop();
    public abstract void onOrientationChanges(boolean isLandscape);
    public abstract void onDestroy();
}
