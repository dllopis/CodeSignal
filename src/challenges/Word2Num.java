package challenges;

import java.util.Arrays;
import java.util.HashMap;

class MyDictionary	{
	HashMap<String,Integer> dictionary;
	
	// Create a custom dictionary of key-value pairs
	public MyDictionary()	{
		dictionary = new HashMap<String, Integer>();
		
		dictionary.put("zero" , 0);
		dictionary.put("one"  , 1);
		dictionary.put("two"  , 2);
		dictionary.put("three", 3);
		dictionary.put("four" , 4);
		dictionary.put("five" , 5);
		dictionary.put("six"  , 6);
		dictionary.put("seven", 7);
		dictionary.put("eight", 8);
		dictionary.put("nine" , 9);
		dictionary.put("ten"  ,10);
		
		dictionary.put("eleven"   , 11);
		dictionary.put("twelve"   , 12);
		dictionary.put("thirteen" , 13);
		dictionary.put("fourteen" , 14);
		dictionary.put("fifteen"  , 15);
		dictionary.put("sixteen"  , 16);
		dictionary.put("seventeen", 17);
		dictionary.put("eighteen" , 18);
		dictionary.put("nineteen" , 19);
		
		dictionary.put("twenty" , 20);
		dictionary.put("thirty" , 30);
		dictionary.put("forty"  , 40);
		dictionary.put("fifty"  , 50);
		dictionary.put("sixty"  , 60);
		dictionary.put("seventy", 70);
		dictionary.put("eighty" , 80);
		dictionary.put("ninety" , 90);
		
		dictionary.put("hundred" , 100);
		dictionary.put("thousand", 1000);
		dictionary.put("million" , 1000000);
		dictionary.put("billion" , 1000000000);
	}
	
	// provide getter-access to dictionary
	public HashMap<String,Integer> getDictionary()	{
		return dictionary;
	}
}
public class Word2Num {
	public int word2Num(String str)	{
		// could use ignoreCase method or this to help evaluate
		str = str.toLowerCase();
		
		// create instance of our custom dictionary
		MyDictionary thisDictionary = new MyDictionary();
		
		//initialize our hashmap to the custom dictionary provided above
		HashMap<String, Integer> dict = thisDictionary.getDictionary();
		
		// split our string before evaluating each element
		String[] num = str.split("\\s|-|,(\\s+)|,");
		
		System.out.println(Arrays.toString(num));
		
		int result = 0;
		int n = 0;
		String temp = "";
		
		/* 1. n will temporarily hold sum values of converted elements from temp
		 * 2. result will hold the final value after conversion
		 */
		for(int i = 0;i<num.length;i++)	{
			temp = num[i];
			
			switch(temp)	{
			case "hundred" :
							n *= dict.get(temp);
							break;
			case "thousand":
							n *= dict.get(temp);
							result += n;
							n = 0;
							break;
			case "million" :
							n *= dict.get(temp);
							result += n;
							n = 0;
							break;
			case "billion" :
							n *= dict.get(temp);
							result += n;
							n = 0;
							break;
			default:
							if(temp.equals("and"))
								break;
							n += dict.get(temp);
							break;
			}
		}
		// add left over conversion into result and return
		result += n;
		n = 0;
		
		return result;
	}
	public static void main(String[] args) {
		String s = "One hundred Twenty three thousand, Four hundred and fifty-six";
		Word2Num solution = new Word2Num();
		System.out.println("Convert to integer: " + s + "\nResult: " + solution.word2Num(s));

	}

}
