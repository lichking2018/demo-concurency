package com.imook.study.commonUnsafe;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ProjectName: concurent
 * @Package: com.imook.study.commonUnsafe
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/17 11:15 PM
 * @Version: v1.0
 */
@Slf4j
public class DateFormatExample {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");



    public static int clientTotal = 5000;

    public static int threadTotal = 200;



    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);

//        计数器向下减的一个闭锁
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for(int i=0;i<clientTotal;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();

    }

    private static void update(){
        try {
            simpleDateFormat.parse("20180208");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
