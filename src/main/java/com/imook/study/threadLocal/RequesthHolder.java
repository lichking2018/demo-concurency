package com.imook.study.threadLocal;

/**
 * @ProjectName: concurent
 * @Package: com.imook.study.threadLocal
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/17 7:19 PM
 * @Version: v1.0
 */
public class RequesthHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();


    /**
     * 请求进入后端服务器，但是还没有进行实际处理的时候，把相关信息写进去。在filter中拦住对应的url，当前台访问了相关的url的时候，
     * 在filter中将相关信息写入threadlocal中
     * 这样，在url被实际处理的时候，就可以从threadlocal中取信息了
     * @param id
     */
    public static void add(Long id){
//        虽然我们只传入了这一个id，但是它会默认的取出当前线程的ID，放到Map里面去，
//        相当于在Map里面，key是当前线程的变量，而value值是当前传入的long型变量
        requestHolder.set(id);
    }

    public static Long getId(){
//        相当于传入了一个当前线程的Id，进入底层存储的map里面去取，得到之前存储过的Id的值
        return requestHolder.get();
    }

    /**
     * 如果不提供移除的方法，那么会造成内存泄露，数据永远不会释放掉，requestHolder类会一直伴随我们的项目，
     * 只有当服务器重新启动的时候，才会被释放
     * 一般是在业务处理完成后，调用这个方法
     *
      */
    public static void remove(){
        requestHolder.remove();
    }
}
