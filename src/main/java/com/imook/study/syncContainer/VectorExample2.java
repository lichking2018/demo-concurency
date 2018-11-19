package com.imook.study.syncContainer;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
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
public class VectorExample2 {
//    java.util.ConcurrentModificationException
    private static void test1(Vector<Integer> v){
        for(Integer i:v){
            if(i.equals(3)){
                v.remove(i);
            }
        }
    }
//java.util.ConcurrentModificationException
    private static void test2(Vector<Integer> v){
        Iterator<Integer> iterator = v.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            v.remove(i);
        }
    }

    private static void test3(Vector<Integer> v){
        for(int i=0;i<v.size();i++){
            if(v.get(i).equals(3)){
                v.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
//        test1(vector);
//        test2(vector);

        test3(vector);
    }
}
