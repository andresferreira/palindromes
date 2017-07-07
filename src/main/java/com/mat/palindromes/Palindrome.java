package com.mat.palindromes;

import java.util.*;

/**
 * The type Palindrome.
 */
public class Palindrome {

    /**
     * Instantiates a new Palindrome.
     */
    public Palindrome() {}

    /**
     * Is
     * @param string
     * @return
     */
    public boolean isPalindrome(String string) {

        int n = string.length();
        for (int i = 0; i < (n/2); ++i) {
            if (string.charAt(i) != string.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * Treemap main advantage is that it allows to store the key-value mappings in a sorted order.
     *
     * @param inputString
     * @return
     */
    public TreeMap<Integer,List<PalindromeTreeMapInfo>> findAllPalindromes(String inputString) {

        TreeMap<Integer,List<PalindromeTreeMapInfo>> treeMap = new TreeMap<Integer, List<PalindromeTreeMapInfo>>();
        inputString = transform(inputString);

        int inputStringLength = inputString.length();
        for(int start = 0; start < inputStringLength; start++) {
            for(int end = inputStringLength-1; end > start; end--) {

                char characterStart = inputString.charAt(start);
                char characterEnd = inputString.charAt(end);

                if(characterStart == characterEnd && start != end){
                    if(isPalindrome(inputString.substring(start,end+1))) {
                        savePalindrome(inputString, treeMap, start, end);
                        start = end+1;
                        end = inputStringLength;
                    }
                }
            }
        }
        TreeMap<Integer,List<PalindromeTreeMapInfo>> reverseTreeMap = new TreeMap(Collections.reverseOrder());
        reverseTreeMap.putAll(treeMap);

        return reverseTreeMap;
    }

    /**
     *
     * @param inputString
     * @param treeMap
     * @param start
     * @param end
     */
    private void savePalindrome(String inputString, TreeMap<Integer, List<PalindromeTreeMapInfo>> treeMap, int start, int end) {
        int palindromeLength = end-start+1;

        PalindromeTreeMapInfo palindromeTreeMapInfo = new PalindromeTreeMapInfo();
        palindromeTreeMapInfo.setPalindromeIndex(start);
        palindromeTreeMapInfo.setPalindromeText(inputString.substring(start,end+1));

        if(!treeMap.containsKey(palindromeLength)) {
            List<PalindromeTreeMapInfo> palindromeTreeMapInfoList = new ArrayList<PalindromeTreeMapInfo>();
            palindromeTreeMapInfoList.add(palindromeTreeMapInfo);
            treeMap.put(palindromeLength, palindromeTreeMapInfoList);
        } else {
            List<PalindromeTreeMapInfo> palindromeTreeMapInfoList = treeMap.get(palindromeLength);
            palindromeTreeMapInfoList.add(palindromeTreeMapInfo);
            treeMap.put(palindromeLength, palindromeTreeMapInfoList);
        }
    }

    /**
     *
     * @param palidromeWord
     * @param palidromeIndex
     * @param palidromeLength
     * @return
     */
    public String printPalindrome(String palidromeWord, int palidromeIndex, int palidromeLength) {

        return "Text: " + palidromeWord + ", " + "Index: " +  palidromeIndex + ", " + "Length: " + palidromeLength + "\n";
    }

    /**
     *
     * @param inputString
     * @return
     */
    public String print3LongestPalindromes(String inputString) {

        if(inputString == null)
            return "String is null\n";
        if(inputString == "")
            return "String is empty\n";

        inputString = transform(inputString);

        Palindrome palindrome = new Palindrome();
        String outputPalindromes = "";

        int numPrintedPalindromes = 0;
        TreeMap<Integer, List<PalindromeTreeMapInfo>> allPalindromes = palindrome.findAllPalindromes(inputString);
        for (Map.Entry<Integer,List<PalindromeTreeMapInfo>> entry : allPalindromes.entrySet()) {

            if(numPrintedPalindromes == 3) continue;

            for(PalindromeTreeMapInfo palindromeTreeMapInfo : entry.getValue()){
                outputPalindromes = outputPalindromes + printPalindrome(palindromeTreeMapInfo.getPalindromeText(), palindromeTreeMapInfo.getPalindromeIndex(), entry.getKey());
            }
            numPrintedPalindromes++;
        }
        return outputPalindromes;
    }

    /**
     * Transform a String in a the same String ordered by alphabetical order in lower case
     * (ex: word = Racecar; transform(deal) = racecar)
     */
    private static String transform(String word) {
        String sword = word.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        char[] cword = sword.toCharArray();
        return String.valueOf(cword);
    }
}
