package arcadeChallenges;

public class AlternatingSums {

	int[] alternatingSums(int[] a) {
		int[] sums = {0,0};
			
		for(int i = 0;i< a.length;i++)	{
			if(i%2 == 0)	{
				sums[0] += a[i];
			}
			if(i%2 == 1)	{
				sums[1] += a[i];
			}
		}
	return sums;
	}
	
	public void displaySums(int[] a)	{
		for(int i = 0;i<a.length;i++)	{
			System.out.println(a[i] + " ");
		}
	}
/*	For a = [50, 60, 60, 45, 70], the output should be
			alternatingSums(a) = [180, 105].
			Guaranteed constraints:
				1 less or equal to a.length less or equal 105,
				45 less or equal to a[i] less or equal to 100.
			*/
			
	public static void main(String[] args) {
		int[] a = {50, 60, 60, 45, 70};
		int[] result = new int[2];
		AlternatingSums solution = new AlternatingSums();
		result = solution.alternatingSums(a);
		solution.displaySums(result);

	}

}
