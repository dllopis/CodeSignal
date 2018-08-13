package interview;

import java.util.HashSet;
import java.util.Set;

public class FirstDuplicate {

	public static int firstDuplicate(int[] a) {
		
		int firstDuplicate = -1; // -1 means a duplicate has not been found yet
		int indexDuplicate = -1; // serves as index location for first duplicate
		
		// Hash set is used to check for duplicates - unique values can only be stored -- no duplicates
		// stores original array contents to help search faster for duplicates
		Set<Integer> keys = new HashSet<Integer>();
		
		// iterate through original array
        for(int i = 0;i<a.length;i++){
        	
        	// if false occurs, then we've found a dupe
            if(!keys.add(a[i]))
            {
            	// save the current index in order to compare for which duplicate occurred first
            	int currIndex = i;
            	
            	// first duplicate found -- store value and index to compare future duplicates
            	if(firstDuplicate == -1)
            	{
            		firstDuplicate = a[currIndex];
            		indexDuplicate = currIndex;
            		System.out.println("Duplicate at index: " + i + "\tValue: " + a[i]);
            		continue;
            	}else{
            		System.out.println("Duplicate at index: " + i + "\tValue: " + a[i]);
            		System.out.println("current index: " + currIndex + "\tFirstDuplicate index: " +indexDuplicate);
            		
            		// checks to see which duplicate occured first and assigns to firstDuplicate
            		if(currIndex < indexDuplicate)
            		{
            			firstDuplicate = a[currIndex];
            			System.out.println("Earlier duplicate found -- replace --");
            		}
            	}
            }
        }

        if(firstDuplicate == -1)
        {
        	System.out.println("No duplicates!");
        }else
            System.out.println("FirstDuplicate: " + firstDuplicate);
        
		return firstDuplicate;
	}
	public static void main(String args[])
	{
		
		int[] a = {2, 1, 3, 5, 3, 2};
		firstDuplicate(a);
	}
}
