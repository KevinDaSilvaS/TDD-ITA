package com.tdd; 

import java.util.ArrayList;
import java.util.List;

public class CamelCaseStr {
    
    public static List<String> converterCamelCase(String original){
        List<String> l = new ArrayList<String>();

        if (checkInt(original.charAt(0))) {
            l.add("invalidFormat");

        }else if (!original.matches("^[A-Za-z0-9\s]+")) {
            l.add("invalidFormatSpecialChar");

        }else{
            l = transformStringToList(original);
        }
        return l;
    }

    private static List<String> transformStringToList(String original) {

        List<String> listaWords = new ArrayList<String>();
        String word = "";

        for (int i = 0; i < original.length(); i++) {

            if (i != original.length()-1) {

                if (Character.isUpperCase(original.charAt(i + 1)) ||
                checkInt(original.charAt(i + 1))) {

                    word += original.charAt(i);
                    listaWords.add(word);
                    word = "";

                }else{
                    word += original.charAt(i);
                }
            }
            
        }
        word += original.charAt(original.length()-1);
        listaWords.add(word);
        listaWords = groupAllConsecutiveUppercaseSingleLetters(listaWords);
        return listaWords;
    }

    private static List<String> groupAllConsecutiveUppercaseSingleLetters(List<String> words){
        List<String> groupedWords = new ArrayList<String>();
        String formedConsecutive = "";

        for (int i = 0; i < words.size(); i++) {

            if (words.get(i).length() > 1) {

                if (formedConsecutive.length() > 0) {
                    groupedWords.add(formedConsecutive);
                    formedConsecutive = "";
                }

                groupedWords.add(words.get(i).toLowerCase());

            }else{
                formedConsecutive += words.get(i).charAt(0);
            }
        }

        if (formedConsecutive.length() > 0) {
            groupedWords.add(formedConsecutive);
        }
        return groupedWords;
    }

    private static Boolean checkInt(char c){
        String s = "" + c;
        try { 
            Integer.parseInt(s); 
            
        } catch(Exception e)  { 

            return false; 
        } 

        return true;
    }

}