package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String[] arr1 = phrase.split("[-\\s]");
		StringBuilder acronym = new StringBuilder();

		for (String ele : arr1) {
			acronym.append(ele.charAt(0));
		}

		return acronym.toString().toUpperCase();
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			return areEqual(getSideOne(), getSideTwo()) == areEqual(getSideOne(), getSideThree());
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			Double[] doubles = triangleSides(getSideOne(), getSideTwo(), getSideThree());

			return (doubles[0].equals(doubles[1]) || doubles[0].equals(doubles[2]) || doubles[1].equals(doubles[2]))
					&& (!doubles[0].equals(doubles[1]) || !doubles[0].equals(doubles[2])
							|| !doubles[1].equals(doubles[2]));
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			Double[] doubles = triangleSides(getSideOne(), getSideTwo(), getSideThree());

			return !doubles[0].equals(doubles[1]) && !doubles[0].equals(doubles[2]) && !doubles[1].equals(doubles[2]);
		}

		public int areEqual(double one, double two) {
			int intOne = Double.compare(one, two);
			return intOne;
		}

		public Double[] triangleSides(double one, double two, double three) {
			Double[] doubles = { new Double(one), new Double(two), new Double(three) };

			return doubles;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		Map<Character, Integer> scrabbleScores = new HashMap<>();
		scrabbleScores.put('A', 1);
		scrabbleScores.put('E', 1);
		scrabbleScores.put('I', 1);
		scrabbleScores.put('O', 1);
		scrabbleScores.put('U', 1);
		scrabbleScores.put('L', 1);
		scrabbleScores.put('N', 1);
		scrabbleScores.put('R', 1);
		scrabbleScores.put('S', 1);
		scrabbleScores.put('T', 1);

		scrabbleScores.put('D', 2);
		scrabbleScores.put('G', 2);

		scrabbleScores.put('B', 3);
		scrabbleScores.put('C', 3);
		scrabbleScores.put('M', 3);
		scrabbleScores.put('P', 3);

		scrabbleScores.put('F', 4);
		scrabbleScores.put('H', 4);
		scrabbleScores.put('V', 4);
		scrabbleScores.put('W', 4);
		scrabbleScores.put('Y', 4);

		scrabbleScores.put('K', 5);

		scrabbleScores.put('J', 8);
		scrabbleScores.put('X', 8);

		scrabbleScores.put('Q', 10);
		scrabbleScores.put('Z', 10);

		String upperCase = string.toUpperCase();
		int lenString = upperCase.length();
		int score = 0;

		for (int i = 0; i < lenString; i++) {
			score += scrabbleScores.get(upperCase.charAt(i));

		}

		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration

		int strLength = string.length();
		int digitTotal = 0;
		StringBuilder strBuilt = new StringBuilder();
		Map<Character, Boolean> allowedCharacters = new HashMap<>();

		allowedCharacters.put('0', true);
		allowedCharacters.put('1', true);
		allowedCharacters.put('2', true);
		allowedCharacters.put('3', true);
		allowedCharacters.put('4', true);
		allowedCharacters.put('5', true);
		allowedCharacters.put('6', true);
		allowedCharacters.put('7', true);
		allowedCharacters.put('8', true);
		allowedCharacters.put('9', true);
		allowedCharacters.put('-', false);
		allowedCharacters.put('.', false);
		allowedCharacters.put(' ', false);
		allowedCharacters.put('(', false);
		allowedCharacters.put(')', false);

		for (int i = 0; i < strLength; i++) {

//			47 to 58
			final char charObtained = string.charAt(i);

			if (allowedCharacters.containsKey(charObtained)) {

				if (allowedCharacters.get(charObtained)) {

					strBuilt.append(charObtained);
					digitTotal++;
					if (digitTotal > 10) {
						throw new IllegalArgumentException("Greater than ten digits");
					}

				}

			} else {
				throw new IllegalArgumentException("Disallowed Symbol");
			}

		} // end for

		return strBuilt.toString();
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration

		String[] arr = string.split("\\P{Alpha}+");

		Map<String, Integer> retMap = new HashMap<>();

		for (String ele : arr) {
			if (retMap.containsKey(ele)) {
				int eleIntCount = retMap.get(ele);
				retMap.replace(ele, ++eleIntCount);
			} else {
				retMap.put(ele, 1);
			}
		} // end for

		return retMap;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			int high = sortedList.size() - 1;
			int low = 0;
			int middle = 0;
			int comparisonInt = 0;

			while (low <= high) {

				middle = (low / 2) + (high / 2);
				comparisonInt = sortedList.get(middle).compareTo(t);

				if (comparisonInt == 0) {

					return middle;

				} else if (comparisonInt < 0) {

					low = middle + 1;

				} else if (comparisonInt > 0) {

					high = middle - 1;

				} else {

					System.out.println("comparison not a number");

				}
			}

			return -1;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		int strLength = string.length();

		if (strLength > 0) {
			String[] strArr = string.toLowerCase().split(" ");

			Set<Character> vowels = new HashSet<>();
			vowels.add('a');
			vowels.add('e');
			vowels.add('i');
			vowels.add('o');
			vowels.add('u');

			StringBuilder pigLatinStr = new StringBuilder();

			for (String ele : strArr) {
				if (vowels.contains(ele.charAt(0))) {
					pigLatinStr.append(ele);
					pigLatinStr.append("ay ");
				} else {

					final int eleLength = ele.length();
					StringBuilder constants = new StringBuilder();
					for (int i = 0; i < eleLength; i++) {

						final char character = ele.charAt(i);
						if (vowels.contains(character)) {

							if (ele.charAt(i) == 'u' && ele.charAt(i - 1) == 'q') {
								constants.append(character);
							} else {
								break;
							}
						} else {
							constants.append(character);
						}
					} // end for
					final int conLength = constants.toString().length();

					pigLatinStr.append(ele.subSequence(conLength, ele.length()));
					pigLatinStr.append(constants);
					pigLatinStr.append("ay ");
				}
				
			} // end for

			return pigLatinStr.toString().trim();
		}

		return string;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		String str = Integer.toString(input);
		int strLength = str.length();
		int armNumber = 0;

		for (int i = 0; i < strLength; i++) {
			final int ele = str.charAt(i) - '0';
			armNumber += Math.pow(ele, strLength);
		}

		if (armNumber == input) {
			return true;
		}

		return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		List<Long> retPrimeFactors = new ArrayList<>();
		long copyL = l;

		for (long i = 2L; i <= copyL; i++) {
			if (copyL % i == 0) {
				retPrimeFactors.add(i);
				i--;
			}
		}
		return retPrimeFactors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration

			StringBuilder retString = new StringBuilder();
			final int strLength = string.length();
			final int maxUpperCaseValue = 90;
			final int minUpperCaseValue = 65;
			final int maxLowerCaseValue = 122;
			final int minLowerCaseValue = 97;

			for (int i = 0; i < strLength; i++) {
				final char character = string.charAt(i);
				final int charRotSum = character + key;

				if (character > 64 && character < 91) {

					if (charRotSum > maxUpperCaseValue) {
						final char characterNew = (char) (minUpperCaseValue + ((charRotSum % maxUpperCaseValue) - 1));
						retString.append(characterNew);
					} else {
						retString.append((char) charRotSum);
					}

				} else if (character > 96 && character < 123) {

					if (charRotSum > maxLowerCaseValue) {
						final char characterNew = (char) (minLowerCaseValue + ((charRotSum % maxLowerCaseValue) - 1));
						retString.append(characterNew);
					} else {
						retString.append((char) charRotSum);
					}
				} else {
					retString.append(character);
				}

			} // end for
			System.out.println(retString.toString());

			return retString.toString();
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration

		if (i <= 0) {
			throw new IllegalArgumentException("Undefined Prime");
		}

		int retInteger = 2;
		int counter = 0;
		int j;

		while (counter < i) {

			for (j = 2; j <= retInteger; j++) {
				if (retInteger % j == 0) {
					break;
				}
			} // end for

			if (j == retInteger) {
				counter++;
			}

			retInteger++;
		} // end while

		return retInteger - 1;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration

			String strLowerCase = string.toLowerCase();
			final int strLength = string.length();
			final int maxLowerCaseValue = 122;
			final int minLowerCaseValue = 97;
			StringBuilder strReturn = new StringBuilder();
			int counter = 0;

			for (int i = 0; i < strLength; i++) {
				final int charValue = strLowerCase.charAt(i);

				if (counter == 5) {
					strReturn.append(" ");
					counter = 0;
				}

				if (charValue > 96 && charValue < 123) {
					final int charValueNew = maxLowerCaseValue - charValue + minLowerCaseValue;
					strReturn.append((char) charValueNew);
					counter++;
				} else if (charValue > 46 && charValue < 58) {
					strReturn.append(strLowerCase.charAt(i));
					counter++;
				}

			} // end for

			return strReturn.toString().trim();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			String strLowerCase = string.toLowerCase();
			final int strLength = string.length();
			final int maxLowerCaseValue = 122;
			final int minLowerCaseValue = 97;
			StringBuilder strReturn = new StringBuilder();

			for (int i = 0; i < strLength; i++) {
				final int charValue = strLowerCase.charAt(i);

				if (charValue > 96 && charValue < 123) {
					final int charValueNew = maxLowerCaseValue - charValue + minLowerCaseValue;
					strReturn.append((char) charValueNew);
				} else if (charValue > 46 && charValue < 58) {
					strReturn.append(strLowerCase.charAt(i));
				}

			} // end for

			return strReturn.toString().trim();
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration

		String str = string.replaceAll("\\-", "");

		final int strLength = str.length();
		int counter = str.length();
		int sum = 0;

		Map<Character, Integer> validValues = new HashMap<>();
		validValues.put('0', 0);
		validValues.put('1', 1);
		validValues.put('2', 2);
		validValues.put('3', 3);
		validValues.put('4', 4);
		validValues.put('5', 5);
		validValues.put('6', 6);
		validValues.put('7', 7);
		validValues.put('8', 8);
		validValues.put('9', 9);
		validValues.put('X', 10);

		for (int i = 0; i < strLength; i++) {
			final char character = str.charAt(i);

			if (validValues.containsKey(character)) {
				final int valueChar = validValues.get(character);
				sum += valueChar * counter;
			}

			counter--;

		} // end for

		System.out.println(sum % 11);

		return sum % 11 == 0;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		String str = string.replaceAll(" ", "");

		Set<Character> lettersContained = new HashSet<>();

		final int strLength = str.length();

		for (int i = 0; i < strLength; i++) {
			lettersContained.add(str.charAt(i));
		}

		return lettersContained.size() == 26;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	/*
	 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
//		local date time class and local date, need longs add one billion to long
		LocalDateTime startDate;
		LocalDateTime endDate = null;
		
		if (given instanceof LocalDate) {
			startDate = ((LocalDate) given).atStartOfDay();
			endDate = startDate.plusSeconds(1_000_000_000);
		}
		
		if (given instanceof LocalDateTime) {
			startDate = (LocalDateTime) given;
			endDate = startDate.plusSeconds(1_000_000_000);
		}
		
		
		return endDate;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		Set<Integer> multiplesUnique = new HashSet<>();
		int sum = 0;

		for (int ele : set) {

			if (!multiplesUnique.contains(ele)) {

				multiplesUnique.add(ele);
				sum += ele;

			}

			int multiple = 2;
			int product = 0;

			while (product < i) {

				if (!multiplesUnique.contains(product)) {

					sum += product;
					multiplesUnique.add(product);

				}

				product = ele * multiple;
				multiple++;

			} // end while

		} // end for

		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		if (string.length() > 1) {
			String strModified = new StringBuilder(string).reverse().toString().replaceAll(" ", "");
			final int strLength = strModified.length();
			int counter = 1;
			int sum = 0;

			for (int i = 0; i < strLength; i++) {
				final char ele = strModified.charAt(i);

				if (!(ele > 47 && ele < 58)) {
					break;
				}

				if (counter == 2) {
					int product = (ele - '0') * 2;
					if (product > 9) {
						product -= 9;
					}
					sum += product;
					counter = 0;
				}
				counter++;

				sum += (ele - '0');

			} // end for

			return sum % 10 == 0;
		}

		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration

		String[] strArray = string.substring(0, string.length() - 1).split(" ");

		List<Integer> operands = new ArrayList<>();

		Map<String, Character> operator = new HashMap<>();
		operator.put("plus", '+');
		operator.put("minus", '-');
		operator.put("divided", '/');
		operator.put("multiplied", '*');

		Character operatorChar = '0';

		int solution = 0;

		for (String ele : strArray) {
			final int eleElement = ele.charAt(0);

			if (eleElement > 47 && eleElement < 58) {

				operands.add(Integer.parseInt(ele));

			} else if (eleElement == 45) {

				String str = ele.substring(1, ele.length());
				final int integer = 0 - Integer.parseInt(str);

				operands.add(integer);

			} else {
				final Character charLocal = operator.get(ele);

				if (charLocal != null) {

					operatorChar = charLocal;

				}

			}

		} // end for

		solution = operands.get(0);
		operands.remove(0);

		if (operatorChar == '+') {

			for (Integer ele : operands) {
				solution += ele;
			}

		} else if (operatorChar == '-') {

			for (Integer ele : operands) {
				solution -= ele;
			}

		} else if (operatorChar == '/') {

			for (Integer ele : operands) {
				solution /= ele;
			}

		} else if (operatorChar == '*') {

			for (Integer ele : operands) {
				solution *= ele;
			}

		} else {
			System.out.println("Operator not found");
		}

		return solution;
	}

}
