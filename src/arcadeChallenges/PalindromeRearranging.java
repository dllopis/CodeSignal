package arcadeChallenges;

import java.util.Arrays;

public class PalindromeRearranging {

    public String t1 = "abca";
    public String t2 = "abcad";
    public String t3 = "zaa";
    public String t4 = "z";
    public String t5 = "abbcabb";
    public String t6 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbccccaaaaaaaaaaaaa";
    
	boolean palindromeRearranging(String inputString) {
		
		if(inputString.length() == 1)	{
			System.out.println("Testcase: " + inputString);
			return true;
		}
		char[] sortedInput = inputString.toCharArray();
		
		display(sortedInput,"Testcase: [");
		Arrays.sort(sortedInput);
		display(sortedInput,"Sorted: [");
		
		/* If count mod 2 returns odd -- this will be set to true --
		 * If it happens twice -- not palindrome -- */
		boolean isOdd = false;
		
		/* count occurences of each character */
		int count = 0;
		
		char c = sortedInput[0];
		/* use brute force to do comparisons and count */
		for(int i = 0;i<sortedInput.length;i++)	{

			/* checks to see if c has been counted already previously 
			 * c will be assigned a new value and counted when it is not equal to previous c*/
			if(i > 0)
			{
				if(sortedInput[i] == c)
					continue;
				else {
					c = sortedInput[i];
				}
			}
			
			for(int j = 0;j<sortedInput.length;j++)	{
				if(sortedInput[j] == c)	{
					count++;
				}
			}
			
			System.out.println("Count - " + sortedInput[i] + " - : " + count);
			/* if this occurs twice -- palindrome is not possible -- */
			if(count % 2 == 1)	{
				if(isOdd)
					return false;
				else
					isOdd = true;
			}
			/* reset count to start counting next character */
			count = 0;
		}
		
		/* if we reach here, then that means count % 2 == 0 for each character and possibly one count % 2 == 1 occured */
		return true;
	}
	
	public void display(char[] c, String s)	{
		System.out.print(s);
		for(int i = 0;i<c.length;i++)	{
			System.out.print(c[i]);
		}System.out.print("]\n");
	}
	public static void main(String[] args) {
		PalindromeRearranging solution = new PalindromeRearranging();
		
		String testCase1 = solution.t1;
		String testCase2 = solution.t2;
		String testCase3 = solution.t3;
		String testCase4 = solution.t4;
		String testCase6 = solution.t6;
		
		System.out.println(solution.palindromeRearranging(testCase1) + "\n");
		System.out.println(solution.palindromeRearranging(testCase2) + "\n");
		System.out.println(solution.palindromeRearranging(testCase3) + "\n");
		System.out.println(solution.palindromeRearranging(testCase4) + "\n");
		System.out.println(solution.palindromeRearranging(testCase6) + "\n");

	}

}
