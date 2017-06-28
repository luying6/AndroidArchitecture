package com.luying.a_base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * 创建人：luying
 * 创建时间：2017/6/28
 * 类说明：然后扩展一个initModule的方法来，保存saveInstance,Activity和modules信息实例
 * 5
 */

public class ActivityModuleManager extends ModuleManager{
    private static final String TAG = "ActivityModuleManager";
    public void initModules(Bundle saveInstance, Activity activity, ArrayMap<String,ArrayList<Integer>> modules){
        if (activity == null || modules == null){
            return;
        }
        moduleConfig(modules);
        initModules(saveInstance, activity);
    }

    private void initModules(Bundle saveInstance, Activity activity) {
        if (getModules() == null) return;
        ELModuleContext moduleContext = new ELModuleContext();
        moduleContext.setActivity(activity);
        moduleContext.setSaveInstance(saveInstance);

        //获取配置
        for (String moduleName: getModules().keySet()){
            ELAbsModule module = ELModuleFactory.newModuleInstance(moduleName);
            Log.d(TAG, "ActivityModuleManager init module name: "+ moduleName);

            if (module!= null){
                //关联视图
                SparseArrayCompat<ViewGroup> viewGroup = new SparseArrayCompat<>();
                ArrayList<Integer> mViewIds = getModules().get(moduleName);
                if (mViewIds != null && mViewIds.size() > 0){
                    for (int i = 0; i < mViewIds.size(); i++){
                        viewGroup.put(i, (ViewGroup) activity.findViewById(mViewIds.get(i).intValue()));
                    }
                }
                moduleContext.setViewGroups(viewGroup);
                module.init(moduleContext, "");
                allModules.put(moduleName, module);
            }
        }
    }
}
