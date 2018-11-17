package com.imook.study.publish;

/**
 * @ProjectName: concurency
 * @Package: com.imook.study.publish
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/13 10:31 PM
 * @Version: v1.0
 */
public class Escape {
    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass{
        public InnerClass() {
            System.out.println(Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        Escape escape = new Escape();

    }
}
