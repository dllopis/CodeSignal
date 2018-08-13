package interview;

/*#Given a 2D grid skyMap composed of '1's (clouds) and '0's (clear sky), count the number of clouds. 
#A cloud is surrounded by clear sky, and is formed by connecting adjacent clouds horizontally or vertically. 
#You can assume that all four edges of the skyMap are surrounded by clear sky.
*/

public class CountClouds	{
	
	public int countClouds(char[][] skyMap) {
		
		if( skyMap.length == 0)	{
			return 0;
		}
		int cloudCount = 0;
		boolean[][] visited = new boolean[skyMap.length][skyMap[0].length];
		
		for(int i = 0;i<skyMap.length;i++)	{
			for(int j = 0;j<skyMap[0].length;j++)	{
				if(!visited[i][j] && skyMap[i][j] == 1)	{
					DFS(i,j,visited,skyMap);
					cloudCount += 1;
				}
			}
		}
		display(visited);
		return cloudCount;
	}
	
	public void DFS(int i,int j,boolean[][] visited,char[][]skyMap)	{
		
		visited[i][j] = true;
	}
	
	public void display(boolean[][] skyMap)	{
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
		System.out.println(cloudsApp.countClouds(skyMap));
	}
}
