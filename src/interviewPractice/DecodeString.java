package interviewPractice;

import java.util.Stack;

public class DecodeString {

	/*
	 * Plan of attack:
	 * 	Two stacks: 1. Strings to be decoded
	 * 				2. Individual String to decode from Strings stack
	 * 				3. append to result string and return
	 */
	
	Stack<String> strings = new Stack<String>();
	Stack<Character> process = new Stack<Character>();
	
		public String decodeString(String s) {
	
		String result = "";
		
		// 1. store all possible strings to decode in this stack
		strings = storeStrings(s);
		
		// 2. decode each string in strings stack and concatenate
		result = decodeString();
		
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

	private String decodeString()	{
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
			
			for(int i = 0;i<temp.length();i++)	{
				char c = temp.charAt(i);
				
				if(Character.isDigit(c))	{
					num = num + c;
					checkString += c;
					continue;
				}
				else if(Character.isLetter(c))	{
					checkString += c;
					decodeString += c;
				}
				else if(c == '[')	{
					openBrace = true;
					checkString += c;
					continue;
				}
				else if(c == ']')	{
					closeBrace = true;
					checkString += c;
					continue;
				}
				
			}// end of for
			if(num.length()>0)	{
				n = Integer.parseInt(num);
				num = "";
			}	
			if(n > 0 && openBrace == true && closeBrace == true)	{
				while(n > 0)	{
					output = decodeString + output;
					n--;
				}
				num = "";
				decodeString = "";
				openBrace = false;
				closeBrace = false;
			}else	{
				if(!(openBrace == true && closeBrace == true))
				output = checkString + output;
			}
			if(num.length() == 0)
				decodeString = "";
			checkString = "";
		} // end of while
		
		if(n>0){
			storeStrings(output);
			return decodeString();
		}else	{
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
		String s = "z1[y]zzz2[abc]";
		
		DecodeString decode = new DecodeString();
		System.out.println("Original: " + s);
		System.out.println("Decoded: " + decode.decodeString(s));
	}

}
