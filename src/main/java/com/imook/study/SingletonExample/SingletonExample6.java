package com.imook.study.SingletonExample;

/**
 * 饿汉模式
 * 单例实例在类装载的时候进行创建
 * 线程安全的
 * 缺点，如果类的构造方法中包含过多的处理，导致类加载的时候特别慢，可能引起性能问题。如果类在实际过程中，没有被使用，那么会造成资源浪费
 */
public class SingletonExample6 {

    //私有构造函数
    private SingletonExample6() {
    }



    // 单例对象
    private static SingletonExample6 instance = null;

    //执行顺序很重要，如果放在上方代码之前，那么会打印出null。造成这个问题的原因是 instance被实例化后，再经历=null的操作，因此出现问题
    static {
        instance = new SingletonExample6();
    }

    public static SingletonExample6 getInstance(){
        return instance;
    }


    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}
