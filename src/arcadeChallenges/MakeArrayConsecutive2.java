package arcadeChallenges;

public class MakeArrayConsecutive2 {

	public static int makeArrayConsecutive2(int[] statues) 
	{
		for(int i = 0;i<statues.length-1;i++)
		{
			for(int j = 0;j<statues.length-1;j++)
			{
				if (statues[j] > statues[j+1])
                {
                    int temp = statues[j];
                    statues[j] = statues[j+1];
                    statues[j+1] = temp;
                }
			}
		}
		
		int additionalStatues = 0;
		
		for(int i = 0;i<statues.length-1;i++)
		{
			System.out.println(statues[i+1] + " - " + statues[i]);
			
			if(statues[i+1] - statues[i] != 1)
			{
					additionalStatues += statues[i+1] - statues[i] -1;
				
			}
		}
		
		return additionalStatues;
	}
	public static void main(String[] args) {
		
		int[] statues = {6, 2, 3, 8};
		
		for(int i = 0;i<statues.length-1;i++)
		{
			for(int j = 0;j<statues.length-1;j++)
			{
				if (statues[j] > statues[j+1])
                {
                    int temp = statues[j];
                    statues[j] = statues[j+1];
                    statues[j+1] = temp;
                }
			}
		}
		
		for(int i = 0;i<statues.length;i++)
		{
			System.out.print(statues[i] + " ");
		}
		
		System.out.println("");
		
		int additionalStatues = 0;
		
		for(int i = 0;i<statues.length-1;i++)
		{
			System.out.println(statues[i+1] + " - " + statues[i]);
			
			if(statues[i+1] - statues[i] != 1)
			{
					additionalStatues += statues[i+1] - statues[i] -1;
				
			}
		}
		System.out.println("\n" + additionalStatues);
	}

}
