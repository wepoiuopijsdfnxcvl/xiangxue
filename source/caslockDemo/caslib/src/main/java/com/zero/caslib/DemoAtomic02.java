package com.zero.caslib;

import java.util.concurrent.atomic.AtomicInteger;


public class DemoAtomic02 {
//    volatile int i=0;
    AtomicInteger i = new AtomicInteger(0);
    public void incr(){
//        i++;
        i.incrementAndGet();//对变量进行加1操作，并返回(这个是一个原子操作)
    }
    public static void main(String[] args) throws Exception{
        DemoAtomic02 lockDemo = new DemoAtomic02();
        for(int j =0;j<2;j++){
            new Thread(() ->{
                for(int k =0;k<10000;k++){
                    lockDemo.incr();
                }
            }
            ).start();
        }
        Thread.sleep(1000L);
        System.out.println(lockDemo.i);
    }

}