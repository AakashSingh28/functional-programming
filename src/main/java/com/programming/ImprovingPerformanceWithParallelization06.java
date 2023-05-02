package com.programming;

import java.util.stream.LongStream;

public class ImprovingPerformanceWithParallelization06 {
    public static void main(String[] args) {
         long time=System.currentTimeMillis();
     //   System.out.println(LongStream.range(0,1000000000).sum());   //400 ms
        System.out.println(LongStream.range(0,1000000000).parallel().sum());  //131 ms
        System.out.println(System.currentTimeMillis()-time+" ms");
    }
}
