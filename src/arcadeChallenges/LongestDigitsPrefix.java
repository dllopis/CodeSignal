package arcadeChallenges;

public class LongestDigitsPrefix {

	public String longestDigitsPrefix(String inputString) {
	    String longestDigitPre = "";
	    
	    for(int i = 0;i<inputString.length();i++)    {
	    	char c = inputString.charAt(i);
	      
	       if(Character.isDigit(c))	{
	    	   longestDigitPre += c;
	       }	else	{
               		if(c == ' ')
               			return "";
               		if(Character.isLetter(c)){
               			if(longestDigitPre.length() > 0) {
               				return longestDigitPre;
               			}
               		}
	       	}
	    }
	    return longestDigitPre;
	}
	
	public static void main(String[] args) {
		LongestDigitsPrefix solution = new LongestDigitsPrefix();
		System.out.println(solution.longestDigitsPrefix(" 123 aa1"));
	}
}
