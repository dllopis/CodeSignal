package arcadeChallenges;

import java.util.HashMap;

public class AlphabeticShift {

	HashMap<Integer,Character> map= new HashMap<Integer,Character>();
	
	
	public String alphabeticShift(String inputString) {
		
		char[] c = inputString.toCharArray();
		inputString = "";
		
		for(int i = 0;i < c.length;i++)	{
			if(c[i] == 'z')	{
				c[i] = 'a';
				inputString += c[i];
			}
			else {
				c[i]++;
				inputString += c[i];
			}
		}
		return inputString;
	}
	public static void main(String[] args) {
		AlphabeticShift solution = new AlphabeticShift();
		String s = "cdmmhr";
		System.out.println(solution.alphabeticShift(s));

	}

}
