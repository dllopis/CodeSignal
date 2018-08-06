package arcadeChallenges;

public class AreEquallyStrong {

	boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
		int yourDominant;
		int yourOffHand;
		
		int friendsDominant;
		int friendsOffHand;
		
		/* Assign your dominant and weak hand values */
		if(yourLeft > yourRight)	{
			yourDominant = yourLeft;
			yourOffHand = yourRight;
		}
		else	{
			yourDominant = yourRight;
			yourOffHand = yourLeft;
		}
		/* Assign your friends dominant and weak hand values */
		if(friendsLeft > friendsRight)	{
			friendsDominant = friendsLeft;
			friendsOffHand = friendsRight;
		}
		else	{
			friendsDominant = friendsRight;
			friendsOffHand = friendsLeft;
		}
		
		System.out.println("YourLeft: " + yourLeft + "\n" + "YourRight: " + yourRight + "\n");
		System.out.println("FriendsLeft: " + friendsLeft + "\n" + "FriendsRight: " + friendsRight);
		
		/* Check to see if equally strong */
		if(yourDominant == friendsDominant && yourOffHand == friendsOffHand)
			return true;
		else
			return false;
		
	}
	
	public static void main(String[] args) {
		AreEquallyStrong solution = new AreEquallyStrong();
		int yourLeft = 15;
		int yourRight = 12;
		
		int friendsLeft = 13;
		int friendsRight =6;
		
		System.out.println(solution.areEquallyStrong(yourLeft, yourRight, friendsLeft, friendsRight));

	}

}
