package arcadeChallenges;

public class EvenDigitsOnly {

	boolean evenDigitsOnly(int n) {
		
		String s = "" + n;
		char[] numbers = s.toCharArray();
		for(int i = 0;i<numbers.length;i++)	{
			if(numbers[i] % 2 != 0)
				return false;
		}
	    return true;
	}
	
	public static void main(String[] args) {
		EvenDigitsOnly solution = new EvenDigitsOnly();
		int n = 2468;
		int x = 3246;
		System.out.println(solution.evenDigitsOnly(n));
		System.out.println(solution.evenDigitsOnly(x));

	}

}
