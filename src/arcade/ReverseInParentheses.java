package arcade;

public class ReverseInParentheses {
	String reverseInParentheses(String inputString) {
	    
	    String result = "";
	    String temp = "";
	    /*
	     * count will be used as a base case for our recursion in the case that string has multiple inner nested parentheses groups
	     * that need to be reversed
	     */
	    int count = 0;
	    
	    for(int i = 0;i < inputString.length();i++)  {
	        char c = inputString.charAt(i);
	    
	        switch(c)   {
	            /*
	             * once we encounter our first '(', we check to see if our temp string has anything in it.
	             * if it does, then that means we were collecting strings from a previous '('
	             * Which means that we have to concatenate what we have so far to our result
	             * clear the temp string in order to collect the new inner nested parentheses characters
	             * Recursion will deal with the previous parentheses we missed
	             */
	            case '(':   count++;
	                        if(temp.length() > 0)   {
	                            result += temp;
	                            temp = "";
	                            temp += c;
	                        }else
	                            temp += c;
	                        break;
	            /*
	             * We check first if temp has anything in it
	             * If not, we append to result since an open parentheses was not found yet.
	             * If temp has starting collecting characters ( greater than zero),
	             * Then we now have matched an open and close parentheses -- call reverse method -- and append to result.
	             * Make sure to reset temp back to "" (empty) in order to collect new characters.
	             * Most important of all count - 2 (the open and closed parentheses)  so that the recursion base case can be reached.
	             */
	            case ')':   count++;
	                        if(temp.length() == 0)  
	                            result += c;
	                        else    {
	                            temp += c;
	                            System.out.println(temp);
	                            String reversed = reverseString(temp);
	                            count -= 2;
	                            result += reversed;
	                            temp = "";
	                        }
	                        break;
	            /*
	             * If temp has collected characters then we are filling in temp until ')' is found.
	             * else we are just concatenating to our result until we find an open brace.
	             */
	            default:    
	                        if(temp.length() > 0)   {
	                            temp += c;
	                        }else   {
	                            result += c;
	                        }
	                        break;
	        }
	    }
	    // we are done! String reversed -- base case --
	    if(count == 0)
	        return result;
	    else
	        return reverseInParentheses(result); 
	        /* 
	         * recursion is called in the case that another group needs to be reversed 
	         * example: testcase 4: foo(bar(baz))blim ---  (bar(baz)) <--- reverse inner group first --> (barzab) <-- call recursion on this
	         */
	}

	/*
	 * logic for reversing strings within '(' and ')'
	 * since the string passed to method contains the parentheses, we account for that by not going down to first character
	 * hence j > 0 condition ,and not including the end ')' by subtracting one for not getting out of bounds exception and another -1 for excluding ')'
	 */
	private String reverseString(String s) {
	    String reversed = "";
	                
	    for(int j = s.length() - 2;j > 0;j--)   {
	        reversed += s.charAt(j);
	    }
	    return reversed;
	}
}
