package arcadeChallenges;

public class CheckPalindromes {

	public static boolean checkPalindrome(String inputString)
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
	
	public static void main(String args[])
	{
		System.out.println(checkPalindrome("abba"));
	}
}
