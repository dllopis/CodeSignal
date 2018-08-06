package arcadeChallenges;

public class ArrayMaximalAdjacentDifference {

	int[] testCase1 = {2, 4, 1, 0};
	int[] testCase2 = {1, 1, 1, 1};
	int[] testCase3 = {-1, 4, 10, 3, -2};
	int[] testCase4 = {10, 11, 13};
	int[] testCase5 = {-1, 1, -3, -4};
	
	int arrayMaximalAdjacentDifference(int[] inputArray) {

		int maxAbsDifference = Integer.MIN_VALUE;
		
		for(int i = 1;i < inputArray.length;i++)	{
			int difference = Math.abs(inputArray[i-1] - inputArray[i]);
			if(difference > maxAbsDifference)	{
				maxAbsDifference = difference;
			}
		}
		return maxAbsDifference;
	}
	public static void display(int[] a, String s)	{
		System.out.print(s);
		for(int i = 0;i<a.length;i++)	{
			if(i!=a.length-1)
				System.out.print(a[i] + ",");
			else
				System.out.print(a[i]);
		}System.out.print("]\n");
	}
	public static void main(String[] args) {
		ArrayMaximalAdjacentDifference solution = new ArrayMaximalAdjacentDifference();
		
		int[] testCase = solution.testCase1;
		display(testCase,"TestCase: [");
		System.out.println("Absolute maximal adjacent difference: " + solution.arrayMaximalAdjacentDifference(testCase));
	}
}
