package arcade;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {
	
	static int[][] grid = {
		{1,3,2,5,4,6,9,8,7},
		{4,6,5,8,7,9,3,2,1},
		{7,9,8,2,1,3,6,5,4},
		{9,2,1,4,3,5,8,7,6},
		{3,5,4,7,6,8,2,1,9},
		{6,8,7,1,9,2,5,4,3},
		{5,7,6,9,8,1,4,3,2},
		{2,4,3,6,5,7,1,9,8},
		{8,1,9,3,2,4,7,6,5}
	};
	
	public void displayPuzzle(int[][] puzzle)	{
		for(int i = 0; i < puzzle.length;i++)
		{
			for(int j = 0;j < puzzle[0].length;j++)
			{
				System.out.print(puzzle[i][j] + " ");
			}System.out.println(" ");
		}
		System.out.println("");
	}
	public boolean sudoku(int[][] grid)	{
		
		return validatePuzzle(grid);
	}
	
	private boolean validatePuzzle(int[][] grid)	{

        // Validate rows
        for(int i=0;i<grid.length;i++)	{
    		// store each character and preserving insertion order
            
        	Set<Integer> rowCheck = new HashSet<Integer>();
        	for(int j = 0;j<grid[i].length;j++)	{
        		
        		if(grid[i][j] == '.')	{
            		continue;
        		}
            	if(!rowCheck.add(grid[i][j]))
            		return false;	
        	}
          }System.out.println("All rows validated - no duplicates - ");
        
        // Validate columns
        for(int i=0;i<grid.length;i++)	{
    		// store each character and preserving insertion order
            
        	Set<Integer> colCheck = new HashSet<Integer>();
        	for(int j = 0;j<grid[i].length;j++)	{
        		
        		if(grid[j][i] == '.')	{
            		continue;
        		}
            	if(!colCheck.add(grid[j][i]))
            		return false;	
        	}
          }System.out.println("All columns validated - no duplicates - ");
        
        // validate sub matrices of puzzle
        int rowStart = 0;
        int colStart = 0;
        int grids = 0;
        while(grids != grid.length)	{
        	
        	Set<Integer> matrixCheck = new HashSet<Integer>();
        	
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
        	grids++;
        	
        	if(rowStart != 6 ) {
        		rowStart += 3;
        	}else	{
        			colStart += 3;
        			rowStart = 0;
        	}
        	
        	if(grids == grid.length)
        		break;
        }System.out.println("All 3x3 subMatrices validated - no duplicates - ");
		return true;
	}
	
	public static void main(String[] args) {
		Sudoku sudoku = new Sudoku();
		sudoku.displayPuzzle(grid);
		System.out.println("\nisSudokuSolved: " + sudoku.sudoku(grid));
	}
}
