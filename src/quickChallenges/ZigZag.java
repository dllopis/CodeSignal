package quickChallenges;
import java.util.ArrayList;
import java.util.Collections;
/*
 * Dennis LLopis - ZigZag Challenge
 * 
 * A sequence of integers is called a zigzag sequence if each of its elements is either 
 * strictly less than all its neighbors or strictly greater than all its neighbors. 
 * 
 * For example, the sequence 4 2 3 1 5 3 is a zigzag, but 7 3 5 5 2 and 3 8 6 4 5 aren't. Sequence of length 1 is also a zigzag.
 * For a given array of integers return the length of its longest contiguous sub-array that is a zigzag sequence. 
 */

	public class ZigZag {
	
	/*
	 * This method will create an a new arraylist for every subarray
	 * and will call zigZagCount to return the length of each zigzag subarray.
	 * When method terminates, it will return the largest count of zigzag from one 
	 * of the subarrays.
	 */
	   public static int zigZag(int a[])
	    {
		   ArrayList<Integer> array = new ArrayList<Integer>();
		   
		   	// stores result of longest zigZag found
	        int result = 0;
	        
	        // stores current longest zigZag and compared to result
	        int lengthOfZigZag = 0;
	        
	        // Pick starting point of subarray
	        for (int i = 0; i < a.length; i ++)
	        {
	            // Pick an ending point of subarray
	            for (int j = i; j < a.length; j ++)
	            {
	            	// new arraylist for this subarray
	            	array = new ArrayList<Integer>();
	            	
	                // sum subarray between current
	                // starting and ending points
	            	// iterate to check for zigzag's
	        	    for(int k = i;k<=j;k++)
	        	    {
	        	    	array.add(a[k]);
	        	    }
	        	    
	        	    // store current subarray and call zigZagCount
	        	    // compare to result
	        	    int[] temp = new int[array.size()];
	        	    
	        	    for(int x = 0;x<array.size();x++)
	        	    {
	        	    	temp[x] = array.get(x);
	        	    	System.out.print(temp[x] + " ");
	        	    }
	        	    System.out.println("");
	        	   
	        	    lengthOfZigZag = zigZagCount(temp);
	        	   
	        	    if(lengthOfZigZag > result)
	        	    {
	        	    
	        	    	result = lengthOfZigZag;
	        	    }
	            }
	        	   
	        }
	        return result ;
	    }
		
	   public static int zigZagCount(int[] a) {

			int lengthOfZigZag = 0;
			
			// array of length-1
			if(a.length == 1)
			{
				lengthOfZigZag = 1;
				
				return lengthOfZigZag;
			}
			
			// iterate to check for zigzag
		    for(int i = 0;i<a.length;i++)
		    {
		    	// first element
		    	if(i == 0)
		    	{
		    		if(a[i] != a[i+1])
		    		{
		    			lengthOfZigZag++;
		    		}
		    	// last element
		    	}else if(i == a.length-1)
		    	{
		    		if(a[i] != a[i-1])
		    		{
		    			lengthOfZigZag++;
		    		}
		    		
		    	// elements in between
		    	}else
		    	{
		    		// strictly less than neighbors or strictly greater than neighbors
		    		if(a[i] < a[i-1] && a[i] < a[i+1] || a[i] > a[i-1] && a[i] > a[i+1])
		    		{
		    			lengthOfZigZag++;
		    		}else
		    		{
		    			lengthOfZigZag = 0;
		    			break;
		    		}
		    	}
		    }
		    	return lengthOfZigZag;
		}
	public static void main(String[] args) {

		//test cases
		int[] a = {9, 8, 8, 5, 3, 5, 3, 2, 8, 6};
		int[] b = {7, 3, 5, 5, 2};
		int[] c = {4, 1, 2, 0, 1, 0};
		int[] d	= {2, 1, 4, 4, 1, 4, 4, 1, 2, 0, 1, 0, 0, 3, 1, 3, 4, 1, 3, 4};
		int[] e = {5, 3, 5, 3} ;
		
		   
		System.out.println("Longest ZigZag subArray: " + zigZag(d));
		}
	}

