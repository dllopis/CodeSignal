
package company;

public class ComputerNetwork {
	int computerNetwork(int n, int[][] network) {
		network = constructMatrix(network, n); // first construct a full matrix with weights
		//printArray(network);
		return dijkstra(network, 0, n);	// apply algorithm to return shortest path cost
	}
	
    private int minDistance(int dist[], Boolean sptSet[], int V) 
    { 
        // Initialize min value 
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < V; v++) 
            if (sptSet[v] == false && dist[v] <= min) 
            { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
	    
    private int dijkstra(int graph[][], int src, int V) 
    { 
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V]; 
  
        for (int i = 0; i < V; i++) 
        { 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
  
        dist[src] = 0; 
  
        // Find shortest path for all vertices 
        for (int count = 0; count < V-1; count++) 
        { 
            int u = minDistance(dist, sptSet, V); 
            sptSet[u] = true;
            for (int v = 0; v < V; v++) 
                if (!sptSet[v] && graph[u][v]!=0 && 
                        dist[u] != Integer.MAX_VALUE && 
                        dist[u]+graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v]; 
                }
        }
        printSolution(dist,V,V);
        return dist[V-1];
    }
    
	/* input the cost in order of lowest of either (x,y) */
	public int[][] constructMatrix(int[][] a, int n)	{
		int[][] b = new int[n][n];
		for(int x = 0;x<a.length;x++)	{
			if(a[x][0] > a[x][1])
				b[a[x][1]-1][a[x][0]-1] = a[x][2];
			else
				b[a[x][0]-1][a[x][1]-1] = a[x][2];
		}
		return b;
	}
	
    // A utility function to print the constructed distance array 
    private void printSolution(int dist[], int n, int V) 
    { 
        System.out.println("Vertex --> Summed Weights/Distance from Source"); 
        for (int i = 0; i < V; i++) 
            System.out.println(i+" : "+dist[i]); 
    }
	public void printArray(int[][] a)	{
		for(int i = 0;i<a.length;i++)	{
			for(int j=0;j<a[0].length;j++)	{
				System.out.print(a[i][j] + " ");
			}System.out.println("");
		}
	}
	public static void main(String[] args) {
		ComputerNetwork cn = new ComputerNetwork();
		int n = 4;
		int[][] a = {
				{1,4,200},
				{1,2,5},
				{1,3,10},
				{2,3,4},
				{2,4,150},
				{3,4,100}
		};
		System.out.println("Shortest-Path cost: " + cn.computerNetwork(n, a));
		
		n = 5;
		int[][] b = {
				{2,1,2430},
				{3,5,7650},
				{3,1,10},
				{4,1,7217},
				{4,3,8765},
				{4,5,9589}
		};
		System.out.println("Shortest-Path cost: " + cn.computerNetwork(n,b));
	}
}
