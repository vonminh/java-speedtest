package com.speedtest;

import com.utils.CalculationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Simple speed test between Java 8 and traditional implementation.
 *
 * @author vonminh 07/03/2018
 */
public class Main {

    public static void main(String[] args) {

        Random rnd = new Random();
        List<Integer> dataList = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            dataList.add(rnd.nextInt());
        }

        int result;

        long begin = System.currentTimeMillis();
        System.out.println("Calculation starting.....");

        /* Traditional implementation of Java */
//        for(Integer i: dataList){
//            result += CalculationUtils.complicatedFunction(i);
//        }


        /* Java 8 implementation */
        result = dataList.parallelStream()
                .map(x -> CalculationUtils.complicatedFunction(x))
                .reduce(Integer::sum).get();

        long end = System.currentTimeMillis();
        System.out.println("Result = " + result + " in " + (end-begin)/1000 + " seconds");
    }

}
