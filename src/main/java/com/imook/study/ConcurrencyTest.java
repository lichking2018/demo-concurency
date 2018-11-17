package com.imook.study;

import com.imook.study.annotation.NoThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ProjectName: concurency
 * @Package: com.imook.study
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/4 4:51 PM
 * @Version: v1.0
 */
@NoThreadSafe
public class ConcurrencyTest {

    public static int clientTotal = 5000;

    public static int threadTotal = 200;

    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);

//        计数器向下减的一个闭锁
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for(int i=0;i<clientTotal;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count:"+count);
    }

    private static void add(){
        count++;
    }

}
