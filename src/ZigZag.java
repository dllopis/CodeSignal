import java.util.ArrayList;
//complete

public class ZigZag {

	static int zigZagCount(int[] a) {

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
	
	   public static int zigZag(int a[])
	    {
		   ArrayList<Integer> array = null;
	        int result = 0;
	        int lengthOfZigZag = 0;
	        
	        // Pick starting point
	        for (int i = 0; i < a.length; i ++)
	        {
	            // Pick ending point
	            for (int j = i; j < a.length; j ++)
	            {
	            	array = new ArrayList<Integer>();
	                // sum subarray between current
	                // starting and ending points
	            	// iterate to check for zigzag's
	        	    for(int k = i;k<=j;k++)
	        	    {
	        	    	array.add(a[k]);
	        	    }
	        	    
	        	    int[] temp = new int[array.size()];
	        	    
	        	    for(int x = 0;x<array.size();x++)
	        	    {
	        	    	temp[x] = array.get(x);
	        	    	System.out.print(temp[x] + " ");
	        	    }
	        	    System.out.println("");
	        	   
	        	    lengthOfZigZag = zigZagCount(temp);
	        	   
	            }
	        	    if(lengthOfZigZag > result)
	        	    {
	        	    	result = lengthOfZigZag;
	        	    }
	        }
	 
	        return result ;
	    }
	   
	   
	public static void main(String[] args) {

		//test cases
		int[] a = {9, 8, 8, 5, 3, 5, 3, 2, 8, 6};
		int[] b = {7, 3, 5, 5, 2};
		int[] c = {4};
		int[] d	= {9, 8, 8, 5, 3, 5, 3, 2, 8, 6};
		int[] e = {5, 3, 5, 3} ;
		//System.out.println(zigZag(d));
		//System.out.println(SubArraySum(e));
		System.out.println("Longest ZigZag subArray: " + zigZag(d));
		System.out.println("isZigZag? return length: " + zigZagCount(d));
		
	}

}
