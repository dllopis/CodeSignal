package arcade;
public class MineSweeper {

	public int[][] minesweeper(boolean[][] matrix) {
		int[][] solution = new int[matrix.length][matrix[0].length];
		
		System.out.println("EdgeCase Log:");
		for(int i = 0;i<matrix.length;i++)	{
			for(int j = 0;j<matrix[i].length;j++)	{
				if(matrix[i][j])	{
					System.out.print("\t(" + i + "," + j + ") -- ");
					// top-left corner (0,0)
					if(i == 0 && j == 0)	{
						System.out.println("EdgeCase [top Left Corner]");
						solution[i][j+1] += 1; 			// (0,1)
						solution[i+1][j] += 1; 			// (1,0)
						solution[i+1][j+1] += 1; 		//	(1,1)
					}
					// first top-row -- between top-left && top-right (non inclusive) (0,1)
					else if(i == 0 && j > 0 && j < matrix[0].length - 1)	{
						System.out.println("EdgeCase [First Row]");
						solution[i][j-1] 	+= 1;		// (0,0)
						solution[i][j+1] 	+= 1;		// (0,2)
						solution[i+1][j-1] 	+= 1;		// (1,0)
						solution[i+1][j] 	+= 1;		// (1,1)
						solution[i+1][j+1] 	+= 1;		// (1,2)
					}
					// top-right corner (0,2)
					else if(i == 0 && j == matrix[0].length-1)	{
						System.out.println("EdgeCase [top Right Corner]");
						solution[i][j-1] 	+= 1; 		// (0,1)
						solution[i+1][j-1] 	+= 1; 		// (1,1)
						solution[i+1][j] 	+= 1; 		// (1,2)
					}
					// first left-column -- between top-left && bot-left (non inclusive)
					else if(j == 0 && i > 0 && i < matrix.length-1)	{
						System.out.println("EdgeCase [First Column]");
						solution[i-1][j] 	+= 1;		// (0,0)
						solution[i-1][j+1] 	+= 1;		// (0,1)
						solution[i][j+1] 	+= 1;		// (1,1)
						solution[i+1][j] 	+= 1;		// (2,0)
						solution[i+1][j+1] 	+= 1;		// (2,1)
					}
					// last right-column -- between top-right && bot-right (non inclusive)
					else if(j == matrix[0].length-1 && i > 0 && i < matrix.length-1)	{
						System.out.println("EdgeCase [Last Column]");
						solution[i-1][j-1] 	+= 1;		// (0,1)
						solution[i-1][j] 	+= 1;		// (0,2)
						solution[i][j-1] 	+= 1;		// (1,1)
						solution[i+1][j-1] 	+= 1;		// (2,1)
						solution[i+1][j] 	+= 1;		// (2,2)
					}
					// bottom-left corner -- (2,0)
					else if(i == matrix.length-1 && j == 0)	{
						System.out.println("EdgeCase [Bottom Left Corner]");
							solution[i][j+1] += 1; 		// (0,1)
							solution[i-1][j] += 1; 		// (1,0)
							solution[i-1][j+1] += 1; 	//	(1,1)
					}
					// bottom-row -- (2,1)
					else if(i == matrix.length-1 && j > 0 && j < matrix[0].length-1)	{
						System.out.println("EdgeCase [Last Row]");
							solution[i][j-1] 	+= 1;		// (2,0)
							solution[i][j+1] 	+= 1;		// (2,2)
							solution[i-1][j-1] 	+= 1;		// (1,0)
							solution[i-1][j] 	+= 1;		// (1,1)
							solution[i-1][j+1] 	+= 1;		// (1,2)
					}
					// bottom-right (2,2)
					else if(i == matrix.length-1 && j == matrix[0].length-1)	{
						System.out.println("EdgeCase [Bottom Right Corner]");
						solution[i][j-1] 	+= 1; 		// (2,1)
						solution[i-1][j-1] 	+= 1; 		// (1,1)
						solution[i-1][j] 	+= 1; 		// (1,2)
					}
					else	{ // all edge cases fail -- in between cases -- (1,1)
						System.out.println("EdgeCase [All Edge Cases Failed]");
						// gather all cases up down left right and diagonals
						solution[i-1][j-1] 	+= 1;		// (0,0)
						solution[i-1][j] 	+= 1;		// (0,1)
						solution[i-1][j+1] 	+= 1;		// (0,2)
						solution[i][j-1] 	+= 1;		// (1,0)
						solution[i][j+1] 	+= 1;		// (1,2)
						solution[i+1][j-1] 	+= 1; 		// (2,0)
						solution[i+1][j] 	+= 1; 		// (2,1)
						solution[i+1][j+1] 	+= 1; 		// (2,2)
					}
				}
			}
		}System.out.println("");
		return solution;
	}
	public void display(int[][] a,String s)	{
		System.out.println(s);
		for(int i = 0;i<a.length;i++)	{
			for(int j = 0;j<a[i].length;j++)	{
				System.out.print("\t" + a[i][j] + " ");
			}System.out.println("");
		}
	}
	public void display(boolean[][] a,String s, String t)	{
		
		System.out.println(s);
		for(int i = 0;i<a.length;i++)	{
			for(int j = 0;j<a[i].length;j++)	{
				System.out.print("\t" + a[i][j] + " ");
			}System.out.println("\n");
		}
		
		System.out.println(t);
		for(int i = 0;i<a.length;i++)	{
			for(int j = 0;j<a[i].length;j++)	{
				System.out.print("\t" + "(" + i + "," + j + ")");
			}System.out.println("\n");
		}
	}
	public static void main(String[] args) {

		boolean[][] t1 = {
							{	true ,false,false	}, 
							{	false,true ,false	}, 
							{	false,false,false	}
		};
		
		boolean[][] t2 = {
				{	true ,false,false,true	}, 
		        {	false,false,true ,false	}, 
		        {	true ,true ,false,true	}	
		};
		
		boolean[][] t3 = {
				{false,true ,true ,false}, 
				{true ,true ,false,true}, 
			 	{false,false,true ,false}	
		};
		
		MineSweeper solution = new MineSweeper();
		boolean[][] testcase = t3;
		
		int[][] result = solution.minesweeper(testcase);
		solution.display(testcase, "Testcase [true/false Mine Grid]","Coordinate reference grid to help code edge cases.");
		solution.display(result,"Mine Sweeper: ");
	}

}
