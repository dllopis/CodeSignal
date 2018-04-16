package arcadeChallenges;

public class MatrixElementsSums {
	
	public static int[][] m = {
								{0, 1, 1, 2}, 
								{0, 5, 0, 0}, 
								{2, 0, 3, 3}
	                          };
	
	public static int columnSum(int [][] array){

	    int size = array[0].length; // Replace it with the size of maximum length inner array
	    int sum = 0;

	    for (int i = 0; i < array.length; i++){
	        for (int j = 0; j < array[i].length; j++){
	        	if(array[i][j] >=1)
	            sum += array[i][j];  // Note that, I am adding to `temp[j]`.
	        	
	        }
	    }

	    //System.out.println(Arrays.toString(temp));
	    return sum;  // Note you are not using this return value in the calling method
	}
	static int matrixElementsSum(int[][] matrix) {

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

	
	public static void displayMatrix(int[][] matrix)
	{
		for(int i = 0;i<m.length;i++)
		{
			for(int j = 0;j<m[i].length;j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}
	public static void main(String[] args) {
		
		//displayMatrix(m);
		System.out.println("Matrix Sum: " + matrixElementsSum(m));
		System.out.println("Matrix Sum: " + columnSum(m));
	}

}
