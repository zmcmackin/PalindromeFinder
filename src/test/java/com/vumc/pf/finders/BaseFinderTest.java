package com.vumc.pf.finders;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BaseFinderTest {

	@Test
	public void test_IsPalindrome10101() {
		assertEquals(true, BasePalindromeFinder.isPalindrome(10101));
	}

	@Test
	public void test_IsPalindrome11100() {
		assertEquals(false, BasePalindromeFinder.isPalindrome(11100));
	}

	@Test
	public void test_IsPalindrome54321() {
		assertEquals(false, BasePalindromeFinder.isPalindrome(54321));
	}

	@Test
	public void test_IsPalindrome892298() {
		assertEquals(true, BasePalindromeFinder.isPalindrome(892298));
	}
}
