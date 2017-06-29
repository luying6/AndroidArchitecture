package com.luying.b_core.util;

import java.util.Map;

/**
 * 创建人：luying
 * 创建时间：2017/6/28
 * 类说明：
 */

public class ModuleUtil {
    public static boolean empty(Map<?,?> c){
        return c == null || c.isEmpty();
    }

    public static boolean empty(String s){
        return s == null || s.isEmpty();
    }
}
