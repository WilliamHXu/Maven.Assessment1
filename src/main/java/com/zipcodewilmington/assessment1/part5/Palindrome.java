package com.zipcodewilmington.assessment1.part5;

import com.zipcodewilmington.assessment1.part1.BasicStringUtils;

public class Palindrome {

    public Integer countPalindromes(String input) {
        Integer count = 0;
        String temp = input;
        for (int index = 0; index < input.length(); index++){
            for (int size = 1; size < input.length() - index + 1; size++){
                if(isPalindromic(input.substring(index, index + size))) {
                    count++;
                }
            }
        }
        return count;
    }

    /*
    private Integer recursiveCountPalindromes(String input, Integer count){
        Integer tempCount = count;
        // Counts if the required strings starting at 0 have palindromes
        for (int size = 0; size < input.length(); size++){
            if(isPalindromic(substringAt(input, 0, size))) {
                tempCount++;
            }
        }
        if (input.length() == 1) {
            return tempCount;
        }
        else {
            return recursiveCountPalindromes(input.substring(1), tempCount);
        }

    }
    */

    /*

    public Integer countPalindromes(String input){
        Integer count = 0;
        // iterate from 1 to the number of characters in input
        for(int size = 1; size <= input.length(); size++) {
            // create array of substrings of length size
            String[] substrings = new String[input.length() - size + 1];
            // fill the array
            for (int index = 0; index < substrings.length; index++) {
                substrings[index] = substringAt(input, index, size);
            }
            // see if substrings are palindromic
            for (String s : substrings) {
                // if true, add to count
                if (isPalindromic(s)) {count++;}
            }
        }
        return count;
    }

    */

    private boolean isPalindromic(String string) {
        return string.equals(BasicStringUtils.reverse(string));
    }


}
