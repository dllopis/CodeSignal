package arcadeChallenges;

public class DigitDegree {
	private int count = 0;
	private int sum = 0;
	
	public int digitDegree(int n) {
		if(n >= 10)	{
			System.out.println("n: " + n);
			count++;
			sum = 0;
			
			System.out.print("Add each Digit: ");
			while (n > 0) {
				   sum += (n % 10);
				   System.out.print(n%10 + " ");
				    n = n / 10;
			}System.out.println("\n");
			
			System.out.println("Sum: " + sum);
			
			if(sum >= 10)	{
				System.out.println("Recursion occurs now.");
				return
					digitDegree(sum);
			}else
				return count;
		}
		else
			return count;
	}
	
	public static void main(String[] args) {
		DigitDegree solution = new DigitDegree();
		System.out.println(solution.digitDegree(1234598765));

	}

}
