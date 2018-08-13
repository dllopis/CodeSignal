package arcade;

public class BoxBlur {

	int[][] image1 =	{		
			{1,1,1}, 
	        {1,7,1}, 
	        {1,1,1}
	};
	int[][] image2 =	{	
			{36,0,18,9}, 
	        {27,54,9,0}, 
	        {81,63,72,45}
	};
	
	int[][] image3 =	{
			{36,0,18,9,9,45,27}, 
	        {27,0,54,9,0,63,90}, 
	        {81,63,72,45,18,27,0}, 
	        {0,0,9,81,27,18,45}, 
	        {45,45,27,27,90,81,72}, 
	        {45,18,9,0,9,18,45}, 
	        {27,81,36,63,63,72,81}
	};
	
	public int[][] boxBlur(int[][] image) {
		int newRowSize = image.length-2;
		int newColSize = image[0].length-2;
		int[][] solution = new int[image.length-2][image[0].length-2];
		
		/* first two for-loops correspond with the new 2d matrix that will hold the 3x3 submatrix sum/9 results */
		for(int i = 0;i<newRowSize;i++)	{
			for(int j = 0;j<newColSize;j++)	{
				// keep resetting sum to zero before calculating next sub matrix
				int matrixSum = 0;
				/* these next two for-loops are targeting each 3x3 sub matrix until finished */
				for(int row = i;row<i + 3;row++)	{
					for(int col = j;col<j + 3;col++)	{
						System.out.print(image[row][col] + " ");
						/* summing all elements in the 3x3 matrix */
						matrixSum += image[row][col];
					}System.out.println("");
				}
				System.out.println("Matrix Sum: " + matrixSum + "\tBlur: " + matrixSum/9);
				/* storing result of the 3x3 to its proper location */
				solution[i][j] = matrixSum/9;
			}
		}
			return solution;
		}

	public void display(int[][] a)	{
		for(int i = 0;i<a.length;i++)	{
			for(int j = 0;j< a[i].length;j++)	{
				System.out.print(a[i][j] + " ");
			}System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		
		BoxBlur solution = new BoxBlur();
		int[][] result = solution.boxBlur(solution.image3);
		solution.display(result);
		
	}

}
