package company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class ServerFarm {

	public int[][] serverFarm(int[] jobs, int servers) {
		if(servers == 0)
			return new int[0][0];
		
		ArrayList<ArrayList<Integer>> farmServers = new ArrayList<>();
		HashMap<Integer,Integer> map = new HashMap<>();
		
		initializeMap(map,jobs);
		initializeServers(farmServers,servers);
		System.out.println(map);

		for(int i = 0;i<jobs.length;i++)	{
			int maxJob = findMax(map);	// Find job with longest time
			int minServer = findMin(farmServers,jobs);	// Find server with lowest time
			farmServers.get(minServer).add(maxJob);	// Add longest job in server with the lowest time
		}
		return initializeJaggedArray(farmServers);	// 2D array with jobs farmed
	}

	private void initializeMap(HashMap<Integer,Integer> map, int[] jobs)	{
		for(int i = 0;i<jobs.length;i++)	{map.put(i, jobs[i]);}
	}
	private void initializeServers(ArrayList<ArrayList<Integer>> a, int servers)	{
		for(int i=0;i<servers;i++)	{a.add(new ArrayList<Integer>());}
	}
	private int findMax(HashMap<Integer,Integer> jobs)	{
		int max = Integer.MIN_VALUE;
		for(Entry<Integer, Integer> x : jobs.entrySet())	{
			if(max == Integer.MIN_VALUE)
				max = x.getKey();
			if(x.getValue() > jobs.get(max))	{
				max = x.getKey();
			}
		}
		jobs.remove(max);
		return max;
	}	
	private int findMin(ArrayList<ArrayList<Integer>> list, int[] jobs)	{
		int minIndex = 0;
		int minValue = Integer.MAX_VALUE;
		int sum = 0;
		
		for(int i = 0;i<list.size();i++)	{
			for(int j = 0;j< list.get(i).size();j++)	{
				sum += jobs[list.get(i).get(j)];
			}

			if(sum < minValue)	{
					minValue = sum;
					minIndex = i;
			}	
			sum = 0;
		}
		return minIndex;
	}
	private int[][] initializeJaggedArray(ArrayList<ArrayList<Integer>> a) {
	    int[][] b = new int[a.size()][];
		for(int i = 0;i<a.size();i++)	{
			b[i] = new int[a.get(i).size()];
			for(int j = 0;j < a.get(i).size();j++)	{
				b[i][j] = a.get(i).get(j);
			}
		}
	    return b;
	}
	public static  void displayInfo(int servers, int[] jobs)	{
		System.out.println("Description:\n\tAvailable Farm Servers: " + servers);
		System.out.println("\tJobs to farm: " + Arrays.toString(jobs) + "\n");
	}
	public static void displayArray(int[][] array,String msg)	{
		System.out.println(msg);
		for(int i = 0;i<array.length;i++)	{
			System.out.print("\tServer " + i + " --> ");
			for(int j = 0;j<array[i].length;j++)	{
				System.out.print(array[i][j] + " ");
			}System.out.println("");
		}
	}
	public static void main(String[] args) {
		/*Testcase 1*/
		int servers = 3;
		int[] jobs = {15, 30, 15, 5, 10};
	
		ServerFarm serverFarm = new ServerFarm();
	
		int[][] result = serverFarm.serverFarm(jobs, servers);
		displayInfo(servers,jobs);
		displayArray(result,"Assigned Jobs to Servers:");
	}

}
