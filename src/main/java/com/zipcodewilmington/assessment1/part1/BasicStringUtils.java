package com.zipcodewilmington.assessment1.part1;

/**
 * Created by leon on 2/16/18.
 */
public class BasicStringUtils {
    /**
     * @param str string input from client
     * @return string with identical content, and the first character capitalized
     */
    public static String camelCase(String str) {
        String[] strArray = str.split("");
        strArray[0] = strArray[0].toUpperCase();
        String answer = "";
        for (String s: strArray) {
            answer += s;
        }
        return answer;
    }

    /**
     * @param str string input from client
     * @return string with identical contents, in the reverse order
     */
    public static String reverse(String str) {
        String[] strArray = str.split("");
        String answer = "";
        for (int i = str.length() - 1; i >= 0 ; i--) {
            answer += strArray[i];
        }
        return answer;
    }

    /**
     * @param str string input from client
     * @return string with identical contents, in reverse order, with first character capitalized
     */
    public static String reverseThenCamelCase(String str) {
        String reversed = reverse(str);
        String camelCased = camelCase(reversed);
        return camelCased;
    }


    /**
     * @param str a string input from user
     * @return string with identical contents excluding first and last character
     */
    public static String removeFirstAndLastCharacter(String str) {
        String[] strArray = str.split("");
        String answer = "";
        for (int i = 1; i < strArray.length - 1 ; i++){
            answer += strArray[i];
        }
        return answer;
    }

    /**
     * @param str a string input from user
     * @return string with identical characters, each with opposite casing
     */
    public static String invertCasing(String str) {
        Character[] strCharacters = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            strCharacters[i] = str.charAt(i);
        }
        String answer = "";
        for (Character c : strCharacters){
            answer += recase(c);
        }
        return answer;
    }

    private static String recase(Character c) {
        Character recased = c;
        if (c >= 'A' && c <= 'Z'){
            for (int i = 0; i < 32; i++) {
                recased++;
            }
        }
        else if (c >= 'a' && c <= 'z'){
            for (int i = 0; i < 32; i++) {
                recased--;
            }
        }
        String answer = "" + recased;
        return answer;
    }
}
