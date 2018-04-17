package arcadeChallenges;

public class MatrixElementsSum {

	
	public static int matrixElementsSum(int[][] matrix) {

	    int sum = 0;
	    int row= matrix.length;
	    int col = matrix[0].length;
	    
	    System.out.println("Col: " + col + "\t" + "Row: " + row);
	    
	    for(int i = 0;i<col;i++)
	    {
	    	for(int j=0;j<row;j++)
	    	{
	    		if(matrix[j][i] > 0)
	    			sum += matrix[j][i];
	    		else
	    			break;
	    	}
	    	//System.out.println("");
	    }
	    
	    return sum;
	}
	
	public static void main(String[] args) {
		
		int[][] matrix1 = {
							{0, 1, 1, 2}, 
							{0, 5, 0, 0}, 
							{2, 0, 3, 3}
						};
		
		int[][] matrix2 = {
							{1, 1, 1, 0 }, 
							{0, 5, 0, 1 }, 
							{2, 1 ,3, 10}
						  };
		
		System.out.println(matrixElementsSum(matrix2));
	}

}
