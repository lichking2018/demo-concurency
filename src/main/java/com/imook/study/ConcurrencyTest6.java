package com.imook.study;

import com.imook.study.annotation.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ProjectName: concurency
 * @Package: com.imook.study
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/4 4:51 PM
 * @Version: v1.0
 */
@ThreadSafe
public class ConcurrencyTest6 {

    private static AtomicBoolean  isHappened = new AtomicBoolean(false);

    public static int clientTotal = 5000;

    public static int threadTotal = 200;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);

//        计数器向下减的一个闭锁
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for(int i=0;i<clientTotal;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        System.out.println("isHappened:"+isHappened.get());
    }

    private static void test(){
        if(isHappened.compareAndSet(false,true)){
            System.out.println("excute");
        }
    }

}
