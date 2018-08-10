package arcadeChallenges;

public class DepositProfit {

	public int depositProfit(int deposit, int rate, int threshold) {
		return (int)Math.ceil(Math.log((double)threshold/deposit)/Math.log((1+(double)rate/100)));
	}
	
	public static void main(String[] args) {
		DepositProfit solution = new DepositProfit();
		System.out.println(solution.depositProfit(1, 100, 64));

	}

}
