package arcade;

import java.util.Arrays;
import java.util.List;

public class StringsRearrangement {

	private boolean consecutive = false;
	
	public boolean stringsRearrangement(String[] inputArray) {
		System.out.println("Original: " + Arrays.toString(inputArray));
		Arrays.sort(inputArray);
		System.out.println("Sorted: " + Arrays.toString(inputArray));
		System.out.println("All Permutations: ");
		permute(Arrays.asList(inputArray), 0);
		
		return consecutive;
	}
	
    private void permute(List<String> list, int k){
        for(int i = k; i < list.size(); i++){
            java.util.Collections.swap(list, i, k);
            permute(list, k+1);
            java.util.Collections.swap(list, k, i);
        }
        if (k == list.size() -1){
        	 System.out.println(Arrays.toString(list.toArray()));
        	if(check(list))	{
        		consecutive = true;
        	}
        }
    }
    
	private boolean check(List<String> list) {
		for (int i = 1; i < list.size(); i++) {
			int diffCount = count(list.get(i-1), list.get(i));
			if (diffCount != 1) return false;
		}
		System.out.println(Arrays.toString(list.toArray()) + "Satisfies condition of challenge");
		
		return true;
	}

	private int count(String s1, String s2) {
		int count = 0;
		
		for(int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) count++;
		}
		return count;
	}

	
/*	 private String next(String s) {
		   int length = s.length();
		   char c = s.charAt(length - 1);

		   if(c == 'z')
		     return length > 1 ? next(s.substring(0, length - 1)) + 'a' : "aa";

		   return s.substring(0, length - 1) + ++c;
	 }*/

	public static void main(String[] args) {
		String[] testcase1 = {"ab","bb","aa"};
		String[] testcase2 = {"aba", "bbb", "bab"};
		StringsRearrangement solution = new StringsRearrangement();
		System.out.println("IsArrangeable? : " + solution.stringsRearrangement(testcase1));
	}
}

