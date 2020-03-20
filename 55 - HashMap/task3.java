package com.company;

import java.util.HashMap;
import java.util.Random;

public class task3 {
    public static void main(String[] args) {
        Random random = new Random();

        HashMap<Integer, String> digitsMap = new HashMap<>();

        digitsMap.put(1, "ONE");
        digitsMap.put(2, "TWO");
        digitsMap.put(3, "THREE");
        digitsMap.put(4, "FOUR");
        digitsMap.put(5, "FIVE");

        for(int i=0; i<10; i++){
            Integer randomNum = 1 + random.nextInt(10);
            System.out.println(randomNum);

            boolean check = true;

            for(Integer key : digitsMap.keySet()){
                if(key == randomNum)
                    check = false;
            }

            if(check) {
                digitsMap.put(randomNum, "digit" + randomNum);
            }
        }
//-----------------------------------------------------------------------task3

        for(Integer key : digitsMap.keySet()){
            if(key >= 1 && key <=5)
                digitsMap.put(key, "digit"+key);
        }

    }
}
