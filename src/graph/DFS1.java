package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class DFS1 {
	
	private int V;
	private ArrayList<Integer> adj[];
	
	
	@SuppressWarnings("unchecked")
	DFS1(int v) {
		
		V = v;
		adj = new ArrayList[V];
		
		for(int i = 0; i<V ;i++) {
			adj[i]= new ArrayList<>();			
		}		
	}
	
	void addEdge(int v , int w) {
		adj[v].add(w);
	}
	
	void DFS (int s) {
		boolean visited[] = new boolean[V];
		
		Stack<Integer> stack = new Stack<>();
		stack.push(s);
		visited[s]=true;
		
		while(!stack.isEmpty()) {
			s= stack.pop();
			System.out.print(s+ " ");
			Iterator<Integer> iterator = adj[s].listIterator();
			while(iterator.hasNext()) {
				int n = iterator.next();
				if(!visited[n]) {
					visited[n]=true;
					stack.push(n);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		DFS1 g = new DFS1(4);
		g.addEdge(0, 1); 
		g.addEdge(0, 2); 
		g.addEdge(1, 2); 
		g.addEdge(2, 0); 
		g.addEdge(2, 3); 
		g.addEdge(3, 3); 
		
		System.out.println("Following is Deapth First Traversal "+ 
				"(starting from vertex 2)"); 

		g.DFS(1); 
	}

}
