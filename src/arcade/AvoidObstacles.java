package arcade;

import java.util.Arrays;

public class AvoidObstacles {
	/*
	 * Recursion helps achieve the solution by modding all the elements in inputArray
	 * with value. If every element modded by value results in non-zero, then that is the
	 * minimal amount of jumps needed to avoid all obstacles.
	 */
	int value = 1;
	
		int avoidObstacles(int[] inputArray) {
		    
		    for(int i = 0;i < inputArray.length;i++)  {
		        if(inputArray[i] % value == 0)  {
		            value++;
		            return avoidObstacles(inputArray);
		        }
		    }
		    return value;
		}

	public static void main(String[] args) {
		AvoidObstacles solution = new AvoidObstacles();
		int[] testcase = {16, 19, 21, 25};
		System.out.println("Testcase: " + Arrays.toString(testcase));
		System.out.println("Minimal jumps needed to avoid obstacles? : Intervals of " + solution.avoidObstacles(testcase));

	}

}
