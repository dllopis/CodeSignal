package arcade;

public class DigitsProduct {
	// brute force and use 10000 as a benchmark
	public int digitsProduct(int product) {
		
		// do not start at 0
		for(int i = 1;i<10000;i++)	{
			if(digitsProd(i) == product)
				return i;
		}
		return -1;
	}
	// helper method to multiply individual digits together and return the sum
	private int digitsProd(int n)	{
		int prodSum = 1;
		
		while(n>0)	{
			prodSum *= n%10;
			n /= 10;
		}System.out.println(prodSum);
		
		return prodSum;
	}
	public static void main(String[] args) {
		DigitsProduct solution = new DigitsProduct();
		System.out.println("solution: " + solution.digitsProduct(0));
	}
}
