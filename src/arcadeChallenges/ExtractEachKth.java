package arcadeChallenges;

public class ExtractEachKth {
	int[] extractEachKth(int[] inputArray, int k) {
		int[] result = new int[inputArray.length - (inputArray.length / k)];
		
		for(int i = 1,j = 0;i <= inputArray.length;i++)	{
			if(i % k != 0)
				result[j++] = inputArray[i-1];	
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] t1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] t2 = {1, 1, 1, 1, 1};
		int[] t3 = {1, 2, 1, 2, 1, 2, 1, 2};
		
		int t1_K = 3;
		int t2_K = 2;
		int t3_K = 1;
		
		ExtractEachKth solution = new ExtractEachKth();
		int[] result1 = solution.extractEachKth(t1, t1_K);
		int[] result2 = solution.extractEachKth(t2, t2_K);
		int[] result3 = solution.extractEachKth(t3, t3_K);
		
		System.out.println("Original: " + java.util.Arrays.toString(t1) + " -- remove Kth Values: " + t1_K);
		System.out.println("Solution: " + java.util.Arrays.toString(result1) + "\n");
		
		System.out.println("Original: " + java.util.Arrays.toString(t2) + " -- remove Kth Values: " + t2_K);
		System.out.println("Solution: " + java.util.Arrays.toString(result2) + "\n");
		
		System.out.println("Original: " + java.util.Arrays.toString(t3) + " -- remove Kth Values: " + t3_K);
		System.out.println("Solution: " + java.util.Arrays.toString(result3) + "\n");
	}

}
