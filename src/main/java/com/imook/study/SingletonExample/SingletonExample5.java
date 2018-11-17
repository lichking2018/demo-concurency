package com.imook.study.SingletonExample;

/**
 * 双重同步锁模式
 * 线程安全的
 */
public class SingletonExample5 {

    //私有构造函数
    private SingletonExample5() {
    }
    // 单例对象，添加了volatile后，就不会出现指令重排
    private volatile static SingletonExample5 instance = null;


    //线程B有可能拿到还没有初始化的对象
    public static SingletonExample5 getInstance(){
        //双重检测机制
        if(instance==null){ //B
            //同步锁
            synchronized (SingletonExample5.class){
                if(instance==null) {
                    instance = new SingletonExample5(); //A
                }
            }
        }
        return instance;
    }
}
