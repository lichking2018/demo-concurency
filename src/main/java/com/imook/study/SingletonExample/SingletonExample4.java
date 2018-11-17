package com.imook.study.SingletonExample;

/**
 * 双重同步锁模式
 * 线程不安全
 */
public class SingletonExample4 {

    //私有构造函数
    private SingletonExample4() {
    }
    // 单例对象
    private static SingletonExample4 instance = null;

    //1、memory = allocate() 分配对象内存空间
    //2、ctorInstance() 初始化对象
    //3、instance = memory 设置instance指向刚分配的内存

    // JVM和cpu优化，发生指令重排

    //1、memory = allocate() 分配对象内存空间
    //3、instance = memory 设置instance指向刚分配的内存
    //2、ctorInstance() 初始化对象

    //线程B有可能拿到还没有初始化的对象
    public static SingletonExample4 getInstance(){
        //双重检测机制
        if(instance==null){ //B
            //同步锁
            synchronized (SingletonExample4.class){
                if(instance==null) {
                    instance = new SingletonExample4(); //A
                }
            }
        }
        return instance;
    }
}
