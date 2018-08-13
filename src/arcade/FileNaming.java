package arcade;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileNaming {
	
	public String[] fileNaming(String[] names) {
		// LinkedHashMap to preserve order and quick O(1) lookups and insertions
		LinkedHashMap<String,Integer> hm = new LinkedHashMap<String,Integer>();
		
		// this will return the array of newly created filesnames that were formed from duplicates found
		String[] result = null;
		
		/*
		 * Add names to map if not found
		 * if found, update name before placing in map
		 */
		for(int i = 0;i<names.length;i++)	{
			if(hm.containsKey(names[i]))	{
				int count = 1;
				String newName = names[i] + "(" + count + ")";
				
				// make sure to keep updating name if updated name exist in map
				while(hm.containsKey(newName))	{
					count++;
					newName = names[i] + "(" + count + ")";
				}
				hm.put(newName, count);
			}else	{
				// name doesn't exist in map -- add it --
				hm.put(names[i], 0);
			}
		}
		// map is filled with all filenames and return array can be initialized with map size
		result = new String[hm.size()];
		
		// We can now iterate through map and populate our return array.
		int startIndex = 0;
		
		for(Map.Entry<String, Integer> i : hm.entrySet())	{
			result[startIndex] = i.getKey();
			startIndex++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		String[] t1 = {"doc", "doc", "image", "doc(1)", "doc"};
		/*
		 * solution --> "doc", "doc(1)", "image", "doc(1)(1)", "doc(2)"
		 */
		FileNaming solution = new FileNaming();
		
		String result[] = solution.fileNaming(t1);
		System.out.println("Original: " + Arrays.toString(t1) + "\n" + "Solution: " + Arrays.toString(result));
	}

}
