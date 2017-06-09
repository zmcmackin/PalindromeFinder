package com.vumc.pf;

import java.util.Scanner;

import org.apache.commons.lang3.time.StopWatch;

import com.vumc.pf.finders.*;

/**
 * Entry point for the Palindrome Finder CLI
 *
 */
public class PalindromeFinderCLI {
	private static final String WELCOME_STRING = "Welcome to PalindromeFinder";
	private static final String USER_INPUT_STRING = "How many digits would you like numbers that make the palindromic product to have? (2-9)";
	private static final String SEARCHING_FORMAT = "Searching for palindromes with two factors of %d digits...";
	private static final String OUTPUT_FORMAT = "Largest palindrome made from the product of two numbers of %d digits: %d\n"
			+ "\t Factor 1: %d\n" + "\t Factor 2: %d\n" + "\t Excution time: %s";
	private static final String CONTINUE_STRING = "Would you like to try again? (Y/N)";
	private static final String THANK_YOU_STRING = "Thank you and have a great day!";

	public static void main(String[] args) {
		new PalindromeFinderCLI().RunCLI();
	}

	public void RunCLI() {
		boolean shouldLoop = true;
		StopWatch stopWatch = new StopWatch();

		System.out.println(WELCOME_STRING);

		try (Scanner reader = new Scanner(System.in)) {
			while (shouldLoop) {
				System.out.println(USER_INPUT_STRING);
				int factorLength = reader.nextInt();
				stopWatch.reset();
				stopWatch.start();
				PalindromeResult finderResult = executeFinder(factorLength);
				stopWatch.stop();
				displayResult(finderResult, stopWatch.toString());
				shouldLoop = shouldLoop(reader);
			}

			System.out.println(THANK_YOU_STRING);
		}
	}

	public PalindromeResult executeFinder(int factorLength) throws IllegalArgumentException, IllegalStateException {
		BruteFinder bruteFinder = new BruteFinder();

		try {
			bruteFinder.setFactorLength(factorLength);
		} catch (IllegalArgumentException e) {
			System.out.println("ERROR: " + e.getMessage());
			throw e;
		}

		System.out.println(String.format(SEARCHING_FORMAT, factorLength));

		PalindromeResult finderResult;
		try {
			finderResult = bruteFinder.findPalindrome();
		} catch (IllegalStateException e) {
			System.out.println("ERROR: " + e.getMessage());
			throw e;
		}

		return finderResult;
	}

	public void displayResult(PalindromeResult finderResult, String runTime) {
		String outputString = String.format(OUTPUT_FORMAT, finderResult.getFactorLength(), finderResult.getPalindrome(),
				finderResult.getFactor1(), finderResult.getFactor2(), runTime);
		System.out.println(outputString);
	}

	private boolean shouldLoop(Scanner reader) {
		boolean result = false;

		System.out.println(CONTINUE_STRING);

		String input = reader.next();

		if (input.equalsIgnoreCase("Y")) {
			result = true;
		}

		return result;
	}
}
