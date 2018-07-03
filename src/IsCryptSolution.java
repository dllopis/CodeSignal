import java.util.HashMap;

public class IsCryptSolution {
	            		
	boolean isCryptSolution(String[] crypt, char[][] solution) {
		
		// create a new array to hold results of each decryption and then check if it's valid
		long[] solutionArray = new long[3];
		// location holder for each decrypted string
		int pointer = 0;
		
		// create a hashmap to help decrypt strings in crypt array
		HashMap<Character,Character> hm = new HashMap<Character,Character>();
		//populate hashmap
		for(int i = 0;i<solution.length;i++)	{
			hm.put(solution[i][0], solution[i][1]);
		}
		//view our hashmap
		System.out.println(hm);
		//decode each string in crypt
		for(String s : crypt)	{
			
			//check first if leading digit is a zero
			if(hm.get(s.charAt(0)) == '0' && s.length() > 1)	{
				// leading zero was found -- invalid
				return false;
			}
			// temp string to hold all chars before parsing
			String temp = "";
			
			for(char c : s.toCharArray())	{
				temp += (hm.get(c));
			}
			// store parsed integer into it's corrected index
			solutionArray[pointer] = Long.parseLong(temp);
			// move to next index before decrypting next string
			pointer++;
			
		}
		
		System.out.println(solutionArray[0] + "\n" + solutionArray[1] + "\n" + solutionArray[2]);
		//result -- validating crypt solution
		if((solutionArray[0] + solutionArray[1]) == solutionArray[2])	{
			return true;
		}else
			return false;
	}
	
	public static void main(String[] args) {
		
		String[] crypt = {"SEND", "MORE", "MONEY"};

		char[][] solution = {
			//  zero | 1 column's
				{'O', '0'},
				{'M', '1'},
				{'Y', '2'},
				{'E', '5'},
				{'N', '6'},
				{'D', '7'},
				{'R', '8'},
				{'S', '9'}
		};
		
		String[] crypt2 = {"TEN", "TWO", "ONE"};

		char[][] solution2 = {
				{'O', '1'},
				{'T', '0'},
				{'W', '9'},
				{'E', '5'},
				{'N', '4'}
				};
		
		String[] crypt3 = {	"AAAAAAAAAAAAAA", 
		        			"BBBBBBBBBBBBBB", 
		        			"CCCCCCCCCCCCCC"};

		char[][] solution3 = {
				{'A','1'},
				{'B','2'},
				{'C','3'}
				};
		
		IsCryptSolution isCrypt = new IsCryptSolution();
		System.out.println(isCrypt.isCryptSolution(crypt3, solution3));

	}

}
