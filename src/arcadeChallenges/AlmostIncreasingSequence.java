package arcadeChallenges;
import java.util.ArrayList;

public class AlmostIncreasingSequence {

	
	// test cases
	static int[] a = {1, 2, 3, 1, 4,5}; // false
	static int[] b = {1, 2, 5, 3, 5}; // false
	static int[] c = {10, 2, 3}; // true
	static int[] d = {1, 2, 5, 3, 5}; // true
	static int[] e = {1, 2, 3, 4, 5, 3, 5, 6}; // false
	static int[] f = {1,2,3,4,3,6};
	static int[] g = {3,5,67,98,3};
	
	public static int firstBadPair(int[] numX)
	{
		int index = 0;
		
		for(int i = 0;i<numX.length-1;i++)
		{
			if(numX[i] >= numX[i+1])
			{
				index = i;
				System.out.println("index of first bad pair: " + index + "\t" + "Value: " + numX[index]);
				break;
			}
		}
		
		return index;
	}
	
	public static int secondBadPair(int[] numX, int k)
	{
		int index = 0;
		
		for(int i = k;i<numX.length;i++)
		{
			
			if(numX[i] >= numX[i+1])
			{
				index = i+1;
				System.out.println("index of second bad pair: " + index + "\t" + "Value: " + numX[index]);
				break;
			}
		}
		return index;
	}
	
	public static boolean almostIncreasingSequence(int[] numX)
	{
		int k = firstBadPair(numX);
		
		ArrayList<Integer> a = new ArrayList<Integer>(numX.length);
		
		for(int i = 0;i<numX.length;i++)
		{
			System.out.println("added " + numX[i] + " to list.");
			a.add(numX[i]);
		}
		
		System.out.println("Removed first bad pair: " + a.get(k));
		a.remove(k);
		
		System.out.print("State of array: ");
		for(int i = 0;i< a.size();i++)
		{
			System.out.print(a.get(i) + " ");
		}
		System.out.println("");
		
		
		boolean check2nd = true;
		
		for(int i = 0;i<a.size()-1;i++)
		{
			System.out.println("Compare: " + a.get(i) + " with " + a.get(i+1));
			
			if(a.get(i) < a.get(i+1))
			{
				
			}else
			{
				System.out.println("List not increasing -- break and check 2nd pair");
				check2nd = false;
				break;
			}	
		}
		
		if(check2nd){
			System.out.print("List is increasing -- Return true --");
			System.out.print("IsConsecutive? : ");
			return true;
		}
		
			a = new ArrayList<Integer>(numX.length);
			
				for(int j = 0;j<numX.length;j++)
				{
					System.out.println("added " + numX[j] + " to list.");
					a.add(numX[j]);
				}
		
				k = secondBadPair(numX,k);
				
				System.out.println("Removed Second bad pair: " + a.get(k));
				a.remove(k);
				
				System.out.print("State of array: ");
				for(int i = 0;i< a.size();i++)
				{
					System.out.print(a.get(i) + " ");
				}
				
				System.out.println("");
				
				
				for(int i = 0;i<a.size()-1;i++)
				{
					System.out.println("Compare: " + a.get(i) + " with " + a.get(i+1));
					
					if(a.get(i) < a.get(i+1))
					{
						
					}else
					{
						System.out.println("List not increasing -- return false --");
						System.out.print("IsConsecutive? : ");
						return false;
					}
				}
		
		System.out.print("IsConsecutive? : ");
		return true;
	}
	public static void main(String[] args) 
	{	
		System.out.println(almostIncreasingSequence(a));
		/*
		System.out.println(almostIncreasingSequence(a));
		System.out.println(almostIncreasingSequence(b));
		System.out.println(almostIncreasingSequence(c));
		System.out.println(almostIncreasingSequence(d));
		System.out.println(almostIncreasingSequence(e));
		System.out.println(almostIncreasingSequence(f));
		System.out.println(almostIncreasingSequence(g));*/
	}

}
