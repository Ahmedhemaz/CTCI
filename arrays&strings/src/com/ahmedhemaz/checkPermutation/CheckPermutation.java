package com.ahmedhemaz.checkPermutation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {
    public static void main(String[] args) {
        String str1 = "aabb";
        String str2 = "abab";
//        System.out.println(isPermutationWithSorting(str1, str2));
        System.out.println(isPermutationWithHashMap(str1, str2));
    }
    
    public static boolean isPermutationWithSorting(String str1, String str2) {
        // Time O(nlogn) Space O(1)
        if (str1.length() != str2.length()) return  false;
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        Arrays.sort(str1Arr);
        Arrays.sort(str2Arr);
        for(int i = 0; i < str1Arr.length; i++) {
            if (str1Arr[i] != str2Arr[i]) return  false;
        }
        return  true;
    }
    
    public static boolean isPermutationWithHashMap(String str1, String str2) {
        // Time O(N) and Space(2N) as we have to create 2 hmaps
        if (str1.length() != str2.length()) return  false;
        HashMap<Character, Integer> str1Hmap  = new HashMap<>();
        HashMap<Character, Integer> str2Hmap  = new HashMap<>();
        countCharactersToHashMap(str1, str1Hmap);
        countCharactersToHashMap(str2, str2Hmap);

        for (Map.Entry<Character, Integer> entry :
                str1Hmap.entrySet()) {
            Character ch1 = entry.getKey();
            Integer ch1Counter = entry.getValue();
            Integer ch2Counter = str2Hmap.get(ch1);
            if (!ch1Counter.equals(ch2Counter)) return false;
        }
        return true;
    }
    
    public static void countCharactersToHashMap(String str, HashMap<Character, Integer> hmap) {
        for (int i = 0; i < str.length() ; i++) {
            Character ch = str.charAt(i);
            if (hmap.containsKey(ch)) {
                hmap.put(ch, hmap.get(ch) + 1);
            } else {
              hmap.put(ch, 1);  
            }
        }
    }
    
    
}
