package arcade;

public class FirstDigit {

	char firstDigit(String inputString) {
	    for(int i = 0;i<inputString.length();i++) {
	        if(Character.isDigit(inputString.charAt(i)))
	            return inputString.charAt(i);
	    }
		return 0;
	}

	
	public static void main(String[] args) {
		String testcase = "var_1__Int";
		
		FirstDigit solution = new FirstDigit();
		System.out.println(testcase + " -- First Digit from the left: " + solution.firstDigit(testcase));
		

	}

}
