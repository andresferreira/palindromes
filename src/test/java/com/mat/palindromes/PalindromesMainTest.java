package com.mat.palindromes;

import junit.framework.TestCase;

import java.util.List;
import java.util.TreeMap;

/**
 * Unit test for Palindromes project.
 */
public class PalindromesMainTest extends TestCase
{
    /**
     * Test isPalindrome method when input string is "racecar"
     *
     * @throws Exception the exception
     */
    public void testIsPalindromeRacecarWordShouldReturnTrue() throws Exception {

        Palindrome palindrome = new Palindrome();
        assertTrue(palindrome.isPalindrome("racecar"));
    }

    /**
     * Test isPalindrome method when input string is "asa"
     *
     * @throws Exception the exception
     */
    public void testIsPalindromeOddWordShouldReturnTrue() throws Exception {

        Palindrome palindrome = new Palindrome();
        assertTrue(palindrome.isPalindrome("asa"));
    }

    /**
     * Test isPalindrome method when input string is "assa"
     *
     * @throws Exception the exception
     */
    public void testIsPalindromeEvenWordShouldReturnTrue() throws Exception {

        Palindrome palindrome = new Palindrome();
        assertTrue(palindrome.isPalindrome("assa"));
    }

    /**
     * Test isPalindrome method when input string is "AAA"
     *
     * @throws Exception the exception
     */
    public void testIsPalindromeAAAWordShouldReturnTrue() throws Exception {

        Palindrome palindrome = new Palindrome();
        assertTrue(palindrome.isPalindrome("AAA"));
    }

    /**
     * Test isPalindrome method when input string is not a palindrome
     *
     * @throws Exception the exception
     */
    public void testIsPalindromeRomeWordShouldReturnFalse() throws Exception {

        Palindrome palindrome = new Palindrome();
        assertFalse(palindrome.isPalindrome("rome"));
    }

    /**
     * Test findAllPalindromes method when input string is "sysaxyx"
     *
     * @throws Exception the exception
     */
    public void testFindAllPalindromesShouldSaveAllPalindromesToTreeMap() throws Exception {

        String inputString = "sysaxyx"; //two palindromes: "sys" and "xyx"

        Palindrome palindrome = new Palindrome();

        TreeMap<Integer, List<PalindromeTreeMapInfo>> palindromeTreeMap =  palindrome.findAllPalindromes(inputString);
        assertEquals("sys", palindromeTreeMap.get(3).get(0).getPalindromeText());
        assertEquals(0, palindromeTreeMap.get(3).get(0).getPalindromeIndex());
        assertEquals("sys".length(), palindromeTreeMap.keySet().toArray()[0]);

        assertEquals("xyx", palindromeTreeMap.get(3).get(1).getPalindromeText());
        assertEquals(4, palindromeTreeMap.get(3).get(1).getPalindromeIndex());
        assertEquals("xyx".length(), palindromeTreeMap.keySet().toArray()[0]);
    }

    /**
     * Test printPalindrome method
     *
     * @throws Exception the exception
     */
    public void testPrintPalindromeShouldReturnRacecarNameAndIndexAndLengthCorrectly() throws Exception {

        Palindrome palindrome = new Palindrome();

        String palindromeString = palindrome.printPalindrome("racecar",0,7);
        assertEquals("Text: racecar, Index: 0, Length: 7\n", palindromeString);
    }

    /**
     * Test print3LongestPalindromes method when input string is "sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop"
     *
     * @throws Exception the exception
     */
    public void testPrint3LongestPalindromesShouldReturn3Palindromes() throws Exception {

        String inputString ="sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop";

        Palindrome palindrome = new Palindrome();
        String threeLongestPalindromes = palindrome.print3LongestPalindromes(inputString);

        assertEquals(threeLongestPalindromes, "Text: hijkllkjih, Index: 23, Length: 10\n" +
                "Text: defggfed, Index: 13, Length: 8\n" +
                "Text: abccba, Index: 5, Length: 6\n");
    }

    /**
     * Test print3LongestPalindromes method when input string is "szsaxyx"
     *
     * @throws Exception the exception
     */
    public void testPrint3LongestPalindromesShouldReturn2Palindromes() throws Exception {

        String inputString ="szsaxyx";

        Palindrome palindrome = new Palindrome();
        String twoLongestPalindromes = palindrome.print3LongestPalindromes(inputString);

        assertEquals(twoLongestPalindromes, "Text: szs, Index: 0, Length: 3\n" +
                "Text: xyx, Index: 4, Length: 3\n");
    }

    /**
     * Test print3LongestPalindromes method when input string is "aaaa"
     *
     * @throws Exception the exception
     */
    public void testPrint3LongestPalindromesRepeatedLettersShouldReturn1Palindrome() throws Exception {

        String inputString ="aaaa";

        Palindrome palindrome = new Palindrome();
        String threeLongestPalindromes = palindrome.print3LongestPalindromes(inputString);

        assertEquals(threeLongestPalindromes, "Text: aaaa, Index: 0, Length: 4\n");
    }

    /**
     * Test print3LongestPalindromes method when input string is "1aabaacxyx"
     *
     * @throws Exception the exception
     */
    public void testPrint3LongestPalindromesPhraseShouldReturn2Palindrome() throws Exception {

        String inputString = "1aabaacxyx";

        Palindrome palindrome = new Palindrome();
        String threeLongestPalindromes = palindrome.print3LongestPalindromes(inputString);

        assertEquals(threeLongestPalindromes, "Text: aabaa, Index: 1, Length: 5\nText: xyx, Index: 7, Length: 3\n");
    }

    /**
     * Test print3LongestPalindromes method when input string is the phrase "A man, a plan, a canal, Panama!"
     *
     * @throws Exception the exception
     */
    public void testPrint3LongestPalindromesLongPhraseShouldReturn1Palindrome() throws Exception {

        String inputString = "A man, a plan, a canal, Panama!";

        Palindrome palindrome = new Palindrome();
        String threeLongestPalindromes = palindrome.print3LongestPalindromes(inputString);

        assertEquals(threeLongestPalindromes, "Text: amanaplanacanalpanama, Index: 0, Length: 21\n");
    }

    /**
     * Test null input string
     *
     * @throws Exception the exception
     */
    public void testNullInputStringShouldReturnMessage() throws Exception {

        Palindrome palindrome = new Palindrome();
        assertEquals("String is null\n", palindrome.print3LongestPalindromes(null));
    }

    /**
     * Test empty input string
     *
     * @throws Exception the exception
     */
    public void testEmptyInputStringShouldReturnMessage() throws Exception {

        Palindrome palindrome = new Palindrome();
        assertEquals("String is empty\n", palindrome.print3LongestPalindromes(""));
    }
}
