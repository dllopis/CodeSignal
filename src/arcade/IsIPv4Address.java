package arcade;
/* Credit: Akarshit Wal
 * 
 * This is a regex solution found on stack overflow and works well for this challenge.
 * I took the conditional approach over a full regEx solution to complete the challenge.
 * 
 	public static boolean validate(final String ip) {
    
    	String PATTERN = 
    		"^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";

    	return ip.matches(PATTERN);
	}
*/
public class IsIPv4Address {

	String testCase1 = "00000000010.010.010.010";
	String testCase2 = "123424234272.316.254.1";
	String testCase3 = "123.254.255.0";
	String testCase4 = "1a.";
	
	boolean isIPv4Address(String inputString)	{
	
	    String[] values = inputString.split("[.]");
	    
	    if (values.length > 4) {
	        return false;
	    }
	    
	    for (int i = 0;i<values.length;i++) {
	        //number is missing -- means less than 4 exists --
	    	if (values[i].isEmpty()) {
	            return false;
	        }
	        // found a letter -- invalid format --
	        if (!values[i].matches("[0-9]{1,3}")) {
	            return false;
	        }
	       
	        int n = Integer.parseInt(values[i]);
	        // parse string and check for valid condition
	        if (!(n >= 0 && n <= 255)) {
	            return false;
	        }
	    }
	    // everything passed -- IPv4 address format is valid
	    return true;
	}
	
	public static void main(String[] args) {
		IsIPv4Address solution = new IsIPv4Address();
		String testCase = solution.testCase3;
		
		System.out.println("IPv4 adress: " + testCase);
		System.out.println("isValid?: " + solution.isIPv4Address(testCase));

	}

}
