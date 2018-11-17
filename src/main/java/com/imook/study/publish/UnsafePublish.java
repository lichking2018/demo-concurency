package com.imook.study.publish;

import java.util.Arrays;

/**
 * @ProjectName: concurency
 * @Package: com.imook.study.publish
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/13 10:22 PM
 * @Version: v1.0
 */

public class UnsafePublish {

    private String[] states = {"a","b","c"};

    public String[] getStates(){
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        System.out.println(Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0] = "d";
        System.out.println(Arrays.toString(unsafePublish.getStates()));
    }
}
