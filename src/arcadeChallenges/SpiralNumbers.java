package arcadeChallenges;

import java.util.Arrays;

public class SpiralNumbers {

	int startRow = 0;
	int startCol = 0;
	int reduce = 0;
	int num = 1;
	
	int[][] spiralNumbers(int n) {
		int[][] result = new int[n][n];
		int matrixSize = n*n;
		
		/*
		 * 4 for loops -- each loop represents a side
		 *  	>>  [1]  >>
		 *  	^         v
		 * 	   [4]  	  v
		 *  	^  		 [2]
		 *  	^		  v
		 *  	<<  [3]  <<
		 */
	while(num <= matrixSize)	{
		// 1
		System.out.println("--across-->");
		for(int i = startCol;i<result[0].length-reduce;i++)	{
			System.out.println("(" + i + "," + startCol + ")\t" + "Value: " + num);
			result[startRow][startCol++] = num++;;
		}
		System.out.println("");
		startRow++;
		startCol = result.length-1-reduce;
		
		// 2
		System.out.println("--down--v");
		for(int i = startRow;i<result.length-reduce;i++)	{
			System.out.println("(" + i + "," + startCol + ")\t" + "Value: " + num);
			result[i][startCol] = num++;
		}
		System.out.println("");
		startRow = result.length-reduce-1;
		startCol = result.length-reduce-2;
		
		// 3
		System.out.println("<--left--");
		for(int i = startCol;i >= 0 + reduce;i--)	{
			System.out.println("(" + i + "," + startCol + ")\t" + "Value: " + num);
			result[startRow][i] = num++;;
		}
		System.out.println("");
		startRow = startRow-1;
		startCol = reduce;
		
		//  4
		System.out.println("^--cycle complete--");
		for(int i = startRow;i>0+reduce;i--)	{
			System.out.println("(" + i + "," + startCol + ")\t" + "Value: " + num);
			result[i][startCol] = num++;			
		}
		// increment to next starting point
		reduce++;
		// set starting positions
		startRow = reduce;
		startCol = reduce;
	}	
	return result;
}

	public void display(int[][] matrix, String s)	{
		System.out.println(s);
		for(int i = 0;i<matrix.length;i++)	{
			System.out.println(Arrays.toString(matrix[i]));
		}System.out.println("\n");
	}
	public void displayCoordinates(int[][] matrix, String s)	{
		System.out.println(s);
		for(int i = 0;i<matrix.length;i++)	{
			for(int j = 0;j< matrix[i].length;j++)	{
				System.out.print("(" + i + "," + j + ")" + " ");
			}System.out.println("");
		}System.out.println("");
	}
	public static void main(String[] args) {
		SpiralNumbers solution = new SpiralNumbers();
		
		int[][] t1 = {
					{  1,  2,  3,  4,  5, },
			        { 16, 17, 18, 19,  6, },
			        { 15, 24, 25, 20,  7, },
			        { 14, 23, 22, 21,  8, },
			        { 13, 12, 11, 10,  9  }
        };
		int n = 7;
		solution.displayCoordinates(t1, "Coordinate Grid");
		int[][] result = solution.spiralNumbers(n);
		solution.display(result, "Spiral Matrix: (Our Solution)");
		

	}

}
