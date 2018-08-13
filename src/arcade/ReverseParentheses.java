package arcade;


public class ReverseParentheses {
	
	String reverseParentheses(String s) {
		/* This will be used to help the recursion end when reversing strings - output.length == count */
		int count = 0;
		
		String output = "";
		String string2Reverse = "";
		String temp = "";
		
		boolean openParen = false;
		boolean closeParen = false;
		
		System.out.println("--- Check each Character for '(' or ')' --- " + s);
		
		for(int i = 0;i<s.length();i++)	{
			char c = s.charAt(i);
			/* if string starts with ')' continue */
			if(s.charAt(0) == ')')
				continue;
			
			switch(c)	{
			
			case '(': 	 /*	check to see if there is an existing string in temp first
					 	  * example: a(b <-- a needs to be appended to output before and temp needs to be cleared
					 	  * before appending characters
					 	  */
						if(temp.length() > 0)	{
						
						/*Encountered a subsequent '(' -- meaning a new string to reverse*/
						if(openParen == true && c == '(')	{
							/*clear current string to be reversed and start again*/
							string2Reverse = "";
						}
							/* Output to console */
							System.out.println("Reversing: " + temp);
							/* -------------------------------------- */
							output += temp;
							temp = "";
							temp += c;
						}else	{
							temp += c;
						}
						openParen = true;
						break;
						
			case ')': 	closeParen = true;
			
						/* Check first for open and closed brace */
						if(openParen && closeParen)	{
							output += reverse(string2Reverse);
							
							/* Output to console */
								temp += c;
								System.out.println("Reversing: " + temp);
							/* -------------------------------------- */
						
							/* Reset variables for next reversal */
							openParen = false;
							closeParen = false;
							string2Reverse = "";
							temp = "";
						}else	{
							/* Output to console */
								temp += c;
								System.out.println(temp);
								/* -------------------------------------- */
							output += temp;
							temp = "";
						}
						break;
						
			default :	/* check if openParen is true to start collecting the string to be reversed in ( xyz ) */
						if(openParen)	{
						string2Reverse += c;
						temp +=c;
						}
						else	{
							/* continue to gather string in temp while check for parentheses */
							temp += c;
						}
						count++;
						break;
			}
		}
		// check for remaining string in temp and add to output -- characters only -- no '(' or ')' --
		if(temp.length() > 0)	{
			output += temp;
			System.out.println(temp);
			temp = "";
		}
		
		System.out.println("\nCount: " + count + " < --- > " + "Output: " + output.length());
		
		/* Recursion check here -- count must equal output length in order to terminate algorithm */
		if( count != output.length())	{
			System.out.println("Continue Recursion: " + output + "\n");
			return reverseParentheses(output);
		}else	{
			/* string has been fully processed by algorithm */
			return output;
		}
	}

	private String reverse(String s)	{
		String reversed = "";
		for(int j = s.length()-1;j>=0;j--)	{
			reversed += s.charAt(j);
		}
		return reversed;
	}
	public static void main(String[] args) {
		String x = "a(c(xy)b)de";
		String y = "abc(cba)ab(bac)c";
		
		ReverseParentheses solution = new ReverseParentheses();
		System.out.println(solution.reverseParentheses(x));
	}
}
