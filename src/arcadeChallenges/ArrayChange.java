package arcadeChallenges;
import java.util.Arrays;

public class ArrayChange {

	/* test cases for challenge */
    public int[] t1 = {1, 1, 1 }; 								// result: 3
    public int[] t2 = {-1000, 0, -2, 0 }; 						// result: 5
    public int[] t3 = {2, 1, 10, 1}; 							// result: 12
	public int[] t4 = {2, 3, 3, 5, 5, 5, 4, 12, 12, 10, 15}; 	// result: 13
	

	int arrayChange(int[] inputArray) {
		int increases = 0;
		
		for(int i = 1;i<inputArray.length;i++)	{
			if(inputArray[i] > inputArray[i-1])	{
				continue;
			}else	{
				while(inputArray[i] <= inputArray[i-1])	{
					inputArray[i] = inputArray[i] + 1;
					increases++;
				}
			}
		}
		return increases;
	}
	
	public static void main(String[] args) {
		
		ArrayChange solution = new ArrayChange();
		
		int[] testCase = solution.t4;
		System.out.println(solution.arrayChange(testCase));

	}

}
