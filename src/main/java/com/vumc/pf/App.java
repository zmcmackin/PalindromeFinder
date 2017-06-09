package com.vumc.pf;

import java.util.Scanner;

import org.apache.commons.lang3.time.StopWatch;

import com.vumc.pf.finders.*;

/**
 * Hello world!
 *
 */
public class App {
	private static final String WELCOME_STRING = "Welcome to PalindromeFinder";
	private static final String USER_INPUT_STRING = "How many digits would you like numbers that make the palindromic product to have? (2-9)";
	private static final String SEARCHING_FORMAT = "Searching for palindromes with two factors of %d digits...";
	private static final String OUTPUT_FORMAT = "Largest palindrome made from the product of two numbers of %d digits: %d\n"
												+ "\t Factor 1: %d\n" + "\t Factor 2: %d\n" + "\t Excution time: %s";
	private static final String CONTINUE_STRING = "Would you like to try again? (Y/N)";
	private static final String THANK_YOU_STRING = "Thank you and have a great day!";

	public static void main(String[] args) {
		StopWatch stopWatch = new StopWatch();

		System.out.println(WELCOME_STRING);

		boolean shouldLoop = true;
		try (Scanner reader = new Scanner(System.in)) {
			while (shouldLoop) {
				stopWatch.reset();
				System.out.println(USER_INPUT_STRING);

				int factorLength = reader.nextInt();

				BruteFinder bruteFinder = new BruteFinder();

				try {
					bruteFinder.setFactorLength(factorLength);
				} catch (IllegalArgumentException e) {
					System.out.println("ERROR: " + e.getMessage());
					return;
				}

				System.out.println(String.format(SEARCHING_FORMAT, factorLength));
				stopWatch.start();

				PalindromeResult finderResult;
				try {
					finderResult = bruteFinder.findPalindrome();
				} catch (IllegalStateException e) {
					System.out.println("ERROR: " + e.getMessage());
					return;
				}

				stopWatch.stop();
				String outputString = String.format(OUTPUT_FORMAT, factorLength, finderResult.getPalindrome(),
						finderResult.getFactor1(), finderResult.getFactor2(), stopWatch.toString());
				System.out.println(outputString);

				shouldLoop = shouldLoop(reader);
			}
			
			System.out.println(THANK_YOU_STRING);
		}
	}
	
	private static boolean shouldLoop(Scanner reader) {
		boolean result = false;

		System.out.println(CONTINUE_STRING);

		String input = reader.next();

		if (input.equalsIgnoreCase("Y")) {
			result = true;
		}

		return result;
	}
}
