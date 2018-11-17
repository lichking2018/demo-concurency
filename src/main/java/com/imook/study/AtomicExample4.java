package com.imook.study;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @ProjectName: concurency
 * @Package: com.imook.study
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/4 9:49 PM
 * @Version: v1.0
 */
public class AtomicExample4 {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0,2);
        count.compareAndSet(0,1);
        count.compareAndSet(1,3);
        count.compareAndSet(2,4);
        count.compareAndSet(3,5);
        System.out.println(count.get());//4
    }
}
