package com.mat.palindromes;

/**
 * The type Palindrome TreeMapInfo.
 */
public class PalindromeTreeMapInfo {

    private String palindromeText;

    private int palindromeIndex;

    /**
     * Instantiates a new PalindromeTreeMapInfo.
     */
    public PalindromeTreeMapInfo() {}

    /**
     * Gets the Palindrome Text.
     *
     * @return the Palindrome Text
     */
    public String getPalindromeText() {
        return palindromeText;
    }

    /**
     * Sets the Palindrome Text.
     *
     * @param palindromeText the Palindrome Text
     */
    public void setPalindromeText(String palindromeText) {
        this.palindromeText = palindromeText;
    }

    /**
     * Gets the Palindrome Index.
     *
     * @return the Palindrome Index
     */
    public int getPalindromeIndex() {
        return palindromeIndex;
    }

    /**
     * Sets the Palindrome Index.
     *
     * @param palindromeIndex the Palindrome Index
     */
    public void setPalindromeIndex(int palindromeIndex) {
        this.palindromeIndex = palindromeIndex;
    }

    @Override
    public String toString() {
        return "PalindromeInfo{" +
                "palindromeText='" + palindromeText + '\'' +
                ", palindromeIndex=" + palindromeIndex +
                '}';
    }
}
