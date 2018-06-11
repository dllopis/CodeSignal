package interviewPractice;

public class RotateImage {
	
	static int[][] a = 	{{1,2,3},
				 {4,5,6},
				 {7,8,9}};
	
	public static void displayMatrix(int[][] array)
	{
		for(int i = 0;i< array.length;i++)
		{
			for(int j = 0;j<array[0].length;j++)
			{
				System.out.print(array[i][j] + " ");
			}System.out.println(" ");
		}
		System.out.println(" ");
	}
	
	public static int[][] rotateImage(int[][] a)
	{
		int[][] b = new int[a.length][a[0].length];
		int row = 0;
		int col = a[0].length-1;
		
		System.out.println("rowStart: " + row +"\ncolStart: " + col +"\nrotateDegree: 90\n");
		
		if(a.length == 1)
			return a;
		
		// iterate once through matrix and complete the rotation on 'b matrix'
		for(int i =0;i<a.length;i++)
		{
			for(int j = 0;j<a[0].length;j++)
			{
				b[row][col] = a[i][j];
				row++;
			}
			row = 0;	// reset row to target first row
			col -= 1;	// decrement col to move to next column
		}
		a = b; // original matrix is now equal to the rotated matrix
		
		return a;
	}
	public static void main(String[] args) {
		
		displayMatrix(a);
		displayMatrix(rotateImage(a));
	}

}
