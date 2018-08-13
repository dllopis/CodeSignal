package arcade;

import java.util.Arrays;

public class ArrayReplace {

	int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
	    for(int i = 0;i<inputArray.length;i++)  {
	        if(inputArray[i] == elemToReplace)
	            inputArray[i] = substitutionElem;
	    }
	    return inputArray;
	}
	
	public static void main(String[] args) {
		ArrayReplace solution = new ArrayReplace();
		int[] inputArray = {1, 2, 1, 2, 1};
		int elemToReplace = 2;
		int substitutionElem = 1;
		
		int[] result = solution.arrayReplace(inputArray, elemToReplace, substitutionElem);
		System.out.println(Arrays.toString(result));
	}

}
