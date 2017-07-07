package com.mat.palindromes;

/**
 *  The Palindromes Main class
 */
public class PalindromesMain
{
    /**
     * PalindromesMain finds the 3 longest unique palindromes in any supplied string.
     * For the 3 longest palindromes, it report the palindrome, start index and length, in descending order of length.
     *
     * @since 2017-06-04
     * @param args
     */
    public static void main( String[] args )
    {
        // Change inputString and run main method to find the 3 longest unique palindromes
        String inputString = "11111111111";

        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.print3LongestPalindromes(inputString));
    }
}
