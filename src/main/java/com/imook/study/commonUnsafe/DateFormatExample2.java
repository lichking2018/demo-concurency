package com.imook.study.commonUnsafe;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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
public class DateFormatExample2 {

    public static int clientTotal = 5000;

    public static int threadTotal = 200;

    private static DateTimeFormatter dateTimeFormater = DateTimeFormat.forPattern("yyyyMMdd");


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);

//        计数器向下减的一个闭锁
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for(int i=0;i<clientTotal;i++){
            final int count = i;
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    update(count);
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

    private static void update(int i){
        log.info("{},{}",i,DateTime.parse("20180909",dateTimeFormater).toDate());
    }

}
