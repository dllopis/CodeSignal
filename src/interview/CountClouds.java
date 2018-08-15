package interview;

/*#Given a 2D grid skyMap composed of '1's (clouds) and '0's (clear sky), count the number of clouds. 
#A cloud is surrounded by clear sky, and is formed by connecting adjacent clouds horizontally or vertically. 
#You can assume that all four edges of the skyMap are surrounded by clear sky.
*/

/*
 * Found this from #1 solution from helfper
 * Avoids O(n) space complexity
 * 
 * void dfs(char[][] skyMap, int r, int c) {
    if (skyMap[r][c] != '1') return;
    skyMap[r][c] = '2';
    if (r > 0) dfs(skyMap, r - 1, c);
    if (r < skyMap.length - 1) dfs(skyMap, r + 1, c);
    if (c > 0) dfs(skyMap, r, c - 1);
    if (c < skyMap[r].length - 1) dfs(skyMap, r, c + 1);
}
 */

public class CountClouds	{
	
	public int countClouds(char[][] skyMap) {
		
		if( skyMap.length == 0)	{
			return 0;
		}
		int cloudCount = 0;
		boolean[][] visited = new boolean[skyMap.length][skyMap[0].length];
		
		for(int i = 0;i<skyMap.length;i++)	{
			for(int j = 0;j<skyMap[i].length;j++)	{
				if(!visited[i][j] && skyMap[i][j] == '1')	{
					DFS(i,j,visited,skyMap);
					System.out.println("Cloud formed\n");
					cloudCount += 1;
				}
			}
		}
		display(visited,"VISITED POSITION MAP:");
		return cloudCount;
	}
	
	public void DFS(int i,int j,boolean[][] visited,char[][]skyMap)	{
		visited[i][j] = true;
		System.out.println("Start merging clouds at: (" + i + "," + j + ")");
		// left
				if(j > 0 && visited[i][j-1] == false && skyMap[i][j-1] == '1')	{
					System.out.print("'1' GO LEFT : (" + i + "," + j + ")\t");
					DFS(i,j-1,visited,skyMap);	
				}
					
		//right
				if(j < skyMap[i].length-1 && visited[i][j+1] == false && skyMap[i][j+1] == '1')	{
					System.out.print("'1' GO RIGHT: (" + i + "," + j + ")\t");
					DFS(i,j+1,visited,skyMap);
				}
					
		// down
		if(i < skyMap.length-1 && visited[i+1][j] == false && skyMap[i+1][j] == '1')	{
			System.out.print("'1' GO DOWN : (" + i + "," + j + ")\t");
			DFS(i+1,j,visited,skyMap);
		}
			
		// up
		if(i > 0 && visited[i-1][j] == false && skyMap[i-1][j] == '1')	{
			System.out.print("'1' GO UP : (" + i + "," + j + ")\t");
			DFS(i-1,j,visited,skyMap);	
		}
		System.out.println("NO MORE 1's(clouds) or visited is TRUE in all directions of: (" + i + "," + j + ")\n");
	}
	
	public void display(boolean[][] skyMap, String s)	{
		System.out.println(s);
		for(int i = 0;i<skyMap.length;i++)	{
			for(int j = 0;j<skyMap[0].length;j++)	{
				System.out.print(skyMap[i][j] + " ");
			}System.out.println("");
		}
	}
	
	public void display(char[][] skyMap,String s)	{
		System.out.println(s);
		for(int i = 0;i<skyMap.length;i++)	{
			for(int j = 0;j<skyMap[0].length;j++)	{
				System.out.print(skyMap[i][j] + " ");
			}System.out.println("");
		}
	}

	public static void main(String args[])	{
		
		char[][] skyMap = {
					{'0', '1', '1', '0', '1'},
					{'0', '1', '1', '1', '1'},
					{'0', '0', '0', '0', '1'},
					{'1', '0', '0', '1', '1'}
				};
		CountClouds cloudsApp = new CountClouds();
		cloudsApp.display(skyMap,"SKY MAP: ");
		System.out.println("\nCloud(s) in sky: " + cloudsApp.countClouds(skyMap));
	}
}
