package com.company;

import java.util.HashMap;

public class task1 {
    public static void main(String[] args) {
        HashMap<Integer, String> digitsMap = new HashMap<>();

        digitsMap.put(1, "ONE");
        digitsMap.put(2, "TWO");
        digitsMap.put(3, "THREE");
        digitsMap.put(4, "FOUR");
        digitsMap.put(5, "FIVE");

        for(Integer key : digitsMap.keySet()){
            System.out.println(key + ": " + digitsMap.get(key));
        }
    }
}
