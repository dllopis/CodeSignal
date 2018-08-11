package arcadeChallenges;

import java.util.HashSet;
import java.util.Set;

public class DifferentSquares {

	public int differentSquares(int[][] matrix) {
		Set<String> set = new HashSet<String>();
		String temp = "";
		int RowSize = matrix.length-1;
		int ColSize = matrix[0].length-1;
		
		for(int i = 0;i<RowSize;i++)	{
			for(int j = 0;j<ColSize;j++)	{
				// keep resetting temp to build next string from 2x2
				temp = "";
				/* these next two for-loops are targeting each 2x2 sub matrix until finished */
				for(int row = i;row<i + 2;row++)	{
					for(int col = j;col<j + 2;col++)	{
						System.out.print(matrix[row][col] + " ");
						/* building temp string with all elements in the 2x2 */
						temp += matrix[row][col];
					}System.out.println("");
				}
				/* storing unique strings only to set */
				System.out.println("temp: " + temp);
				set.add(temp);
			}
		}
		return set.size();
	}
	
	public static void main(String[] args) {
		int[][] t1 =  {
				{1, 2, 1},
				{2, 2, 2},
				{2, 2, 2},
				{1, 2, 3},
               	{2, 2, 1}
		};// result = 6
		
		System.out.println("------------");
		for(int i = 0;i<t1.length;i++)	{
			for(int j = 0;j<t1[i].length;j++)	{
				System.out.print(t1[i][j] + " ");
			}System.out.println("");
		}System.out.println("------------");
		DifferentSquares solution = new DifferentSquares();
		System.out.println(solution.differentSquares(t1));

	}

}
