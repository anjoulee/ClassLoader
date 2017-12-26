package com.anjoulee.classloader;


/**
 * @Desc 鐏忎浇顥婇崝鐘烘祰缁崵娈戞穱鈩冧紖
 * @Author Anjoulee
 * @CreateDte 2017/12/26
 */
//@Data
public class LoadInfo {
	//自定义的类加载
    private MyClassLoader myClassLoader;
    //记录要加载的类的时间戳-->加载的时间
    private long loadTime;

    private BaseManger baseManger;


    public LoadInfo(MyClassLoader myClassLoader, long loadTime) {
        super();
        this.myClassLoader = myClassLoader;
        this.loadTime = loadTime;
    }

    public MyClassLoader getMyClassLoader() {
        return myClassLoader;
    }

    public void setMyClassLoader(MyClassLoader myClassLoader) {
        this.myClassLoader = myClassLoader;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public BaseManger getBaseManger() {
        return baseManger;
    }

    public void setBaseManger(BaseManger baseManger) {
        this.baseManger = baseManger;
    }
}
