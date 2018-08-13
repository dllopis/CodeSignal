package arcade;

public class VariableName {

	public boolean variableName(String name) {
		if(Character.isDigit(name.charAt(0)) || !Character.isLetter(name.charAt(0)) && name.charAt(0) != '_')
			return false;
		
		for(int i = 1;i<name.length();i++)	{
			char c = name.charAt(i);
			
				if( c == '_' || Character.isLetter(c) || Character.isDigit(c))	{
					continue;
				}else
					return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String x = " variable0";
		String y = "_Aas_23";
		
		VariableName solution = new VariableName();
		System.out.println(x + ": " + solution.variableName(x));
		System.out.println(y + ": " + solution.variableName(y));

	}

}
