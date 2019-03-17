package com.java.proxy.bean;

/**
 * @author lixiongxiong
 * @date 2019/3/17
 * @description proxy
 */
public class MethodProxy {


    private long start;

    private long end;

    private String serviceMethod;

    public  MethodProxy(String serviceMethod){
        this.serviceMethod = serviceMethod;
        this.start = System.currentTimeMillis();
    }

    public void printPerformance(){
        end = System.currentTimeMillis();
        System.out.println(this.serviceMethod+" spend "+ (end-start) +" ms");
    }

}
