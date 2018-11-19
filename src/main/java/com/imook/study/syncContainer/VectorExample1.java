package com.imook.study.syncContainer;

import lombok.extern.slf4j.Slf4j;

import java.util.Vector;

/**
 * @ProjectName: concurent
 * @Package: com.imook.study.commonUnsafe
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/17 11:49 PM
 * @Version: v1.0
 */
@Slf4j
public class VectorExample1 {
    public static int clientTotal = 5000;

    public static int threadTotal = 200;


    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {

        while(true){
            for(int i=0;i<10;i++){
                vector.add(i);
            }

            Thread thread = new Thread(){
                public void run(){
                    for(int i=0;i<10;i++){
                        vector.remove(i);
                    }
                }
            };

            Thread thread1 = new Thread(){
                public void run(){
                    for(int i=0;i<10;i++){
                        vector.get(i);
                    }
                }
            };

            thread.start();
            thread1.start();
        }


    }
}
