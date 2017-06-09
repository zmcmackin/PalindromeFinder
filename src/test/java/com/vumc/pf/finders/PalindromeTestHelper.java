package com.vumc.pf.finders;

import static org.junit.Assert.assertEquals;

/**
 * Test helper class for PalindromeFinder that asserts that the greatest
 * palindrome is found and the factors used to make the product; requires that
 * the two factors are defined in descending order i.e.
 * finderToTest.getFactor1() > finderToTest.getFactor2()
 * 
 * @author Zack
 *
 */
public class PalindromeTestHelper {

	/**
	 * tests the PalindromeResult that is the greatest palindromic product of
	 * two numbers with two digits
	 * 
	 * @param result
	 */
	public static void verifyPalindromeResultFactorLength2(PalindromeResult result) {

		assertEquals(9009, result.getPalindrome());
		assertEquals(99, result.getFactor1());
		assertEquals(91, result.getFactor2());
	}

	/**
	 * tests the PalindromeResult that is the greatest palindromic product of
	 * two numbers with three digits
	 * 
	 * @param result
	 */
	public static void verifyPalindromeResultFactorLength3(PalindromeResult result) {

		assertEquals(906609, result.getPalindrome());
		assertEquals(993, result.getFactor1());
		assertEquals(913, result.getFactor2());
	}

	/**
	 * tests the PalindromeResult that is the greatest palindromic product of
	 * two numbers with three digits
	 * 
	 * @param result
	 */
	public static void verifyPalindromeResultFactorLength4(PalindromeResult result) {
		assertEquals(99000099, result.getPalindrome());
		assertEquals(9999, result.getFactor1());
		assertEquals(9901, result.getFactor2());
	}
}
