package com.ahmedhemaz.uniqueCharacters;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueCharacters {

    public static void main(String[] args) {
        String test1 = "asda";
        String test2 = "asd";
        String test3 = "as";
        String test4 = "a";
        String test5 = "";
        String test6 = "asdhqawdgiuajfhoqwhf1q2uhasjfjadfkbiASDafdhagASDAGFT";

        System.out.println(isCharsUniqueWithoutExtraSpace(test1));
        System.out.println(isCharsUniqueWithoutExtraSpace(test2));
        System.out.println(isCharsUniqueWithoutExtraSpace(test3));
        System.out.println(isCharsUniqueWithoutExtraSpace(test4));
        System.out.println(isCharsUniqueWithoutExtraSpace(test5));
        System.out.println(isCharsUniqueWithoutExtraSpace(test6));

    }

    public  static  boolean isCharsUnique(String str) {
        // O(n) time O(n) space
        if (str.length() == 1 || str.length() == 0) return  true;
        Set<Character> hset = new HashSet<>();
        for(int i = 0; i < str.length(); i ++) {
            if(!hset.add(str.charAt(i))) return false;
        }
        return  true;
    }

    public static boolean isCharsUniqueWithoutExtraSpace(String str) {
        // O(n^2) time O(1) space
        int firstIdx = 0;
        int secondIdx = firstIdx +1;
        boolean isCharsUnique = true;
        if (str.length() == 1 || str.length() == 0) return  true;
        while (firstIdx < str.length()-1) {
            char firstIdxChar = str.charAt(firstIdx);
            char secondIdxChar = str.charAt(secondIdx);
            if (secondIdxChar != firstIdxChar) {
                secondIdx++;
            } else {
                isCharsUnique = false;
                break;
            }
            if (secondIdx == str.length()){
                firstIdx++;
                secondIdx = firstIdx+1;
            }
        }
        return isCharsUnique;
    }

    public static boolean isUniqueWithSorting(String str) {
        // O(N Log(n)) time O(1) space as we are using quick sort
        // but we might have O(n^2) time if the string is partially sorted
        if (str.length() == 1 || str.length() == 0) return  true;
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        for(int i = 0; i < chs.length - 1; i++) {
            if(chs[i] == chs[i+1]) return  false;
        }
        return  true;
    }
}
