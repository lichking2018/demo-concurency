package com.imook.study.SingletonExample;

/**
 * 饿汉模式
 * 单例实例在类装载时候创建
 * 线程不安全的
 */
public class SingletonExample1 {

    //私有构造函数
    private SingletonExample1() {
    }
    // 单例对象
    private static SingletonExample1 instance = null;

    //静态工厂方法。这种方式下，会存在线程安全的问题，第20行~23行
    public static SingletonExample1 getInstance(){
        //两个线程同时执行到这里，就会重复创建两次对象，两个线程拿到的对象不一致
        if(instance==null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
