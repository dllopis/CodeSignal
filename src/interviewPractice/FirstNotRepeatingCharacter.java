package interviewPractice;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FirstNotRepeatingCharacter {

	public static char firstNotRepeatingCharacter(String s)	{
		
		// store each character and preserving insertion order
        HashMap  <Character,Integer>hMap = new LinkedHashMap<Character,Integer>();
        
        // iterate the length of the string and place each character in map
        for(int i=0;i<s.length();i++)	{
           if(!hMap.containsKey(s.charAt(i)))
        	   hMap.put(s.charAt(i),1);
           else
        	   hMap.put(s.charAt(i),hMap.get(s.charAt(i))+1); // increment repeats
          }
        
        // look for the first non repeated character
        // Linked hashmap preserves order
        for (Character key : hMap.keySet())	{
          if(hMap.get(key)==1)	{ 
        	  return key; // first non-repeat returned
          }
        }
		return '_'; // could not find non-repeats
	}
	public static void main(String[] args) {
		
		String s = "abacabad";
		System.out.println(firstNotRepeatingCharacter(s));
	}

}
