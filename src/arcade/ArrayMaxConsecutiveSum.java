package arcade;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayMaxConsecutiveSum {
	
	public int arrayMaxConsecutiveSum(int[] inputArray, int k) {
		int currentSum = 0;
		int maxSum = 0;
		
		for (int i=0; i<inputArray.length; i++)
		{
			// this will keep current sum = to the index value of which the next element will be summed with
			// 2 + 3 = 5 -- then 5-2 = 3 -- then start next sum --> 3 + 5 etc...
			if ((i-k) >= 0) 
				currentSum -= inputArray[i-k];
			
			currentSum += inputArray[i];
		    
			if (currentSum > maxSum) 
				maxSum = currentSum;
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] testcase1 = {2,3,5,1,6};
		int[] testcase2 = {1, 3, 2, 4};
		
		int t1_K = 2; // answer will be 8 -- 3+5 = 8 --
		int t2_K = 3; // anwer will be 9 -- 3+2+4 = 9 --
		
		ArrayMaxConsecutiveSum solution = new ArrayMaxConsecutiveSum();
		
		System.out.println(Arrays.toString(testcase1) + "\tMax consecutive sum: " + solution.arrayMaxConsecutiveSum(testcase1, t1_K));
		System.out.println(Arrays.toString(testcase2) + "\tMax consecutive sum: " + solution.arrayMaxConsecutiveSum(testcase2, t2_K));
	}

}
