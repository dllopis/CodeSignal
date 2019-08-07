package company;

public class OptimalStockBasket {
	/*
	 * Good opportunity to use knapsack problem logic
	 * Modified for 2D array input of GeeksforGeeks knapsack implementation
	 */
	int optimalStockBasket(int[][] stocks, int riskBudget) {
		return knapSack(riskBudget,stocks,stocks.length);
	}
	
	// Revised the knapsack method for 2D array
    private int knapSack(int riskBudget, int[][] stocks, int n) 
    { 
        if (n == 0 || riskBudget == 0) 
            return 0; 
        if (stocks[n - 1][1] > riskBudget) 
            return knapSack(riskBudget, stocks,n - 1); 
        else
            return max(stocks[n - 1][0] + knapSack(riskBudget - stocks[n - 1][1], stocks, n - 1), knapSack(riskBudget, stocks, n - 1)); 
    }
    // helper method for knapsack method
    private int max(int a, int b) { return (a > b) ? a : b; }
    
    public static void displayArray(int[][] a)	{
    	System.out.println("FUTURE PROFIT \t PROFIT RISK");
    	for(int i = 0;i<a.length;i++)	{
    		for(int j = 0;j<a[i].length;j++)	{
    			System.out.print("\t" + a[i][j] + "\t");
    		}System.out.println("");
    	}
    }
	public static void main(String[] args) {
		OptimalStockBasket osb = new OptimalStockBasket();
		
		int riskBudget1 = 30;
		int[][] input1 = {
			{-1,2},
			{10,15},
			{11,13},
			{9,10}
		}; // 21
		
		int riskBudget2 = 10;
		int[][] input2 = {
			{-1,2},
			{-2,3},
			{-1,1},
			{-3,2}
		}; // 0
		
		int riskBudget3 = 31;
		int[][] input3 = {
			{1,4},
			{2,5},
			{-1,2},
			{-2,5},
			{5,1},
			{3,2},
			{1,1},
			{1,2},
			{10,8},
			{20,18},
			{13,13},
			{9,12},
			{12,7},
			{10,12},
			{15,11}
		}; // 46
		
		displayArray(input1);
		System.out.println("Optimal stock basket profit: " + osb.optimalStockBasket(input1, riskBudget1));
		System.out.println("RiskBudget: " + riskBudget1 + "\n");
		
		displayArray(input2);
		System.out.println("Optimal stock basket profit: " + osb.optimalStockBasket(input2, riskBudget2));
		System.out.println("RiskBudget: " + riskBudget2 + "\n");
		
		displayArray(input3);
		System.out.println("Optimal stock basket profit: " + osb.optimalStockBasket(input3, riskBudget3));
		System.out.println("RiskBudget: " + riskBudget3 + "\n");
	}
}