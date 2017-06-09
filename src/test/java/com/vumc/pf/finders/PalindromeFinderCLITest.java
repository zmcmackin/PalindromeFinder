package com.vumc.pf.finders;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.vumc.pf.PalindromeFinderCLI;

public class PalindromeFinderCLITest {

	PalindromeFinderCLI cliApp;

	@Before
	public void testSetup() {
		cliApp = new PalindromeFinderCLI();
	}

	@Test
	public void test_executeFinder() {
		PalindromeFinderCLI app = new PalindromeFinderCLI();
		app.executeFinder(3);
	}

	@Test
	public void test_displayResult() {
		PalindromeResult result = new PalindromeResult();
		result.setFactorLength(2);
		result.setFactor1(99);
		result.setFactor2(91);
		result.setPalindrome(9009);
	}

	@After
	public void testTearDown() {
		cliApp = null;
	}
}
