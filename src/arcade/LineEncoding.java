package arcade;

public class LineEncoding {

	String lineEncoding(String s) {
		String newS = "";
		int count = 0;
		char c = s.charAt(0);
		count++;
		
		for(int i = 1;i<s.length();i++)	{
			if(s.charAt(i) == c)
				count++;
			else	{
				if(count == 1)	{
					newS += c;
					count = 0;
					c = s.charAt(i);
					i-=1;
				}else	{
					newS += count;
					newS += c;
					c = s.charAt(i);
					count = 0;
					i-=1;
				}
			}
		}
		if(count == 1)	{
			newS += c;
		}
		if(count > 1)	{
			newS += count;
			newS += c;
		}
		return newS;
	}
	
	public static void main(String[] args) {
		LineEncoding solution = new LineEncoding();
		System.out.println("Encode String: " + "abbbc" + "\t" + "Encode solution: " + solution.lineEncoding("abbbc"));

	}

}
