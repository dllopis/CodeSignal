package arcadeChallenges;
import java.util.Arrays;
import java.util.TreeMap;

public class IsBeautifulString {

	boolean isBeautifulString(String inputString) {
		char[] c = inputString.toCharArray();
		Arrays.sort(c);
		System.out.println(Arrays.toString(c));
		
	
		char iter = 'a';
		int count = 0;
		int previousCount = -1;
		
		if(c[0] != 'a')
			return false;
		
		TreeMap<Character,Integer> tm = new TreeMap<Character,Integer>();
		
		for(int i = 0;i<c.length;i++)	{
			if(c[i] == iter)
				count++;
			else	{
				if(previousCount != -1)
					if(count > previousCount)
						return false;
				
					tm.put(c[i-1], count);
					previousCount = count;
					count = 0;
					iter++;
				if(c[i] != iter)
					return false;
				i-=1;
			}
		}
		if(count > 0)	{
			if(previousCount != -1)
				if(count > previousCount)
					return false;
		
			tm.put(c[c.length-1], count);
			count = 0;
		}
			System.out.println("Not needed for challenge, but nice to see mapping when boolean returns true");
			System.out.println("Show Mapping and occurences of each character: " + tm.entrySet());
		return true;
	}
	
	public static void main(String[] args) {
		IsBeautifulString solution = new IsBeautifulString();
		String t1 = "bbbaacdafe";
		String t2 = "abcdefghijklmnopqrstuvwxyz";
		String t3 = "aabbb";
		System.out.println("isBeautiful?: " + solution.isBeautifulString(t1));

	}

}
