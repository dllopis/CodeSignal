package arcadeChallenges;
import java.util.ArrayList;

public class CommonCharacterCount {

	static int commonCharacterCount(String s1, String s2) {

        //count for common character ocurrences
	    int count = 0;
        //two arraylist to store strings
	    ArrayList<Character> string1 = new ArrayList<Character>(s1.length());
	    ArrayList<Character> string2 = new ArrayList<Character>(s2.length());
	    
        //populate each list with corresponding string
	    for(int i = 0;i<s1.length();i++)
	    {
	    	string1.add(s1.charAt(i));
	    }
	    for(int i = 0;i<s2.length();i++)
	    {
	    	string2.add(s2.charAt(i));
	    }
	    
        // just some output so that I can see results on console
	    System.out.println("string1 - " + s1 + " - length: " + string1.size());
	    System.out.println("string2 - " + s2 + " - length: " + string2.size());
	    
	   
	    System.out.println("Strings loaded into their own list");
	    System.out.println("Check for common characters now");
	   
        /*the logic behind this:
        brute force check from first character of string1 to each character of string2
        when character match is found, remove that character from 2nd string
        so that we do not count that same character again
        break when a character is found, so that we can check for other characters
        */
	    for(int i = 0;i<string1.size();i++)
	    {
	    	for(int j = 0;j<string2.size();j++)
	    	{
	    		if(string1.get(i).equals(string2.get(j)))
	    		{
	    			System.out.println(string1.get(i) + "\t " + string2.get(j));
	    			string2.remove(j);
	    			count++;
	    			break;
	    		}
	    	}
	    }
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aabcc";
		String s2 = "adcab";
		
		System.out.println("Common Count: " + commonCharacterCount(s1,s2));
	}

}
