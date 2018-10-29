/**
 * INSTRUCTIONS.
 * 
 * The following exercises are, perhaps, more mathematically inclined than previous
 * problem sets. While they might be challenging, they are certainy doable.
 * 
 * You can (and should!) solve each of them using only the operators, conditional control
 * structures, and iterative control strucurs we've covered. You are not permitted to use
 * recursive code in your solutions.
 * 
 * Please be mindful of the expected outputs, as your code will be tested against that
 * directly. If you're unsure, please ask for clarification.
 * 
 * This problem set is worth 25 points and is due no later than 11:59pm on October 28, 2018.
 */
import java.util.Scanner;
public class ProblemSet3_5 {
	
	public static void main(String[] args) {
		ProblemSet3_5 ps = new ProblemSet3_5();
		
		// scanner
		Scanner in = new Scanner(System.in);
		
		/*//ex 1
		System.out.println("Exercise 1");
		System.out.println("Starting value will be 1.");
		int start = 1;
		System.out.println("Please enter ending value.");
		int end = in.nextInt();
		ps.primes(start, end);
		
		//ex 2
		System.out.println("Exercise 2");
		System.out.println("Year assumed to be 2018.");
		System.out.println("Enter how many future leap years you want to see.");
		int count = in.nextInt();
		ps.leapYears(count); */
		
		//ex 3
		System.out.println("Exercise 3");
		System.out.println("Enter number to see if it is palindromic.");
		int number = in.nextInt();
		ps.palindromicNumbers(number);
		
		//close scanner
		in.close();
	}
	
	/**
	 * How many prime numbers are there between @start and @end, where @start and @end
	 * are positive integers in the range [1, @Integer.MAX_VALUE]?
	 * 
	 * Print your solution in the following formats: "There is X prime number."
	 *                                               "There are X prime numbers."
	 * 
	 * @param start
	 * @param end
	 */
	
	public void primes(int start, int end) {
		int count = 0;
		int countPrime = 0;
		// makes sure to include 2
		if (end > 1) {
			countPrime++;
		}
		while (start <= end) {
			//how many numbers it is divisible by
			//resets for every number
			count = 0;
			for(int i = 2; i < start; i++) {
				if (start % i == 0) {
					count++;
				}
				if (i == start - 1) {
					//if it wasnt divisible by anything then its prime
					if (count == 0) {
						countPrime++;
					}
				}
			}
			start++;
		}
		if (countPrime == 1) {
			System.out.println("There is " + countPrime + " prime number.");
		}
		else if (countPrime > 1 || countPrime == 0) {
			System.out.println("There are " + countPrime + " prime numbers.");
		}
	}
	
	/**
	 * What are the next @count leap years?
	 * 
	 * Print your solution in the following formats: "The next leap year is X."
	 *                                               "The next 2 leap years are X and Y."
	 *                                               "THe next N leap years are A, ..., X, Y, and Z."
	 * 
	 * @param count
	 */
	
