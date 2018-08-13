package interview;

import java.util.HashSet;
import java.util.Set;

public class Sudoku2 {
	
	static char[][] grid = {
		{'6', '.', '.', '1', '4', '.', '.', '2', '.'},
		{'.', '.', '6', '.', '.', '.', '.', '.', '.'},
		{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
		{'.', '.', '1', '.', '.', '.', '.', '.', '.'},
		{'.', '6', '7', '.', '.', '.', '.', '.', '9'},
		{'.', '.', '.', '.', '.', '.', '8', '1', '.'},
		{'.', '3', '.', '.', '.', '.', '.', '.', '6'},
		{'.', '.', '.', '.', '.', '7', '.', '.', '.'},
		{'.', '.', '.', '5', '.', '.', '.', '7', '.'}
	};
	
	static char[][] grid2 = {
		{'.','.','.','1','4','.','.','2','.'}, 
		{'.','.','6','.','.','.','.','.','.'},
		{'.','.','.','.','.','.','.','.','.'},
		{'.','.','1','.','.','.','.','.','.'}, 
		{'.','6','7','.','.','.','.','.','9'}, 
		{'.','.','.','.','.','.','.','1','.'}, 
	 	{'.','3','.','.','.','.','.','.','6'}, 
		{'.','.','.','.','.','7','.','.','.'}, 
	 	{'.','.','.','5','.','.','.','7','.'}
	};
	public void displayPuzzle(char[][] puzzle)	{
		for(int i = 0; i < puzzle.length;i++)
		{
			for(int j = 0;j < puzzle[0].length;j++)
			{
				System.out.print(puzzle[i][j] + " ");
			}System.out.println(" ");
		}
		System.out.println("");
	}
	public boolean sudoku2(char[][] grid)	{
		
		return validatePuzzle(grid2);
	}
	
	private boolean validatePuzzle(char[][] grid)	{

        // Validate rows
        for(int i=0;i<grid.length;i++)	{
    		// store each character and preserving insertion order
            
        	Set<Character> rowCheck = new HashSet<Character>();
        	for(int j = 0;j<grid[i].length;j++)	{
        		
        		if(grid[i][j] == '.')	{
            		continue;
        		}
            	if(!rowCheck.add(grid[i][j]))
            		return false;	
        	}
          }
        
        // Validate columns
        for(int i=0;i<grid.length;i++)	{
    		// store each character and preserving insertion order
            
        	Set<Character> colCheck = new HashSet<Character>();
        	for(int j = 0;j<grid[i].length;j++)	{
        		
        		if(grid[j][i] == '.')	{
            		continue;
        		}
            	if(!colCheck.add(grid[j][i]))
            		return false;	
        	}
          }
        
        // validate sub matrices of puzzle
        int rowStart = 0;
        int colStart = 0;
        int grids = 0;
        while(grids != grid.length)	{
        	
        	Set<Character> matrixCheck = new HashSet<Character>();
        	
        	for(int  i = rowStart;i < rowStart + 3;i++)
            {
            	for(int j = colStart;j<colStart + 3;j++)
            	{
            		if(grid[i][j] == '.')	{
                		continue;
            		}else
            			if(!matrixCheck.add(grid[i][j]))
                    		return false;
            	}	
            }
        	
        	System.out.println("Elements in subMatrix-" + (grids+1) + ": " + matrixCheck.size());	
        	System.out.println("subMatrix is valid - no duplicates.");
        	grids++;
        	
        	if(rowStart != 6 ) {
        		rowStart += 3;
        	}else	{
        			colStart += 3;
        			rowStart = 0;
        	}
        	
        	if(grids == grid.length)
        		break;
        }
		return true;
	}
	
	public static void main(String[] args) {
		Sudoku2 sudoku = new Sudoku2();
		sudoku.displayPuzzle(grid2);
		System.out.println(sudoku.sudoku2(grid2));
	}

}
