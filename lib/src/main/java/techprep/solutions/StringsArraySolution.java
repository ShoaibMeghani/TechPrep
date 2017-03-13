package techprep.solutions;

import java.util.HashMap;
import java.util.HashSet;

import javax.xml.stream.events.Characters;

/**
 * Created by smeghani on 3/12/2017.
 */

public class StringsArraySolution {

    /* 1.1 Implement an algorithm to determine if a string has all unique characters. What if you cannot
    use additional data structures? */
    public boolean hasAllUniqueChars(String text) {

        //Solution 1 using Hashmap
        HashSet<String> charSet = new HashSet<>(text.length());
        for (int i = 0; i < text.length(); i++) {
            if (charSet.contains(text.charAt(i))) {
                return false;
            } else {
                charSet.add(String.valueOf(text.charAt(i)));
            }
        }

        //Solution 2 using Bit
        int checker = 0;

        for (int i = 0; i < text.length(); i++) {
            int value = text.charAt(i) - 'a';
            if ((checker & (1 << value)) > 0) {
                return false;
            }
            checker = checker | (1 << value);
        }
        return true;
    }

    /*1.2 Implement a function void reversefchar* str) in Cor C++ which reverses a null-terminated
    string.*/
    public void reverse(char[] text) {
        int start = 0, end = text.length - 1;

        while (start < end) {
            char temp = text[start];
            text[start] = text[end];
            text[end] = temp;

            start++;
            end--;
        }
    }

    /*1.3 Given two strings, write a method to decide if one is a permutation of the other.*/
    public boolean isPermutationString(String text1, String text2) {
        //Solution 1 using hashmap, solution 2 can be sorting both the text and then compare
        boolean isPermutation = false;
        if (text1.length() != text2.length())
            return isPermutation;

        HashMap<Character, Integer> charMap = new HashMap<>(text1.length());

        for (int i = 0; i < text1.length(); i++) {
            if (charMap.containsKey(text1.charAt(i))) {
                int count = charMap.get(text1.charAt(i));
                charMap.put(text1.charAt(i), count + 1);
            } else {
                charMap.put(text1.charAt(i), 0);
            }
        }

        for (int i = 0; i < text2.length(); i++) {
            if (charMap.containsKey(text2.charAt(i))) {
                int count = charMap.get(text1.charAt(i));
                charMap.put(text1.charAt(i), count - 1);
            } else {
                return isPermutation;
            }
        }

        for (int i = 0; i < text1.length(); i++) {
            int count = charMap.get(text1.charAt(i));
            if (count != 0) {
                return isPermutation;
            }
        }

        isPermutation = true;
        return isPermutation;
    }

    /*1.4 Write a method to replace all spaces in a string with '%20'. You may assume that the
    string has sufficient space at the end of the string to hold the additional characters,
    and that you are given the "true" length of the string. (Note: if implementing in Java,
    please use a character array so that you can perform this operation in place.*/
    public void replaceSpace(char[] text, int orignalLength) {
        int spaceCount = 0;
        char end = '\0';
        for (int i = 0; i < text.length; i++) {
            if (text[i] == Characters.SPACE) {
                spaceCount++;
            }
        }
        int newLength = orignalLength + spaceCount * 2;
        text[newLength] = end;
        for (int i = orignalLength - 1; i > 0; i--) {
            if (text[i] == Characters.SPACE) {
                text[newLength - 1] = '0';
                text[newLength - 2] = '2';
                text[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                text[newLength - 1] = text[orignalLength];
                newLength--;
            }
        }
    }

    /*1.5 Implement a method to perform basic string compression using the counts of
    repeated characters. For example, the string aabcccccaaa would become
    a2blc5a3. If the "compressed" string would not become smaller than the original
    string, your method should return the original string.*/
    public String compressString(String text) {

        if (compressionSize(text) > text.length()) {
            return text;
        }
        StringBuffer buffer = new StringBuffer();
        char tempChar = text.charAt(0);
        int charCount = 1;
        for (int i = 1; i < text.length(); i++) {
            if (tempChar == text.charAt(i)) {
                charCount++;
            } else {
                buffer.append(tempChar);
                buffer.append(charCount);
                tempChar = text.charAt(i);
                charCount = 1;
            }
        }
        return buffer.toString();
    }

    public int compressionSize(String text) {
        if (text == null || text.length() == 0)
            return 0;

        char tempChar = text.charAt(0);
        int charCount = 1;
        int size = 0;
        for (int i = 1; i < text.length(); i++) {
            if (tempChar == text.charAt(i)) {
                charCount++;
            } else {
                size = size + 1 + String.valueOf(charCount).length();
                tempChar = text.charAt(i);
                charCount = 1;
            }
        }

        return size;
    }

    /*1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
   column are set to 0.*/
    public void changeArr(int[][] arr) {
        int rowValueChecker = 0;
        int colValueChecker = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    int value = 1 << i;
                    rowValueChecker = rowValueChecker | value;

                    int value2 = 1 << j;
                    colValueChecker = colValueChecker | value2;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int rowChecker = 1 << i;
                int colChecker = 1 << j;
                if ((rowChecker & rowValueChecker) > 0
                        || (colChecker & colValueChecker) > 0) {
                    arr[i][j] = 0;
                }
            }
        }
    }


    /*1.8 Assume you have a method isSubstring which checks if one word is a substring
    of another. Given two strings, si and s2, write code to check Ifs2 is a rotation of si
    using only onecalltoisSubstring (e.g., "waterbottLe" is a rotation of "erbottLewat").*/
    public boolean isRotation(String text1, String text2){
        String concatStr = text1 + text1;

//        if (isSubstring(concatStr,text2)){
//            return true;
//        }else{
//            return false;
//        }

        return false;
    }


}
