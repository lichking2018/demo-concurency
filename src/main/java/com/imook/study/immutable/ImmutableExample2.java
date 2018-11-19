package com.imook.study.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

/**
 * @ProjectName: concurent
 * @Package: com.imook.study.immutable
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/17 6:35 PM
 * @Version: v1.0
 */
public class ImmutableExample2 {
//    初始化的时候，可以直接赋值
    private final static ImmutableList list = ImmutableList.of(1,2,3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer,Integer> map = ImmutableMap.of(1,2,3,4);

    private final static ImmutableMap<Integer,Integer> map1 = ImmutableMap.<Integer,Integer>builder().put(1,2).build();

    public static void main(String[] args) {
//        运行时报错
//        list.add(4);
//        运行时报错
//        set.add(4);
//        运行时报错
//        map.put(1,6);
//        运行报错
//        map1.put(6,7);
    }


}
