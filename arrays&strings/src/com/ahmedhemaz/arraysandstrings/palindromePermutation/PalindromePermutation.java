package com.ahmedhemaz.arraysandstrings.palindromePermutation;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    // todo check CTCI solutions
    public static void main(String[] args) {
        String s = "Tact Coa";
        System.out.println(isPalindromePermutation(s));
    }

    public static boolean isPalindromePermutation(String s) {
        // time O(N) space O(N)
        HashMap<Character, Integer> hmap = new HashMap<>();
        int strLength = s.length();
        int oddCounter;
        for(int i = 0; i < s.length(); i ++) {

            char character = s.charAt(i);
            character = Character.toLowerCase(character);
            if (!Character.isAlphabetic(character)) {
                strLength -=1;
                continue;
            };
            if(hmap.containsKey(character)) {
                hmap.put(character, hmap.get(character) + 1);
            }else {
                hmap.put(character, 1);
            }
        }
        oddCounter = countOdds(hmap);
        if(strLength % 2 == 0) {
            return oddCounter <= 0;
        } else {
            return oddCounter <= 1;
        }
    }
    public static int countOdds(HashMap<Character, Integer> hmap) {
        int oddCounter = 0;
        for(Map.Entry<Character, Integer> element : hmap.entrySet()) {
            Integer value = element.getValue();
            if(value % 2 != 0) oddCounter += 1;
        }
        return oddCounter;
    }
}
