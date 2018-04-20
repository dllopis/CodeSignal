package quickChallenges;

/*
 * Dennis LLopis
 * Quick Challenge - assessment- 
 * 
 * From an original matrix (2D array) , create a submatrix with parameters of which
 * rows and columns are to be deleted
 * 
 */
public class ConstructSubMatrix {

	public static int[][] constructSubmatrix(int[][] matrix, int[] rowsToDelete, int[] columnsToDelete){
	    
	    // construct the new matrix with new dimensions
	    int mat2[][]= new int [matrix.length- rowsToDelete.length][matrix[0].length - columnsToDelete.length ];
		
	    // index pointer for adding values to new matrix constructed
	    // p is our row pointer for new matrix
	    int p=0;
	     
		// index pointers for our rows and cols to delete
		int p1 = 0;
	    
	    // start constructing matrix based on parameters [ rowsToDelete & columnsToDelete ]
	    for( int i = 0; i <matrix.length; ++i)
	    {
	    	// this handles edge case of nothing to be deleted
	    	// and handles index out of bounds edge case as well
	    	if(p1 < rowsToDelete.length)
	    		//found row to be deleted/excluded
	    		if(rowsToDelete[p1] == i)
	   		   	{
	    		   // increment our pointer to next element in rowsToDelete
	   			   p1++;
	   			   // move on to next row
	   			   continue;
	   		   	}
	    	// reset position of q to target first column of new matrix
		        int q = 0;

		    // reset position of p2 pointer to first index, so that we can compare jth column again
		        int p2=0;
	        for( int j = 0; j <matrix[0].length; ++j)
	        {
	        	// same as above for p1 on line 32, but this handles the columns edge cases
	        	 if(p2 < columnsToDelete.length)
	  			   if(columnsToDelete[p2] == j)
	  			   {
	  				   p2++;
	  				   continue;
	  			   }
	        	// add value to this row-column of new matrix from original matrix
	            mat2[p][q] = matrix[i][j];
	            // move to next column - same row -
	            ++q;
	        }
	        
		    // move to next row of new matrix
		        ++p;
	    }
	    	// return newly constructed submatrix
	        return mat2;
		}

	// display 2D matrix
	public static void display(int[][] n)
	{
		 for(int i = 0;i<n.length;i++)
		 {
			 System.out.print("\t");
			 for(int j = 0;j<n[0].length;j++)
			 {
				 System.out.print(n[i][j] + " ");
			 }System.out.println("");
		 }
	}
	
	// display 1D array
	public static void display(int[] n)
	{
		for(int i = 0;i<n.length;i++)
		{
			System.out.print(n[i] + " ");
		}System.out.println("");
	}
	
	// driver method for running program
	public static void runProgram()
	{
		// original matrix
		 int[][] matrix = 	{
				 			{1, 0, 0, 2}, 
				 			{0, 5, 0, 1}, 
				 			{0, 0, 3, 5}
				 						};
		 System.out.println("Original Matrix: ");
		 display(matrix);
		 
		 // parameters to construct the submatrix
		 int[] rowsToDelete = {1};
		 int[] colsToDelete = {0,2};
	
		 // construct the submatrix with above parameters
		 int[][] n = constructSubmatrix( matrix, rowsToDelete, colsToDelete);
		 
		 System.out.print("Rows deleted: ");
		 display(rowsToDelete);
		 
		 System.out.print("Cols deleted: ");
		 display(colsToDelete);
		 

		 System.out.println("Constructed submatrix: ");
		 display(n);
	}
	
	public static void main(String[] args) {
		
		runProgram();
	}

}
