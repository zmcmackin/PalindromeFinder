package com.vumc.pf.finders;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BruteFinderTest {
	
	private BruteFinder bruteFinder;
	
	/**
	 * putting the BruteFinder constructor in the before annotated method 
	 * tells junit to do the instantiation each time before running a test
	 * this reduces code duplication of the BruteFinder constructor
	 */
	@Before
	public void initBruteFinder(){
		bruteFinder = new BruteFinder();
	}
	
	@Test
	public void test_BruteFinderFactorLength2(){
		bruteFinder.setFactorLength(2);
		PalindromeResult result = bruteFinder.findPalindrome();
		PalindromeTests.verifyPalindromeResultFactorLength2(result);
	}
	
	@Test
	public void test_BruteFinderFactorLength3(){
		bruteFinder.setFactorLength(3);
		PalindromeResult result = bruteFinder.findPalindrome();
		PalindromeTests.verifyPalindromeResultFactorLength3(result);
	}
	
	@Test
	public void test_BruteFinderFactorLength4(){
		bruteFinder.setFactorLength(4);
		PalindromeResult result = bruteFinder.findPalindrome();
		PalindromeTests.verifyPalindromeResultFactorLength4(result);
	}
	
	@Test
	public void test_BruteFinderFactorLength5(){
		bruteFinder.setFactorLength(5);
		@SuppressWarnings("unused")
		PalindromeResult result = bruteFinder.findPalindrome();
	}
	
	//@Test
	public void test_BruteFinderFactorLength6(){
		bruteFinder.setFactorLength(6);
		@SuppressWarnings("unused")
		PalindromeResult result = bruteFinder.findPalindrome();
	}
	
	/*
	 * just added for a sanity check and so that it can be garbage collected
	 */
	@After
	public void tearDown(){
		bruteFinder = null;
	}
	
}
