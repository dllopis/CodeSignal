package arcade;

public class GrowingPlant {

	public int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
		int daysToGrow = 0;
		int currentHeight = 0;
		
		System.out.println("Desired Height: " + desiredHeight);
		while(currentHeight < desiredHeight){
			daysToGrow++;
			
			//day time
			currentHeight += upSpeed;
			System.out.println("day[" + daysToGrow +"]: -grows to- " + currentHeight);
			
			//check before nightfall
			if(currentHeight >= desiredHeight)	{
				return daysToGrow;
			}
			
			//night time
			currentHeight -= downSpeed;
			
			System.out.println("night[" + daysToGrow +"]: -shrinks to- " + currentHeight);
			
			//check before sunrise
			if(currentHeight >= desiredHeight)
				break;
			
			System.out.println("");
		}
		return daysToGrow;
	}
	
	public static void main(String[] args) {
		int upSpeed = 100;
		int downSpeed = 10;
		int desiredHeight = 910;
		
		GrowingPlant solution = new GrowingPlant();
		System.out.println(solution.growingPlant(upSpeed, downSpeed, desiredHeight));
	}

}
