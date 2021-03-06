package com.imook.study.immutable;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @ProjectName: concurent
 * @Package: com.imook.study.immutable
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/17 6:35 PM
 * @Version: v1.0
 */
public class ImmutableExample {
    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
//        a=2; 编译的时候就会出现错误
//        b="3";编译的时候就会出现错误
//        map = Maps.newHashMap();编译的时候就会出现错误
//        里面的值是可以修改的
        map.put(1,3);

        System.out.println(map.get(1));//输出3

    }


    private void test(final int a){
//        a=1;编译的时候会报错
    }

}
