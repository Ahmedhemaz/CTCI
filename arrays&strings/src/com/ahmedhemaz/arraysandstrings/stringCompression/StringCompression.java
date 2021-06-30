package com.ahmedhemaz.arraysandstrings.stringCompression;

public class StringCompression {
    public static void main(String[] args) {
        String test = "bbbasdddd";
        System.out.println(compress(test));
    }

    //todo check CTCI solution and modify the code
    public static String compress(String str) {
        if (str.length() <= 1) return str;
        StringBuilder sb = new StringBuilder();
        int currentCharacterCounter = 1;
        char previousCharacter = str.charAt(0);
        sb.append(previousCharacter);
        for(int i = 1; i < str.length(); i ++) {
            char currentCharacter = str.charAt(i);
            if(currentCharacter != previousCharacter) {
                previousCharacter = currentCharacter;
                sb.append(currentCharacterCounter).append(previousCharacter);
                currentCharacterCounter = 1;
            } else {
                currentCharacterCounter++;
            }
        }
        sb.append(currentCharacterCounter);
        String compressedString = sb.toString();
        return compressedString.length() < str.length() ? compressedString : str;
    }
}
