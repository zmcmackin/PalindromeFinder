package com.vumc.pf.finders;

public abstract class BasePalindromeFinder {

	private int factorLength;

	/**
	 * Finds the largest palindrome made from the product of two digits of
	 * factorLength
	 * 
	 * @return PalindromeResult including the largest palindrome found and the
	 *         two factors used for the product
	 * @throws IllegalStateException
	 */
	public PalindromeResult findPalindrome() throws IllegalStateException {
		if (factorLength <= 0)
			throw new IllegalStateException("Factor Length must be set to a positive integer.");

		PalindromeResult result = new PalindromeResult();
		result.setFactorLength(factorLength);
		return result;
	}

	public int getFactorLength() {
		return factorLength;
	}

	/**
	 * number of digits each factor should contain must be a positive integer
	 * @param factorLength must be positive integer
	 * @throws IllegalArgumentException
	 */
	public void setFactorLength(int factorLength) throws IllegalArgumentException {
		if (factorLength <= 0)
			throw new IllegalArgumentException("Palindrome factor length must be greater than 0");

		this.factorLength = factorLength;
	}

	/**
	 * verifies that the numberToCheck is a palindrome
	 * marked static to denote that it does not rely of class members
	 * @param numberToCheck
	 * @return boolean value representing if the input is palindromic
	 */
	public static boolean isPalindrome(int numberToCheck) {

		boolean result = false;

		if (numberToCheck == reverseInt(numberToCheck)) {
			result = true;
		}

		return result;
	}

	/**
	 * flips the digits of an integer
	 * 
	 * @param input integer to reverse
	 * @return the reverse lexicographical order of the input
	 */
	private static int reverseInt(int input) {

		int reversedInt = 0;
		while (input > 0) {

			// find the last digit by calculating the remainder when divided by
			// 10
			int lastDigit = input % 10;

			// shift all the digits to the left then add the new last digit
			reversedInt = (reversedInt * 10) + lastDigit;

			// integer division floors the remainder
			// in this case removing the last digit
			input = input / 10;
		}
		
		return reversedInt;

	}
}
