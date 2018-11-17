package com.imook.study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ProjectName: concurency
 * @Package: com.imook.study
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/4 10:22 PM
 * @Version: v1.0
 */
public class SyncExample2 {

    public static void test1(int j){
        synchronized (SyncExample2.class){
            for (int i=0;i<10;i++){
                System.out.println("test1 "+j+"-"+i);
            }
        }
    }

    public  static synchronized  void test2(int j){
        for (int i=0;i<10;i++){
            System.out.println("test2 "+j+"-"+i);
        }
    }

    public static void main(String[] args) {
        SyncExample2 example1 = new SyncExample2();
        SyncExample2 example2 = new SyncExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(()->{
            example1.test2(1);
        });
        executorService.execute(()->{
            example2.test2(2);
        });
    }
}
