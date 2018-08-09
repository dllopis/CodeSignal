package arcadeChallenges;

public class ChessBoardCellColor {
	
	public boolean chessBoardCellColor(String cell1, String cell2) {
		char cell1_Letter = cell1.charAt(0);
		char cell1_Digit = cell1.charAt(1);
		
		char cell2_Letter = cell2.charAt(0);
		char cell2_Digit = cell2.charAt(1);

		
		System.out.println(cell1_Letter + "" + cell1_Digit + "\t" + ("%2: " + cell1_Digit%2));
		System.out.println(cell2_Letter + "" + cell2_Digit + "\t" + ("%2: " + cell2_Digit%2));
		if((cell1_Letter == 'A' || cell1_Letter == 'C' || cell1_Letter == 'E' || cell1_Letter == 'G'))	{
			
			if((cell2_Letter =='A' || cell2_Letter == 'C' || cell2_Letter == 'E' || cell2_Letter == 'G'))	{
				if(cell1_Digit%2 == 1 && cell2_Digit%2 == 1)
					return true;
				else if(cell1_Digit%2 == 0 && cell2_Digit%2 == 0)
					return true;
				else 
					return false;
			}else
				if((cell2_Letter =='B' || cell2_Letter == 'D' || cell2_Letter == 'F' || cell2_Letter == 'H'))	{
					if(cell1_Digit%2 == 1 && cell2_Digit%2 == 0)
						return true;
					else if(cell1_Digit%2==0 & cell2_Digit%2 ==1)
						return true;
					else 
						return false;
				}else
						return false;
		}
		
		if((cell1_Letter == 'B' || cell1_Letter == 'D' || cell1_Letter == 'F' || cell1_Letter == 'H'))	{
			
			if((cell2_Letter =='B' || cell2_Letter == 'D' || cell2_Letter == 'F' || cell2_Letter == 'H'))	{
				if(cell1_Digit%2 == 0 && cell2_Digit%2 == 0)
					return true;
				else if(cell1_Digit%2 == 1 && cell2_Digit%2 == 1)
					return true;
				else 
					return false;
			}else
				if((cell2_Letter =='A' || cell2_Letter == 'C' || cell2_Letter == 'E' || cell2_Letter == 'G'))	{
					if(cell1_Digit%2 == 1 && cell2_Digit%2 == 0)
						return true;
					else if(cell1_Digit%2==0 & cell2_Digit%2 ==1)
						return true;
					else 
						return false;
				}else
						return false;
		}
		return true;
	}

	public static void main(String[] args) {
		/* testcases */
		String t1_cell1 = "A2";
		String t1_cell2 = "B3";
		
		String t2_cell1 = "A1";
		String t2_cell2 = "A1";
		
		String t3_cell1 = "C8";
		String t3_cell2 = "H8";
		
		ChessBoardCellColor solution = new ChessBoardCellColor();
		System.out.println("Cell Color equal?: " + solution.chessBoardCellColor(t1_cell1,t1_cell2));
		System.out.println("Cell Color equal?: " + solution.chessBoardCellColor(t2_cell1,t2_cell2));
		System.out.println("Cell Color equal?: " + solution.chessBoardCellColor(t3_cell1,t3_cell2));
	}

}
