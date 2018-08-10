package arcadeChallenges;

public class KnapsackLight {

	public int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
		
		/* if the sum of weights of both values are less than or equal to max weight */
	    if(weight1+weight2 <= maxW)	{
	    	System.out.println("Everything fits in sack!");
	    	return value1+value2;
	    }
	    /* if the first doesn't fit in sack -- check 2nd's weight */
	    if(weight1 > maxW && weight2 <= maxW)
	    	return value2;
	    /* if the second doesn't fit in sack -- check 1st's weight */
	    if(weight2 > maxW && weight1 <= maxW)
	    	return value1;
	    /* if both weights are under the max -- check for higher value -- */
	    if(weight1 <= maxW && weight2 <= maxW)	{
		    if(value1 > value2)
                return value1;
            else
                return value2;
	    }
	    /* all weight of items exceed max weight */
	    return 0;
	}

	public static void main(String[] args) {
		
		int value1 = 15;
		int value2 = 20;
		
		int weight1 = 2;
		int weight2 = 3;
		
		int maxW = 2;
		
		
		KnapsackLight solution = new KnapsackLight();
		System.out.println("Sack value: " + solution.knapsackLight(value1, weight1, value2, weight2, maxW));

	}

}
