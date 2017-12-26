package com.anjoulee.classloader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @DESC 加载manger的工厂
 * @Author Anjoulee
 * @Date 2017/12/26
 */
public class ManagerFactory {
    //记录热加载累的加载信息
    private static final Map<String, LoadInfo> loadTimeMap = new HashMap<String, LoadInfo>();
    //要加载的类的calsspath
    public static final String CLASS_PATH = "E:/ideal/imooc/ClassLoader/bin/";
    //实现热加载的类的全名称（包名+类名）
    public static final String MY_MANGER = "com.anjoulee.classloader.BaseMangerImpl";

    public static BaseManger getManger(String className) {
    	System.out.println(CLASS_PATH + className.replaceAll("\\.", "/") + ".class");
        File loadFile = new File(CLASS_PATH + className.replaceAll("\\.", "/") + ".class");
        long lastModified = loadFile.lastModified();
        //loadTimeMap不包含classname为key的LoadInfo信息，证明这个类没有被加载，那么需要加载这个类到JVM
        if (loadTimeMap.get(className) == null) {
            load(className, lastModified);
        }//加载类的时间戳变化了，我们同样重新记载这个类到JVM
        else if (loadTimeMap.get(className).getLoadTime() != lastModified) {
            load(className, lastModified);
        }
        return loadTimeMap.get(className).getBaseManger();
    }

    /**
     * @Desc 加载类
     * @Author Anjoulee
     * @CreateDte 2017/12/26
     * @Param
     * @Return
     * @Update or Other iNFO
     */
    public static void load(String className, long lastModified) {
        MyClassLoader myClassLoader = new MyClassLoader(CLASS_PATH);
        Class<?> loadClass = null;

        try {
            loadClass = myClassLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        BaseManger baseManger = newInstance(loadClass);
        LoadInfo loadInfo = new LoadInfo(myClassLoader, lastModified);
        loadInfo.setBaseManger(baseManger);
        loadTimeMap.put(className, loadInfo);
    }

    /**
     * @Desc 以反射的方式创建BaseManger的子类对象
     * @Author Anjoulee
     * @CreateDte 2017/12/26
     * @Param
     * @Return
     * @Update or Other iNFO
     */
    private static BaseManger newInstance(Class<?> loadClass) {
        try {
            return (BaseManger) loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
