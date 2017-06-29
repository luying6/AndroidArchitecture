package com.luying.b_core;


import android.content.res.Configuration;
import android.support.v4.util.ArrayMap;

import com.luying.util.ModuleUtil;

import java.util.ArrayList;

/**
 * 创建人：luying
 * 创建时间：2017/6/28
 * 类说明：Module的生命周期管理类
 * 3
 */

public class ModuleManager {
    //使用ArrayMap代替HashMap,方便和视图关联
    private ArrayMap<String, ArrayList<Integer>> modules = new ArrayMap<>();
    protected ArrayMap<String, ELAbsModule> allModules = new ArrayMap<>();

    public ArrayMap<String, ArrayList<Integer>> getModules() {
        return modules;
    }

    public void setModules(ArrayMap<String, ArrayList<Integer>> modules) {
        this.modules = modules;
    }

    public void moduleConfig(ArrayMap<String, ArrayList<Integer>> modules) {
        this.modules = modules;
    }

    public ELAbsModule getModuleByNames(String name) {
        if (!ModuleUtil.empty(allModules)) {
            return allModules.get(name);
        }
        return null;
    }

    public void putModule(String name, ELAbsModule module) {
        allModules.put(name, module);
    }

    public void removeMdule(String name, ELAbsModule module) {
        allModules.remove(name);
    }

    public void onResume() {
        for (ELAbsModule module : allModules.values())
            if (module != null)
                module.onResume();
    }

    public void onPause() {
        for (ELAbsModule module : allModules.values())
            if (module != null)
                module.onPause();
    }

    public void onStop(){
        for (ELAbsModule module: allModules.values())
            if (module != null)
                module.onStop();
    }

    public void onConfigurationChanged(Configuration newConfig){
        for (ELAbsModule module:allModules.values())
            if (module != null)
                module.onOrientationChanges(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE);
    }

    public void onDestroy(){
        for (ELAbsModule module:allModules.values())
            if (module != null)
                module.onDestroy();
    }

}
