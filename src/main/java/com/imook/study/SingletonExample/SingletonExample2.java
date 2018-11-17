package com.imook.study.SingletonExample;

/**
 * 饿汉模式
 * 单例实例在类装载的时候进行创建
 * 线程安全的
 * 缺点，如果类的构造方法中包含过多的处理，导致类加载的时候特别慢，可能引起性能问题。如果类在实际过程中，没有被使用，那么会造成资源浪费
 */
public class SingletonExample2 {

    //私有构造函数
    private SingletonExample2() {
    }
    // 单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance(){
        return instance;
    }
}
