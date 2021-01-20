package leetcode.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

public class Clone_Graph_Deep_Copy {

	public Node createGraph(int a[][]) {

		return new Node();
	}

	public void printGraphDFS(Node node, boolean[] visited) {

		Stack<Node> stack = new Stack<>();

		stack.push(node);

		while (!stack.isEmpty()) {
			Node tempNode = stack.peek();
			stack.pop();
			if (!visited[tempNode.val]) {
				visited[tempNode.val] = true;
				System.out.println(tempNode.val);

			}

			ArrayList<Node> list = (ArrayList) tempNode.neighbors;
			for (int i = 0; i < list.size(); i++) {
				Node flagNode = list.get(i);
				if (!visited[flagNode.val]) {
					stack.push(flagNode);
				}
			}

		}
		for (int i = 0; i < visited.length; i++)
			visited[i] = false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
