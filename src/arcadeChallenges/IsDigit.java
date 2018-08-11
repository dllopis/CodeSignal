package arcadeChallenges;

public class IsDigit {
	
	public boolean isDigit(char symbol) {
		return Character.isDigit(symbol);
	}
	public static void main(String[] args) {
		IsDigit solution = new IsDigit();
		
		char t1 = ' ';
		char t2 = '8';
		
		System.out.println("Character: " + t1);
		System.out.println("isDigit: " + solution.isDigit(t2));

	}

}
