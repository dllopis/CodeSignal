package arcadeChallenges;
import java.util.ArrayList;
import java.util.Collections;

public class SortByHeight {

	static int[] sortByHeight(int[] a) {
		
		// stores integers that will be sorted
		ArrayList<Integer> array = new ArrayList<Integer>(a.length);
		// stores -1 (trees that can't move)
		ArrayList<Integer> savedIndex = new ArrayList<Integer>();
		
		// pass through array and store values to their corresponding list
		for(int i = 0;i<a.length;i++)
		{
			if(a[i] == -1)
			{
				savedIndex.add(i);
			}
			else
				array.add(a[i]);
		}
		
		// array is sorted
		Collections.sort(array);
		
		// now we add our trees back in their original positions
		for(int i = 0;i<savedIndex.size();i++)
		{
			array.add(savedIndex.get(i), -1);
		}
		
		// populate original array with the sorted list
		// and trees in their original positions
		for(int i = 0;i<array.size();i++)
		{
			a[i] = array.get(i);
		}
		
		display(a);
		return a;

	}

	private static void display(int[] array)
	{
		for(int i = 0;i<array.length;i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		
		int[] n = {-1, 150, 190, 170, -1, -1, 160, 180};
		
		sortByHeight(n);

	}

}
