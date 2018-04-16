
public class FirstDuplicate {
	// time out error with this attempt!
	
	
	static int[] a = {8, 4, 6, 2, 6, 4, 7, 9, 5, 8};
	static int[] b = {2,3,3};
	static int firstDuplicate(int[] a)
	{
		 // this will hold index of duplicates found and returned when loop is done
    	int firstDup = -1;
    
    // this will hold index of duplicate to compare with first dup
		int checkDup = 0;
    
    // this will be the pointer to check and see if a duplicate exist for this integer a[j]
		int j = 0;
		
    
		for(int i = 1;i<a.length;i++)
		{
            
			if(a[j] == a[i])
			{
                // first duplicate that is found will initialize firstDup
                // and continue to start finding additional dupes to compare indexes
				if(firstDup == -1)
				{
                    // index of duplicate is saved
					firstDup = i;
                    
                    // increment pointer to next element to check for dups
					j++;
                    
                    // reset i to position after j and continue checks
					i=j+1;
                    
                    // jump to next iteration since we found our firstDup
					continue;
				}
				
                
                // saved index of our currentDup
				checkDup = i;
				
                // check if it's less than our currentDup
				if(checkDup < firstDup)
				{
                    // if it is, then save our new index of the duplicate
					firstDup = checkDup;
                    // increment our pointer
					j++;
                    // and reset i to one position after j
					i = j+1;
				}
			}
            
            // this ensures everything is checked for duplicates
            // when j is equal to a.length, we can exit the loop and return the result
            if(j != a.length-1 && i == a.length-1)
			{
				j++;
				i=j;
			}
		}
    
    // cycled through array and no duplicate existed
        if(firstDup == -1)
			return -1;
    
	return a[firstDup];
	}
	
	public static void main(String args[])
	{
		System.out.println("First Dupe: " + firstDuplicate(a));
		System.out.println("First Dupe: " + firstDuplicate(b));
	}
}
