package arcadeChallenges;

/*
 * #1 solution for java on codesignal ben_w6
 * String longestWord(String text)
{
    return Arrays.stream(text.split("\\W+")).max((a, b) -> a.length() - b.length()).get();
}
 */
public class LongestWord {

	public String longestWord(String text) {
	    String longest = "";
	    String temp = "";
	    
	    for(int i = 0;i<text.length();i++)	{
	    	char c = text.charAt(i);
	    	
	          if (Character.isLetter(c))	{
	            temp += c;
	          } else	{
	        	  if(temp.length() > longest.length())	{
	        		  longest = temp;
	        		  temp = "";
	        	  }
	        	  temp = "";
	          }
	          if(temp.length()>0 && temp.length() > longest.length())
	        	  longest = temp;
	    }
	    return longest;
	}
	public static void main(String[] args) {
		LongestWord solution = new LongestWord();
		
		String t1 = "A aab";
		System.out.println("String of text: " + t1);
		System.out.println("Longest Word in text: " + solution.longestWord(t1));

	}

}
