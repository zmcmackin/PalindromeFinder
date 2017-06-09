package com.vumc.pf.finders;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BruteFinderTest {

	private BruteFinder bruteFinder;

	/*
	 * putting the BruteFinder constructor in the before annotated method tells
	 * junit to do the instantiation each time before running a test this
	 * reduces code duplication of the BruteFinder constructor
	 */
	@Before
	public void testSetup() {
		bruteFinder = new BruteFinder();
	}

	@Test
	public void test_BruteFinderFactorLength2() {
		bruteFinder.setFactorLength(2);
		PalindromeResult result = bruteFinder.findPalindrome();
		PalindromeTestHelper.verifyPalindromeResultFactorLength2(result);
	}

	@Test
	public void test_BruteFinderFactorLength3() {
		bruteFinder.setFactorLength(3);
		PalindromeResult result = bruteFinder.findPalindrome();
		PalindromeTestHelper.verifyPalindromeResultFactorLength3(result);
	}

	@Test
	public void test_BruteFinderFactorLength4() {
		bruteFinder.setFactorLength(4);
		PalindromeResult result = bruteFinder.findPalindrome();
		PalindromeTestHelper.verifyPalindromeResultFactorLength4(result);
	}

	@Test
	public void test_BruteFinderFactorLength5() {
		bruteFinder.setFactorLength(5);
		bruteFinder.findPalindrome();
	}

	@Test(expected = IllegalStateException.class)
	public void test_IntegerOverflowIllegalState() {
		bruteFinder.setFactorLength(10);
		bruteFinder.findPalindrome();
	}

	/*
	 * added so object under test can be garbage collected and to prevent
	 * unintended side affects
	 */
	@After
	public void testTearDown() {
		bruteFinder = null;
	}
}
