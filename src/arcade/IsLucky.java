package arcade;
import java.util.LinkedList;

public class IsLucky {

	static boolean isLucky(int n) {
		
		
		int digits = 0;
		int sumFirstHalf = 0;
		int sumSecondHalf = 0;
		int sum = 0;
		int breakPoint = 0;

		LinkedList<Integer> stack = new LinkedList<Integer>();
		
		while (n > 0) {
		    stack.push( n % 10 );
		    n = n / 10;
		    digits++;
		}
		
		breakPoint = digits/2;
		
		while (!stack.isEmpty()) {
		    sumFirstHalf += stack.pop();
		    digits--;
		    if(digits == breakPoint)
		    	break;
		}
		
		while (!stack.isEmpty()) {
		    sumSecondHalf += stack.pop();
		}
		
		System.out.println("FirstHalf sum: "  + sumFirstHalf);
		System.out.println("SecondHalf sum: " + sumSecondHalf);
		
		if(sumFirstHalf == sumSecondHalf)
			return true;
		else
			return false;

}

	//only works if digit count is even before we split into two
	
	public static void main(String[] args) {
		
		System.out.println(isLucky(123123));
		System.out.println(isLucky(122334));

	}

}


