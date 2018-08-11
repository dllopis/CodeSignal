package arcadeChallenges;

public class ValidTime {

	boolean validTime(String time) {
	    return time.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]");
	}
	public static void main(String[] args) {
		ValidTime solution = new ValidTime();
		System.out.println("Time: " + "13:30");
		System.out.println("isValid Time Format: " + solution.validTime("13:30"));

	}

}
