package com.imook.study.controller;

/**
 * @ProjectName: concurent
 * @Package: com.imook.study.controller
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/19 11:23 AM
 * @Version: v1.0
 */
public class TestInterfaceImpl implements TestInterface {

    private String baoxiaobing;

    @Override
    public String getUserName() {
        System.out.println("username is zhan1gsan");
        return null;
    }


    private void say(String name, String baoxiaobing){

        baoxiaobing = "baoxiaobing1";
        System.out.println(this.baoxiaobing);
    }

    private void say1(){
        validate();


        validate();
        System.out.println(1231231234);
        System.out.println(123123123);
    }

    private void validate() {
        System.out.println(123123123);
        System.out.println(123123123);
        System.out.println(123123123);
    }
}
