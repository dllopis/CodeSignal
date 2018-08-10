package arcadeChallenges;

public class CircleOfNumbers {

	int circleOfNumbers(int n, int firstNumber) {
	    if(firstNumber < n/2)
	        return  firstNumber + (n/2);
	    else
	        return firstNumber - (n/2);
	}
	
	public static void main(String[] args) {
		int t1_n = 10;
		int t2_n = 6;
		
		int t1_firstNumber = 2;
		int t2_firstNumber = 3;
		
		CircleOfNumbers solution = new CircleOfNumbers();
		System.out.println("Circle of numbers[" + t1_n + "] "
				+ "--> Radially Across[" + t1_firstNumber + "]: "  
				+ solution.circleOfNumbers(t1_n, t1_firstNumber));
		
		System.out.println("Circle of numbers[" + t2_n + "] "
				+ "--> Radially Across[" + t2_firstNumber + "]: "  
				+ solution.circleOfNumbers(t2_n, t2_firstNumber));
	}

}
