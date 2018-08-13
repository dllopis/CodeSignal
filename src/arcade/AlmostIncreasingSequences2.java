package arcade;
import java.util.ArrayList;

public class AlmostIncreasingSequences2 {


	static int count = 0;
	static int[] a = {1, 2, 3, 4, 3, 6};
	static int[] b = {1, 3, 2, 1};
	static int[] c = {1, 2, 1, 2};
	
	public static boolean checkIncreasing(ArrayList<Integer> numX)
	{	
		int j = 1;
        
		for(int i = 0;i<numX.size()-1;i++)
		{	
			if(numX.get(i) >= numX.get(j))
			{
					return false;
			}
			
			j++;
			
		}
	return true;
	}

	
	static boolean almostIncreasingSequence(int[] sequence) 
	{
		int j = 1;
		for(int i = 0;i<sequence.length;i++)
		{
			
			ArrayList<Integer> array = new ArrayList<Integer>(sequence.length);
			for(int l = 0;l < sequence.length;l++)
			{
				array.add(sequence[l]);
			}
			
			int temp;
			if(sequence[i] >= sequence[j])
			{
				System.out.println("i: " + sequence[i] + "\t" + "j: " + sequence[j]);
                temp = array.get(i);
				array.remove(i);
				
				for(int k = 0;k<array.size();k++)
				{
					System.out.print(array.get(k) + " ");
				}
				
				System.out.println("");
				
				if(checkIncreasing(array) == false)
				{
					
					array.add(i,temp);
					array.remove(j);
					
					for(int k = 0;k<array.size();k++)
					{
						System.out.print(array.get(k) + " ");
					}
				
	                count++;
					if(count == 2) {
						return false;
					}
				}else
				{
					return true;
				}
			}
			
			j++;
			
			if(j == sequence.length)
				break;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		//System.out.println(almostIncreasingSequence(a));
		System.out.println(almostIncreasingSequence(b));
		//System.out.println(almostIncreasingSequence(c));
	}

}
