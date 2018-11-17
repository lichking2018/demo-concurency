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
public class SyncExample1 {

    public void test1(int j){
        synchronized (this){
            for (int i=0;i<10;i++){
                System.out.println("test1 "+j+"-"+i);
            }
        }
    }

    public synchronized  void test2(){
        for (int i=0;i<10;i++){
            System.out.println("test2"+i);
        }
    }

    public static void main(String[] args) {
        SyncExample1 example1 = new SyncExample1();
        SyncExample1 example2 = new SyncExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(()->{
            example1.test1(1);
        });
        executorService.execute(()->{
            example2.test1(2);
        });
    }
}
