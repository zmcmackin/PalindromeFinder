package com.vumc.pf.finders;

public class BruteFinder extends BasePalindromeFinder {

	// input factorLength must be > 0
	public PalindromeResult findPalindrome() throws IllegalArgumentException {
		// call the base method for implementation for state validation
		// and initialization of return value
		PalindromeResult result = super.findPalindrome();

		int factorLength = getFactorLength();
		int factorMaxValue = (int) Math.pow(10, factorLength) - 1;
		int factorMinValue = (int) Math.pow(10, factorLength - 1);

		// iterate first factor potential values
		for (int factor1 = factorMaxValue; factor1 >= factorMinValue; factor1--) {
			// iterate second factor potential values
			// start counting down from factor1 to eliminate duplicates
			// (e.g.99*91 & 91*99)
			for (int factor2 = factor1; factor2 >= factorMinValue; factor2--) {
				int factorProduct = factor1 * factor2;
				// first check that product is greater
				// than the current max palindrome
				if (factorProduct > result.getPalindrome()) {
					// check if it is a palindrome after
					// since it is a more expensive check
					if (isPalindrome(factorProduct)) {
						result.setPalindrome(factorProduct);
						result.setFactor1(factor1);
						result.setFactor2(factor2);
					}
				}
			}
		}

		return result;
	}
}
