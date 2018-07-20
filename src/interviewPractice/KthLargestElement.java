package interviewPractice;

import java.util.Arrays;

	/*need to update this code and implement my own algorithm
	 * Do not use built in library methods
	 */
public class KthLargestElement {
	
	int kthLargestElement(int[] nums, int k) {
		
		Arrays.sort(nums);
		
		return nums[nums.length-k];
	}
	
	public static void main(String args[])	{
		
		KthLargestElement kth = new KthLargestElement();
		
		int[] nums = {7, 6, 5, 4, 3, 2, 1};
		int k = 2;
		int result = kth.kthLargestElement(nums, k);
		System.out.println(result);
	}
}