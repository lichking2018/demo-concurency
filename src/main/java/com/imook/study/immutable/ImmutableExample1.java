package com.imook.study.immutable;

import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Map;

/**
 * @ProjectName: concurent
 * @Package: com.imook.study.immutable
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/17 6:35 PM
 * @Version: v1.0
 */
public class ImmutableExample1 {

    private static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
//        将map变为不可被修改的
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
//      在运行时会抛出异常
        map.put(1,3);

        System.out.println(map.get(1));//输出3

    }


}
