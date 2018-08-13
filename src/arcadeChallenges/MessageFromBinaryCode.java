package arcadeChallenges;

public class MessageFromBinaryCode {

	public String messageFromBinaryCode(String code) {
		String result = "";
		String temp = "";
		
		for(int i = 1;i <= code.length();i++)	{
			if(i % 8 != 0)	{
				temp += code.charAt(i-1);
			}else {
				temp += code.charAt(i-1);
				int charCode = Integer.parseInt(temp, 2);
				result += (char) charCode;
				temp = "";
			}				
		}
		return result;
	}
	
	public static void main(String[] args) {
		String t1 = "010010000110010101101100011011000110111100100001";
		
		MessageFromBinaryCode solution = new MessageFromBinaryCode();
		System.out.println(solution.messageFromBinaryCode(t1));
	}
}
