package com.ahmedhemaz.arraysandstrings.urlify;

public class URLfiy {
    public static void main(String[] args) {
        String str = "Mr John Smith";
        String str1 = "Ahmed Ahmed";
        String str2 = " Ahmed Ahmed";
        String str3 = " Ahmed Ahmed ";
        char[] chars = URLify(str3, 13);
        System.out.println(chars);
    }

    public static char[] URLify(String str, int lengthOfString) {
        if(str.length() == 0) return new char[] {};
        char[] chs = str.toCharArray();
        int spacesCounter = findSpacesCount(chs, lengthOfString);
        return replaceSpaces(chs, lengthOfString, spacesCounter);
    }

    public static int findSpacesCount(char[] chs, int lengthOfString) {
        int spacesCounter = 0;
        for(int i = 0; i < lengthOfString; i ++) {
            char ch = chs[i];
            if(ch == ' ') spacesCounter++;
        }
        return spacesCounter;
    }

    public static char[] replaceSpaces(char[] chs, int lengthOfString, int spacesCounter) {
        char[] urlifiedString = new char[lengthOfString + spacesCounter * 2];
        int originalStringPointer = 0;
        int urlifiedStringPointer = 0;
        while(originalStringPointer < chs.length) {
            char currentChar = chs[originalStringPointer];
            if(!isSpace(currentChar)) {
                urlifiedString[urlifiedStringPointer] = currentChar;
                urlifiedStringPointer++;
            }else{
                replaceSpace(urlifiedString, urlifiedStringPointer);
                urlifiedStringPointer += 3;
            }
            originalStringPointer++;
        }
        return urlifiedString;
    }

    public static boolean isSpace(char ch) {
        return ch == ' ';
    }

    public static void replaceSpace(char[] chs, int idx) {
        chs[idx] = '%';
        chs[idx + 1] = '2';
        chs[idx + 2] = '0';
    }
}
