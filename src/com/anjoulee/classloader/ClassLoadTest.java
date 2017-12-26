package com.anjoulee.classloader;

/**
 * @DESC 测试JAVA类的热加载
 * @Author Anjoulee
 * @Date 2017/12/26
 */
public class ClassLoadTest {
    public static void main(String[] args) {
        new Thread(new MsgHandler()).start();
    }
}
