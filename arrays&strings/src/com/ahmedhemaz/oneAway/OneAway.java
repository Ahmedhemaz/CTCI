package com.ahmedhemaz.oneAway;

import java.util.HashSet;
import java.util.Set;

public class OneAway {
    //todo solve it with no extra space
    public static void main(String[] args) {
        String str1 = "pale";
        String str2 = "pales";
        String str3 = "pal";
        String str4 = "bale";
        String str5 = "bake";
        String str6 = "";
        String str7 = "a";
        System.out.println(isOneEditAway(str1, str2));
        System.out.println(isOneEditAway(str1, str3));
        System.out.println(isOneEditAway(str1, str4));
        System.out.println(isOneEditAway(str1, str5));
        System.out.println(isOneEditAway(str6, str6));
        System.out.println(isOneEditAway(str7, str7));

    }

    public static boolean isOneEditAway(String str1, String str2) {
        // Time O(N) space(M + N) as N is the HashSet size and M is the added Characters from the other string
        // which at max will be N + 2 Characters as we return once we reaches 2 uniqueCharacters counter
        if(Math.abs(str1.length() - str2.length()) > 1) return false;
        int uniqueCharacters = 0;
        Set<Character> hset = new HashSet<>();
        for(int i = 0; i < str2.length(); i ++) {
            hset.add(str2.charAt(i));
        }
        for(int i = 0; i < str1.length(); i ++) {
            if(hset.add(str1.charAt(i))) {
                uniqueCharacters++;
            }
            if(uniqueCharacters > 1) return false;
        }
        return true;
    }
}
