package company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DataRoute {

	public int maxFlow(int capacity[][], int resource, int server){
        int residualCapacity[][] = new int[capacity.length][capacity[0].length];
        for (int i = 0; i < capacity.length; i++) {
            for (int j = 0; j < capacity[0].length; j++) {
                residualCapacity[i][j] = capacity[i][j];
            }
        }

        Map<Integer,Integer> parent = new HashMap<>();
        List<List<Integer>> augmentedPaths = new ArrayList<>();
        int maxFlow = 0;

        while(BFS(residualCapacity, parent, resource, server)){
            List<Integer> augmentedPath = new ArrayList<>();
            int flow = Integer.MAX_VALUE;
            int v = server;
            
            while(v != resource){
                augmentedPath.add(v);
                int u = parent.get(v);
                if (flow > residualCapacity[u][v]) {
                    flow = residualCapacity[u][v];
                }
                v = u;
            }
            augmentedPath.add(resource);
            Collections.reverse(augmentedPath);
            augmentedPaths.add(augmentedPath);

            maxFlow += flow;
            v = server;
            while(v != resource){
                int u = parent.get(v);
                residualCapacity[u][v] -= flow;
                residualCapacity[v][u] += flow;
                v = u;
            }
        }
        printAugmentedPaths(augmentedPaths);
        return maxFlow;
    }

    private void printAugmentedPaths(List<List<Integer>> augmentedPaths) {
        System.out.println("Augmented paths");
        augmentedPaths.forEach(path -> {
            path.forEach(i -> System.out.print(i + " "));
            System.out.println();
        });
    }

    private boolean BFS(int[][] residualCapacity, Map<Integer,Integer> parent, int resource, int server){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(resource);
        visited.add(resource);
        boolean foundAugmentedPath = false;
        
        while(!queue.isEmpty()){
            int u = queue.poll();
            
            for(int v = 0; v < residualCapacity.length; v++){
                if(!visited.contains(v) &&  residualCapacity[u][v] > 0){
                    parent.put(v, u);
                    visited.add(v);
                    queue.add(v);
                    if ( v == server) {
                        foundAugmentedPath = true;
                        break;
                    }
                }
            }
        }
        return foundAugmentedPath;
    }
	
    public static void main(String[] args) {
		
    	int[][] network = {
			 {0,2,4,8,0,0}, 
			 {0,0,0,9,0,0}, 
			 {0,0,0,0,0,10}, 
			 {0,0,6,0,0,10}, 
			 {10,10,0,0,0,0}, 
			 {0,0,0,0,0,0}
 		};
 		DataRoute t = new DataRoute();
 		System.out.println(t.maxFlow(network, 4, 5));
	}
}
