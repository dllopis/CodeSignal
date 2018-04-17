package arcadeChallenges;

public class ShapeAreas {

	public static int shapeArea(int n)
	{
		int area = 1;
	    for (int i=1; i<=n; i++) {
	        area += i*4 - 4;
	    }
	    return area;
	}
	public static void main(String[] args) {
		
		int n = 5;
		
		for(int i = 1; i < n; i++)
		{
			System.out.println("Shape area of size " + i + ": " + shapeArea(i));
		}
		
		

	}

}
