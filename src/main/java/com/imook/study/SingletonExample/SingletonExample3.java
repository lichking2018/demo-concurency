package com.imook.study.SingletonExample;

/**
 * 饿汉模式
 * 单例实例在类装载时候创建
 * 线程安全的
 * 缺点，性能可能会有问题
 */
public class SingletonExample3 {

    //私有构造函数
    private SingletonExample3() {
    }
    // 单例对象
    private static SingletonExample3 instance = null;

    public static synchronized SingletonExample3 getInstance(){
        if(instance==null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
