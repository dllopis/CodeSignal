package arcade;

import java.util.Arrays;

public class AbsoluteValuesSumMinimization {

	int absoluteValuesSumMinimization(int[] a) {
	    int medianIndex = a.length/2;
	    if(a.length%2==1)
	        return a[medianIndex];
	    else
	        return a[medianIndex-1];
	}

	public static void main(String[] args) {
		AbsoluteValuesSumMinimization solution = new AbsoluteValuesSumMinimization();
		int[] t1 = {2, 4, 7};
		int[] t2 = {1, 1, 3, 4};
		
		System.out.println(Arrays.toString(t1) + "\tsolution: " + solution.absoluteValuesSumMinimization(t1));
		System.out.println(Arrays.toString(t2) + "\tsolution: " + solution.absoluteValuesSumMinimization(t2));
	}
}
