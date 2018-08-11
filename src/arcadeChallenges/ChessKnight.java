package arcadeChallenges;

public class ChessKnight {

	private boolean checkUpLeft(String cell)	{
		int dx = cell.charAt(0);
		int dy = cell.charAt(1);
		
		int x = dx;
		int y = dy;
		
		x--;
		y += 2;
		
		System.out.println("Check up left: ");
		System.out.println("(" + (char)dx + "," + (char)dy + ")");
		System.out.println("(" + (char)x + "," + (char)y + ")");
		
		if(!Character.isLetter(x))
			return false;
		if(x >= 97 && x <= 104 && y >= 49 && y <= 56)
			return true;
		else
			System.out.println("out of board! -- false --");
		
		return false;
		
	}
	private boolean checkUpRight(String cell)	{
		int dx = cell.charAt(0);
		int dy = cell.charAt(1);
		
		int x = dx;
		int y = dy;
		
		x++;
		y += 2;
		
		System.out.println("Check up right: ");
		System.out.println("(" + (char)dx + "," + (char)dy + ")");
		System.out.println("(" + (char)x + "," + (char)y + ")");
		
		if(!Character.isLetter(x))
			return false;
		if(x >= 97 && x <= 104 && y >= 49 && y <= 56)
			return true;
		else
			System.out.println("out of board! -- false --");
		return false;
		
	}
	private boolean checkDownLeft(String cell)	{
		int dx = cell.charAt(0);
		int dy = cell.charAt(1);
		
		int x = dx;
		int y = dy;
		
		x--;
		y -= 2;
		
		System.out.println("Check down left: ");
		System.out.println("(" + (char)dx + "," + (char)dy + ")");
		System.out.println("(" + (char)x + "," + (char)y + ")");
		
		if(!Character.isLetter(x))
			return false;
		if(x >= 97 && x <= 104 && y >= 49 && y <= 56)
			return true;
		else
			System.out.println("out of board! -- false --");
		return false;
		
	}
	private boolean checkDownRight(String cell)	{
		int dx = cell.charAt(0);
		int dy = cell.charAt(1);
		
		int x = dx;
		int y = dy;
		
		x++;
		y -= 2;
		
		System.out.println("Check down right: ");
		System.out.println("(" + (char)dx + "," + (char)dy + ")");
		System.out.println("(" + (char)x + "," + (char)y + ")");
		
		if(!Character.isLetter(x))
			return false;
		if(x >= 97 && x <= 104 && y >= 49 && y <= 56)
			return true;
		else
			System.out.println("out of board! -- false --");
		return false;
		
	}
	private boolean checkLeftUp(String cell)	{
		int dx = cell.charAt(0);
		int dy = cell.charAt(1);
		
		int x = dx;
		int y = dy;
		
		x-=2;
		y++;
		
		System.out.println("Check left up: ");
		System.out.println("(" + (char)dx + "," + (char)dy + ")");
		System.out.println("(" + (char)x + "," + (char)y + ")");
		
		if(!Character.isLetter(x))
			return false;
		if(x >= 97 && x <= 104 && y >= 49 && y <= 56)
			return true;
		else
			System.out.println("out of board! -- false --");
		return false;
		
	}
	private boolean checkLeftDown(String cell)	{
		int dx = cell.charAt(0);
		int dy = cell.charAt(1);
		
		int x = dx;
		int y = dy;
		
		x-=2;
		y--;
		
		System.out.println("Check left down: ");
		System.out.println("(" + (char)dx + "," + (char)dy + ")");
		System.out.println("(" + (char)x + "," + (char)y + ")");
		
		if(!Character.isLetter(x))
			return false;
		if(x >= 97 && x <= 104 && y >= 49 && y <= 56)
			return true;
		else
			System.out.println("out of board! -- false --");
		return false;
		
	}
	private boolean checkRightUp(String cell)	{
		int dx = cell.charAt(0);
		int dy = cell.charAt(1);
		
		int x = dx;
		int y = dy;
		
		x+=2;
		y++;
		
		System.out.println("Check right up: ");
		System.out.println("(" + (char)dx + "," + (char)dy + ")");
		System.out.println("(" + (char)x + "," + (char)y + ")");
		
		if(!Character.isLetter(x))
			return false;
		if(x >= 97 && x <= 104 && y >= 49 && y <= 56)
			return true;
		else
			System.out.println("out of board! -- false --");
		return false;
		
	}
	private boolean checkRightDown(String cell)	{
		int dx = cell.charAt(0);
		int dy = cell.charAt(1);
		
		int x = dx;
		int y = dy;
		
		x+=2;
		y--;
		
		System.out.println("Check right down: ");
		System.out.println("(" + (char)dx + "," + (char)dy + ")");
		System.out.println("(" + (char)x + "," + (char)y + ")");
		
		if(!Character.isLetter(x))
			return false;
		if(x >= 97 && x <= 104 && y >= 49 && y <= 56)
			return true;
		else
			System.out.println("out of board! -- false --");
		return false;
		
	}
	int chessKnight(String cell) {
		int possibleMoves = 0;
		
		if(checkUpLeft(cell))
			possibleMoves++;
		if(checkUpRight(cell))
			possibleMoves++;
		if(checkDownLeft(cell))
			possibleMoves++;
		if(checkDownRight(cell))
			possibleMoves++;
		if(checkLeftUp(cell))
			possibleMoves++;
		if(checkLeftDown(cell))
			possibleMoves++;
		if(checkRightUp(cell))
			possibleMoves++;
		if(checkRightDown(cell))
			possibleMoves++;
		
		return possibleMoves;

	}
	
	public static void main(String[] args) {
		ChessKnight solution = new ChessKnight();
		System.out.println("Possible Knight moves: " + solution.chessKnight("g6"));

	}

}
