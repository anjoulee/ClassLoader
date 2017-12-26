package com.anjoulee.classloader;

/**
 * @DESC 后台启动一条线层不断刷新重新加载实现了热加载的类
 * @Author Anjoulee
 * @Date 2017/12/26
 */
public class MsgHandler implements Runnable {

    @Override
    public void run() {
        while (true) {
            BaseManger baseManger = ManagerFactory.getManger(ManagerFactory.MY_MANGER);
            baseManger.logic();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
