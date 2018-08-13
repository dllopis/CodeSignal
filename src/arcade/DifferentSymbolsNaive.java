package arcade;

import java.util.HashMap;

public class DifferentSymbolsNaive {

	int differentSymbolsNaive(String s) {
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i = 0;i<s.length();i++)	{
			map.put(s.charAt(i), i);
		}
		return map.size();
	}

	public static void main(String[] args) {

		String testcase = "cabca";
		
		DifferentSymbolsNaive solution = new DifferentSymbolsNaive();
		System.out.println("Unique Character Count: " + solution.differentSymbolsNaive(testcase));

	}

}
