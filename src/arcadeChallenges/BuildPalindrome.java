package arcadeChallenges;

import java.util.Stack;

public class BuildPalindrome {

	private boolean checkPalindrome(String inputString)
	{
		char[] string = inputString.toCharArray();
		
		int j = string.length - 1;
		
		for(int i = 0;i<string.length;i++)
		{
			if(string[i] != string[j])
	            return false;
			j--;
		}
		return true;
	}
	String buildPalindrome(String st) {
		
		if(checkPalindrome(st))
			return st;
		
		Stack<Character> stack = new Stack<Character>();
		String buildP = "";
		
		System.out.println("Start pushing characters onto stack until a palindrome is formed.");
		for(int i = 0;i<st.length()-1;i++)	{
			stack.push(st.charAt(i));
			System.out.println("Pushed: " + st.charAt(i));
			System.out.println("... Checking ...");
			buildP = st.substring(i+1,st.length());
			if(checkPalindrome(buildP))	{
				System.out.println("Palindrome found: " + buildP);
				break;
			}
		}
		System.out.println("Append stack.pop() on original string to build palindrome.");
		while(!stack.isEmpty())	{
			st += stack.pop();
		}
		return st;
	}
	
	public static void main(String[] args) {
		BuildPalindrome solution = new BuildPalindrome();
		String t1 = "abcdc";
		System.out.println("\nOriginal: " + t1 + "\n" + "Built Palindrome: " + solution.buildPalindrome(t1));

	}

}
