package arcadeChallenges;

public class AllLongestStrings {

	static String[] allLongestStrings(String[] inputArray) {

		// container storing new input containing longest strings
		String[] longestStrings = null;
		
		// size of new array to be calculated after confirming the number of longest strings
		int sizeOfReturnArray = 0;
		int previousSizeOfReturnArray = 0;
		int count = 0;
		
		// longest length string of inputArray will be saved and compared to target only those strings
		int lengthOfLongest = 0;
		

		
		
	// store first string's length before comparing
		lengthOfLongest = inputArray[0].length();
		System.out.println("String: " + inputArray[0] + "\t" + "String length: " + inputArray[0].length());
		
		// increment the size of the array for the new length found
		sizeOfReturnArray++;
		previousSizeOfReturnArray++;
		
		// first pass - we search for longest string length
		// and occurrences of those strings with the same length
		// to help create the right size container for return array
		for(int i = 1;i<inputArray.length;i++)
		{
			//output test to see iterations
			System.out.println("String: " + inputArray[i] + "\t" + "String length: " + inputArray[i].length());
			
			// compare each string with current length of the longest string
			if(inputArray[i].length() >= lengthOfLongest)
			{
				//longest string found -- update size of return array
				sizeOfReturnArray++;
				
				// reduce the size of previousSize to account for the previous elements added
				// that need to be removed to reflect proper size of return array
				previousSizeOfReturnArray= sizeOfReturnArray - previousSizeOfReturnArray;
				
				// Makes sure to account for previous longest strings that are now
				// strictly less than new longest string found
				// in order to modify the size of the return array
				if(lengthOfLongest < inputArray[i].length())
				{
					//Modify size of return array and discard results of previous
					//occurences found
					sizeOfReturnArray -= previousSizeOfReturnArray;
				}
				
				// we found a string with a larger length
				lengthOfLongest = inputArray[i].length();
				
			}
		}

		// output test to make sure size of array is correct
		System.out.println("Size of new array: " + sizeOfReturnArray);
		
		//initialize longest strings with the calculated size of new array
		longestStrings = new String[sizeOfReturnArray];
		
		// this will serve as the iterator for the new array to fill in elements
		// with largest length
		int j = 0;
		
		//second pass - we now check each string in inputArray again and take those values
		// that are equal to the longestLength and store them into the return array
		for(int i = 0; i < inputArray.length;i++)
		{
			if(inputArray[i].length() == lengthOfLongest)
			{
				longestStrings[j] = inputArray[i];
				j++;
			}
		}
		// return new array populated with longest strings
		return longestStrings;
	}
	
	public static void display(String[] stringX)
	{
		for(int i = 0;i<stringX.length;i++)
		{
			System.out.println(stringX[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] s = {"aba", "aa", "ad", "vcd", "aba"};
		String[] y = {"abc", "eeee", "abcd", "dcd"};
		String[] z = {"a","abc", "cbd", "zzzzzz", "a", "abcdef", "asasa", "aaaaaa"};
		
		String[] a = allLongestStrings(z);
		display(a);
	}

}
