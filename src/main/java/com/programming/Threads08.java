package com.programming;

import java.util.stream.IntStream;

public class Threads08 {
    public static void main(String[] args) {
        Runnable runnable1=new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getId() + ":" +i);
                }
            }
        };

        // Now with functional approach
        Runnable runnable2= ()->{
            IntStream.range(0,1000).forEach( i ->System.out.println(Thread.currentThread().getId()+" : "+i));
            /*for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getId() + ":" +i);
            }*/
        };

        Thread  thread1=new Thread(runnable2);
        thread1.start();
        Thread  thread2=new Thread(runnable2);
        thread2.start();
        Thread  thread3=new Thread(runnable2);
        thread3.start();

    }
}
