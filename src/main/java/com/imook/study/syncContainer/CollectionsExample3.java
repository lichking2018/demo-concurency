package com.imook.study.syncContainer;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ProjectName: concurent
 * @Package: com.imook.study.commonUnsafe
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/17 11:49 PM
 * @Version: v1.0
 */
@Slf4j
public class CollectionsExample3 {
    public static int clientTotal = 5000;

    public static int threadTotal = 200;


    private static Map<Integer,Integer> map = Collections.synchronizedMap(Maps.newHashMap());

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);

        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);


        for(int i=0;i<clientTotal;i++){
            final int count = i;
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add(count);
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        log.info("list size:{}",map.size());
    }

    private static void add(int i){
        map.put(i,i);
    }

}
