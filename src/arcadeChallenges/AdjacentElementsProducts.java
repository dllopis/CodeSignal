package arcadeChallenges;

public class AdjacentElementsProducts {

	public static int adjacentElementsProduct(int[] inputArray) {
	    
	    int largestProduct = 0;
	    
	    if(inputArray.length>1)
	    {
	    	largestProduct = inputArray[0] * inputArray[1];
	    }else
	    {
	    	System.out.println("No adjacent element exists for inputArray");
	    	return largestProduct;
	    }
	    
	    for(int i = 0;i<inputArray.length-1;i++)
	    {
	    	
	    	int tempProduct = inputArray[i] * inputArray[i+1];
	    	
	    	if(tempProduct > largestProduct)
	    	{
	    		largestProduct = tempProduct;
	    	}
	    }
	    
		return largestProduct;
	}
	
	public static void main(String args[])
	{
		int[] array = {3,6,-2,-5,7,3};
		int[] array2 = {-23, 4, -3, 8, -12};
		int[] array3 = {3};
		
		System.out.println(adjacentElementsProduct(array2));
	}
}