	public void leapYears(int count) {
		int year = 2018;
		boolean isLeapYear = false;
		int leapYear = 0;
		int numLeapYears = 0;
		//num of years until last leap year from 2018
		int num = 0;
		for (int i = 4; i > 0; i--) {
			if ((year + i) % 4 == 0) {
				num = i + (4 * count);
			}
		}
		if (count == 1) {
			System.out.print("The next leap year is ");
			for (int i1 = 0; i1 < num; i1++) {
				leapYear = year + i1;
				isLeapYear = false;
				if ((year + i1) % 100 == 0) {
					if ((year + i1) % 400 == 0) {
						isLeapYear = true;
					}
					else if ((year + i1) % 400 != 0) {
						isLeapYear = false;
					}
				}
				else if ((year + i1) % 4 == 0) {
					isLeapYear = true;
				}
				if (isLeapYear == true) {
					System.out.println(leapYear + ".");
				}
			}
		}
		if (count == 2) {
			System.out.print("The next 2 leap years are ");
			for (int i1 = 0; i1 < num; i1++) {
				leapYear = year + i1;
				isLeapYear = false;
				if ((year + i1) % 100 == 0) {
					if ((year + i1) % 400 == 0) {
						isLeapYear = true;
						numLeapYears++;
					}
					else if ((year + i1) % 400 != 0) {
						isLeapYear = false;
					}
				}
				else if ((year + i1) % 4 == 0) {
					isLeapYear = true;
					numLeapYears++;
				}
				if (numLeapYears == 1) {
					if (isLeapYear == true) {
						System.out.print(leapYear + " and");
					}
				}
				else {
					if (isLeapYear == true) {
						System.out.println(leapYear + ".");
					}
				}
			}
		}
		else if (count > 2) {
			System.out.print("The next " + count + " leap years are ");
			for (int i1 = 0; i1 < num; i1++) {
				leapYear = year + i1;
				isLeapYear = false;
				if ((year + i1) % 100 == 0) {
					if ((year + i1) % 400 == 0) {
						isLeapYear = true;
						numLeapYears++;
					}
					else if ((year + i1) % 400 != 0) {
						isLeapYear = false;
					}
				}
				else if ((year + i1) % 4 == 0) {
					isLeapYear = true;
					numLeapYears++;
				}
				if (numLeapYears == count) {
					if (isLeapYear == true) {
						System.out.println("and " + leapYear + ".");
					}
				}
				else {
					if (isLeapYear == true) {
						System.out.print(leapYear + ", ");
					}
				}
			}
		}
	}

	/**
	 * Is @number a palindromic number?
	 * 
	 * Print your solution in the following formats: "X is a palindromic number."
	 *                                               "X is not a palindromic number."
	 *                                               
	 * @param number
	 */
	
	public void palindromicNumbers(int number) {
		int numBefore = 0;
		int num = 0;
		boolean isPalindromicNumber = false;
		if (number % 2 == 0) {
			if (number % 10 == 0) {
				for (int i = 0; i < 10; i++) {
					if ((number - i) % 10 == 0) {
						num = i;
						numBefore = i;
					}
				}
			}
			else if (number % 2 == 0) {
				for (int i = 0; i < 10; i++) {
					if ((number - i) % 10 == 0) {
						num = i + 1;
						numBefore = i;
					}
				}
			}
			if (number % 10 == 0) {
				isPalindromicNumber = false;
			}
			else if ((number - numBefore) % num == 0) {
				isPalindromicNumber = true;
			}
		}
		else {
			for (int i = 0; i < 10; i++) {
				if ((number - i) % 10 == 0) {
					if ((number - i) % 5 == 0) {
						num = i + (i / 2);
						numBefore = i;
					}
					else {
						num = i + 1;
						numBefore = i;
					}
				}
			}
			if ((number - numBefore) % num == 0) {
				isPalindromicNumber = true;
			}
		}
		if (isPalindromicNumber == false) {
			System.out.println("This is not a palindromic number.");
		}
		else if (isPalindromicNumber == true) {
			System.out.println("This is a palindromic number.");
		}
	}
	
	/**
	 * What is the @nth Fibonacci number, where @n is a positive integer?
	 * 
	 * Print your solution in the following formats: "The 21st Fibonacci number is X."
	 *                                               "The 22nd Fibonacci number is X."
	 *                                               "The 23rd Fibonacci number is X."
	 *                                               "The 24th Fibonacci number is X."
	 *                                               
	 * @param n
	 */
	
	public void fibonacci(int n) {
		
	}
	
	/**
	 * What is the sum of all multiples of @x and @y less than @limit, where @x, @y, and
	 * @limit are positive integers?
	 * 
	 * Print your solution in the following format: "The sum is X."
	 * 
	 * @param limit
	 */
	
	public void multiples(int x, int y, int limit) {
		
	}
}
