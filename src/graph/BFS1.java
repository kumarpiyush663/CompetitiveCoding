package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS1 {

	private int V;
	private ArrayList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	BFS1(int v){
		V = v;
		adj = new ArrayList[V];
		for(int i = 0;i <v;i++) {
			adj[i]= new ArrayList<>();
		}
	}
	
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	void BFS(int s) {
		
		boolean[] visited = new boolean[V];
		Queue<Integer> queue = new LinkedList<>();
		visited[s]=true;
		queue.add(s);
		
		while(!queue.isEmpty()) {
			
			s= queue.peek();
			queue.remove();
			System.out.print(s+" ");
			
			Iterator<Integer> iterator = adj[s].listIterator();
			
			while(iterator.hasNext()) {
				int n = iterator.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BFS1 g = new BFS1(4);
		g.addEdge(0, 1); 
		g.addEdge(0, 2); 
		g.addEdge(1, 2); 
		g.addEdge(2, 0); 
		g.addEdge(2, 3); 
		g.addEdge(3, 3); 
		
		System.out.println("Following is Breadth First Traversal "+ 
				"(starting from vertex 2)"); 

		g.BFS(2); 
	}
}
