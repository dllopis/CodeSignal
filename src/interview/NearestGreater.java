package interview;

import java.util.Arrays;
import java.util.Stack;
/*
 * def nearestGreater(a):
  b, stack = [-1] * len(a), []
  for i in range(len(a)):
    while stack and a[stack[-1]] < a[i]:
      j = stack.pop()
      if b[j] == -1 or i - j < j - b[j]: b[j] = i
    if not stack: b[i] = -1
    else: b[i] = stack[-1] if a[i] != a[stack[-1]] else b[stack[-1]]    
    stack.append(i)
  return b
 */
public class NearestGreater {

	public int[] nearestGreater(int[] a) {
		// this will return solution after values are placed in their correct index
		int[] b = new int[a.length];
		for(int i = 0;i<a.length;i++)	{
			
			int maxOnRight = -1;
			int maxOnLeft = -1;
			System.out.println("\ti[" + i + "]: " + a[i]);
			
			// check right
			for(int j = i+1;j<a.length;j++)	{
				System.out.print(" --> " + a[j] + " " );
				if(a[j] > a[i])	{
					maxOnRight = j;
					break;
				}
			}System.out.println("");
			
			// check left
			for(int k = i;k>0;k--)	{
				System.out.print(" <-- " + a[k-1] + " ");
				if(a[k-1] > a[i])	{
					maxOnLeft = k-1;
					break;
				}
			}System.out.println("");
			
			System.out.println("right: " + maxOnRight);
			System.out.println("Left: " + maxOnLeft);
			
			if( maxOnLeft == -1 && maxOnRight == -1)	{
				System.out.println("NearestGreater: -1 \t-- doesn't exist! --" + "\n");
				b[i] = -1;
			}
			else if( maxOnLeft == -1)	{
				b[i] = maxOnRight;
				System.out.println("NearestGreater: " + a[maxOnRight] + "\tIndex: " + maxOnRight + "\n");
			} else if(maxOnRight == -1)	{
				System.out.println("NearestGreater: " + a[i] + "\tIndex: " + maxOnLeft + "\n");
				b[i] = maxOnLeft;
			} else if( i-maxOnLeft < maxOnRight-i)	{
				System.out.println("NearestGreater: " + a[i] + "\tIndex: " + maxOnLeft + "\n");
				b[i] = maxOnLeft;
			} else if(maxOnRight-i < i-maxOnLeft)	{
				System.out.println("NearestGreater: " + a[i] + "\tIndex: " + maxOnRight + "\n");
				b[i] = maxOnRight;
			} else	{
				if(maxOnRight-i == i-maxOnLeft) {
					System.out.println("NearestGreater: " + a[i] + "\tIndex: " + maxOnLeft + "\n");
					b[i] = maxOnLeft;
				}
					
			}
			
		}
				return b;
	}
	
	public static void main(String[] args) {
		int[] t1 = {1, 4, 2, 1, 7, 6, 1}; 	// Expected Output: [1, 4, 1, 2, -1, 4]
	    int[] t2 = {2, 1, 2, 1, 2};		// Expected Output:	[-1, 0, -1, 2, -1]
		int[] t3 = {7, 4, 7, 2, 7, 6};	// Expected Output: [-1, 0, -1, 2, -1, 4]
		
		NearestGreater solution = new NearestGreater();
		
		System.out.println("Original: " + Arrays.toString(t1) + "\n");
		System.out.println("\nExpected Output: " + Arrays.toString(solution.nearestGreater(t1))+ "\n");
/*
		System.out.println("Original: " + Arrays.toString(t2) + "\n");
		System.out.println("\nExpected Output: " + Arrays.toString(solution.nearestGreater(t2)) + "\n");
		
		System.out.println("\nOriginal: " +Arrays.toString(t3)); 
		System.out.println("Expected Output: " + Arrays.toString(solution.nearestGreater(t3)) + "\n");
*/
	}

}
