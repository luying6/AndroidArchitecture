package com.luying.a_base;

/**
 * 创建人：luying
 * 创建时间：2017/6/28
 * 类说明：反射获取Module的继承类
 */

public class ELModuleFactory {
    public static ELAbsModule newModuleInstance(String name){
        if (name == null || name.equals("")){
            return null;
        }
        try{
            Class<? extends  ELAbsModule> modulesClass = (Class<? extends ELAbsModule>) Class.forName(name);
            if (modulesClass != null){
                ELAbsModule instance = modulesClass.newInstance();
                return instance;
            }
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
