package com.imook.study;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @ProjectName: concurency
 * @Package: com.imook.study
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/4 9:49 PM
 * @Version: v1.0
 */
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater
            (AtomicExample5.class,"count");


    public volatile int count = 100;

    public int getCount() {
        return count;
    }

    private static AtomicExample5 example5 = new AtomicExample5();

    public static void main(String[] args) {
        if(updater.compareAndSet(example5,100,120)){
            System.out.println(example5.getCount());
        }
        if(updater.compareAndSet(example5,100,120)){
            System.out.println(example5.getCount());
        }else {
            System.out.println("update fail");
        }
    }
}
