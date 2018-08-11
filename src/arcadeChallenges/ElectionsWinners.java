package arcadeChallenges;

public class ElectionsWinners {

	int electionsWinners(int[] votes, int k) {
		int count = 0;
		
		for(int i = 0;i<votes.length;i++)	{
			int candidateVotes = votes[i] + k;
			System.out.println("Votes for candidate " + (i+1) + ": " + candidateVotes);
			
			for(int j = 0;j<votes.length;j++)	{
				if(j == i)
					continue;
				else if(i == votes.length-1)	{
					System.out.println("i: " + i + "\t" + "Votes: " + votes[j]);
					if(candidateVotes <= votes[j])
						break;
					if(j == votes.length-2)	{
						System.out.println("Election Winner Found");
						count++;
					}
				}else	{
					System.out.println(votes[j]);
					if(candidateVotes <= votes[j])
						break;
					if(j == votes.length-1)	{
						System.out.println("Election Winner Found");
						count++;
					}
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		ElectionsWinners solution = new ElectionsWinners();
		
		int[] t1 = {2, 3, 5, 2};
		int[] t2 = {1, 3, 3, 1, 1};
		int[] t3 = {1, 1, 1, 1};
		System.out.println("Election Winners: " + solution.electionsWinners(t3, 1));

	}

}
