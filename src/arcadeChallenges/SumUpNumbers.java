package arcadeChallenges;

public class SumUpNumbers {

	/*
	 * Sum up all the numbers that appear in the inputString
	 */
	public int sumUpNumbers(String inputString) {
	    String temp = "";
	    int sum = 0;
	    
	    for(int i = 0;i<inputString.length();i++)	{
	    	char c = inputString.charAt(i);
	    	
	          if (Character.isDigit(c))	{
	            temp += c;
	          } else	{
	        	  if(temp.length() > 0)
	        		  sum += Integer.parseInt(temp);
	        	  temp = "";
	          }
	    }
	    return sum;
	}
	
	public static void main(String[] args) {
		SumUpNumbers solution = new SumUpNumbers();
		
		String t1 = "2 apples, 12 oranges";
		System.out.println("String: " + t1 + "\t" + "\nSum: " + solution.sumUpNumbers(t1) + "\n");
		
		String t2 = "there are some (12) digits 5566 in this 770 string 239";
		System.out.println("String: " + t2 + "\t" + "\nSum: " + solution.sumUpNumbers(t2));
	}

}
