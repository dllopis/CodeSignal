package interview;

import java.util.Stack;

public class DecodeString {

	int count = 0;
	/*
	 * Plan of attack:
	 * 	Two stacks: 1. Strings to be decoded
	 * 				2. Individual String to decode from Strings stack
	 * 				3. append to result string and return
	 * 				4. use a count to check if output length is equal to the number of characters decoded
	 * 					if not, recall method and process string again.
	 */
	
	Stack<String> strings = new Stack<String>();
	Stack<Character> process = new Stack<Character>();
	
		public String decodeString(String s) {
	
		String result = "";
		
		// 1. store all possible strings to decode in this stack
		strings = storeStrings(s);
		
		// 2. decode each string in strings stack and concatenate
		result = decodeStringHelper();
		
		return result;
	}
	
	// helper function to store strings to stack
	private Stack<String> storeStrings(String string)	{
			
		String temp = "";
		String digit = "";
		
		for(int i = 0;i<string.length();i++)	{
			
			char c = string.charAt(i);
			
			if(Character.isLetter(c))	{
				temp += c;
				count++;
			}
			else if(Character.isDigit(c))	{
				if(temp.length() > 0)	{
					temp = digit + temp;
					strings.push(temp);
					digit ="";
					temp = "";
					digit += c;
					continue;
				}else	{
					digit += c;
				}
			}
			else if(c == '[' ){
				
				temp += c;
			}
			else if(c == ']' )	{
				temp += c;
				if(digit.length() > 0)
					temp = digit + temp;
				strings.push(temp);
				temp = "";
				digit = "";
			}
		}
		// store remaining characters
		if(temp.length() > 0)	{
			strings.push(temp);
		}
		// need to fix double digits when storing.
		//displayStack();
		return strings;
	}

	private String decodeStringHelper()	{
		String output = "";
		String temp = "";
		
		// will hold the complete string - if check fails then append to output
		String checkString = "";
		// will hold only the characters of the string excluding - digit/ '[' / ']'
		String decodeString = "";
		
		boolean closeBrace = false;
		boolean openBrace = false;
		int n = 0;
		String num = "";
		
		while(!strings.isEmpty())	{
			temp = strings.pop();
			checkString = temp;
			
			for(int i = 0;i<temp.length();i++)	{
				char c = temp.charAt(i);
				
				if(Character.isDigit(c))	{
					num = num + c;
				}
				else if(Character.isLetter(c))	{
					decodeString += c;
				}
				else if(c == '[')	{
					openBrace = true;
				}
				else if(c == ']')	{
					closeBrace = true;
				}
			}
			
			if(num.length()>0)	{
				n = Integer.parseInt(num);
			}	
			if(openBrace && closeBrace)	{
				while(n > 0)	{
					output = decodeString + output;
					n--;
				}
			}else	{
				output = checkString + output;
			}
			
			num = "";
			decodeString = "";
			openBrace = false;
			closeBrace = false;
		}
		
		if(output.length() > count){
			count = 0;
			storeStrings(output);
			return decodeStringHelper();
		}
		else	{
			return output;
		}
	}
	public void displayStack()	{
		
		System.out.println("String Stack Contents");
		
		while(!strings.isEmpty())	{

			System.out.println("==================");
			System.out.println("\t" + strings.pop());
		}System.out.println("==================");
	}
	public static void main(String[] args) {
		String s = "z1[y]zzz2[ab2[c]]";
		
		DecodeString decode = new DecodeString();
		System.out.println("Original: " + s);
		System.out.println("Decoded: " + decode.decodeString(s));
	}

}
