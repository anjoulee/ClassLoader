package com.anjoulee.classloader;


/**
 * @Desc 灏佽鍔犺浇绫荤殑淇℃伅
 * @Author Anjoulee
 * @CreateDte 2017/12/26
 */
//@Data
public class LoadInfo {
	//�Զ���������
    private MyClassLoader myClassLoader;
    //��¼Ҫ���ص����ʱ���-->���ص�ʱ��
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
