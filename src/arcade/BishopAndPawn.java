package arcade;

public class BishopAndPawn {

	boolean bishopAndPawn(String bishop, String pawn) {
		// check if bishop can eat the pawn -- basically if move is valid --
		return Math.abs(bishop.charAt(0)- pawn.charAt(0))==Math.abs(bishop.charAt(1)-pawn.charAt(1));
	}

	
	public static void main(String[] args) {
		BishopAndPawn solution = new BishopAndPawn();
		String t1_Bishop = "a1";
		String t1_Pawn = "c3";
		
		String t2_Bishop = "d4";
		String t2_Pawn = "f5";
		
		System.out.println("Bishop: "+ t1_Bishop.toUpperCase() 
					+ "\tTO\t" + "Pawn: " + t1_Pawn.toUpperCase() 
					+ "\tCAN EAT? ---> " 
					+ solution.bishopAndPawn(t1_Bishop, t1_Pawn));
		
		System.out.println("Bishop: " + t2_Bishop.toUpperCase() 
					+ "\tTO\t" + "Pawn: " + t2_Pawn.toUpperCase() 
					+ "\tCAN EAT? ---> " 
					+ solution.bishopAndPawn(t2_Bishop, t2_Pawn));
	}

}
