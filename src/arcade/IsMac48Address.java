package arcade;

public class IsMac48Address {

	public boolean isMAC48Address(String inputString) {
		return inputString.matches(("^([0-9a-fA-F]{2}[-]){5}([0-9a-fA-F]{2})$"));
		}
	
	public static void main(String[] args) {
		String t1 = "00-1B-63-84-45-E6";
		String t2 = "Z1-1B-63-84-45-E6";
		IsMac48Address solution = new IsMac48Address();
		System.out.println("isMac48Address [" + t1 + "]: " + solution.isMAC48Address(t1));
		System.out.println("isMac48Address [" + t2 + "]: " + solution.isMAC48Address(t2));

	}

}
