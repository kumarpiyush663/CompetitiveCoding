/*

You are given equations in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating-point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.

 

Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]



Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]


Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
 

Constraints:

1 <= equations.length <= 20
equations[i].length == 2
1 <= equations[i][0], equations[i][1] <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= queries[i][0], queries[i][1] <= 5
equations[i][0], equations[i][1], queries[i][0], queries[i][1] consist of lower case English letters and digits.


 */


package leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Evaluate_Division {

	 class Node{
	        String dest;
	        double val;
	        
	        public Node( String dest,double val){
	            this.dest = dest;
	            this.val = val;
	        }
	    }
	    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
	        Map<String, List <Node> > graph = createGraph(equations, values);
	        
	        double[] result = new double[queries.size()];
	         for(int i=0;i<queries.size();i++){
	             result[i] = dfs(queries.get(i).get(0),queries.get(i).get(1), new HashSet(),graph);
	         }
	        return result;
	    }
	    
	    public double dfs(String src,String dst, HashSet<String> visited,  Map<String, List <Node> > graph ){
	        if(!graph.containsKey(src) || !graph.containsKey(dst)) return -1.0;
	        
	        if(src.equals(dst)) return 1.0;
	        visited.add(src);
	        for(Node ng : graph.get(src)){
	            if(!visited.contains(ng.dest)){
	                double value = dfs(ng.dest, dst, visited,graph);
	                if(value!=-1.0) return value* ng.val;
	            }
	        }
	        return -1.0;
	    }
	    public Map<String, List <Node> > createGraph(List<List<String>> equations, double[] values){
	        Map<String, List <Node> > g = new HashMap();
	        
	        for(int i=0;i<values.length;i++){
	            String src = equations.get(i).get(0);
	            String dst = equations.get(i).get(1);
	            
	            g.putIfAbsent(src , new ArrayList());
	            g.putIfAbsent(dst , new ArrayList());
	            
	            g.get(src).add(new Node(dst,values[i]));
	             g.get(dst).add(new Node(src,1/values[i]));
	        }
	        
	        return g;
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
