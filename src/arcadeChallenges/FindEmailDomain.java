package arcadeChallenges;

public class FindEmailDomain {

	// challenge assumed that domains ended in @gmail.com
	// just searching for first @ from right to left was enough to pass.
	// in reality, a regular expression would be ideal.
	public String findEmailDomain(String address) {
	    String result = "";
	    
	    for(int i = address.length()-1;i>0;i--)   {
	        if(address.charAt(i) != '@')
	        	result = address.charAt(i) + result;
	        else
	            break;
	    }
	    return result;
	}
	public static void main(String[] args) {
		FindEmailDomain solution = new FindEmailDomain();
		String t1 = "john.doe@gmail.com";
		System.out.println(solution.findEmailDomain(t1));

	}

}
