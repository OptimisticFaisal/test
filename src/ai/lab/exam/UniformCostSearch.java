package ai.lab.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class UniformCostSearch {
	private LinkedList<Node> adjacencyList[];
	private int vertexNumber;
	private int start;
	private int goal;
	private int parent[];
	ArrayList<Integer>path=new ArrayList<>();

	public UniformCostSearch(int vertexNumber, int start, int goal) {
		super();
		this.vertexNumber = vertexNumber;
		this.start = start;
		this.goal = goal;
		path=new ArrayList<>();
		parent=new int[vertexNumber];
		adjacencyList = new LinkedList[vertexNumber];
		for (int i = 0; i < vertexNumber; i++) {

			adjacencyList[i] = new LinkedList();
			parent[i]=1000;

		}
		System.out.println("Source: "+start);
		System.out.println("Goal: "+goal);
	}

	void addEdge(int u, int v, int pathCost) {
		Node node = new Node(v, pathCost);
		adjacencyList[u].add(node);
	}

	void uniformCost() {
		boolean visited[] = new boolean[vertexNumber];
		PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(new CostComparator());
		visited[start] = true;
		parent[start]=10000;
		priorityQueue.add(new Node(start, 0));
		System.out.println("Visited nodes");
		while (priorityQueue.size() != 0) {
			Node node = priorityQueue.poll();
			System.out.print(node.vertex + "  ");
			if (node.vertex == goal) {
				System.out.println();
				System.out.println("Path Cost: "+node.pathCost);
				System.out.println("Path in reverse order");
				path.add(goal);
				System.out.print(goal+"  ");
				int parent_temp=goal;
				for(int p:parent){
					if(p==start){
					break;
					}
					//System.out.println();
					System.out.print(parent[parent_temp]+"  ");
					path.add(parent[parent_temp]);
					parent_temp=parent[parent_temp];
					
				}
				
				printPath();
				return;
			}
			Iterator<Node> iterator = adjacencyList[node.vertex].listIterator();
			while (iterator.hasNext()) {
				Node temp = iterator.next();
				if (!visited[temp.vertex]) {
					parent[temp.vertex]=node.vertex;
					priorityQueue.add(new Node(temp.vertex, temp.pathCost + node.pathCost));
				} else {

					for (Node queue : priorityQueue) {
						if (queue.vertex == temp.vertex) {
							if (queue.pathCost > temp.pathCost + node.pathCost) {
								queue.pathCost = temp.pathCost + node.pathCost;
								parent[queue.vertex]=node.vertex;
							}

						}
					}
				}
			}

		}

	}

	private void printPath() {
		// TODO Auto-generated method stub
		Collections.reverse(path);
		System.out.println();
		System.out.println("Path from souce to destination");
		System.out.println(path);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*UniformCostSearch ucs = new UniformCostSearch(5, 0, 4);
		ucs.addEdge(0, 1, 99);
		ucs.addEdge(0, 2, 80);
		ucs.addEdge(1, 4, 211);
		ucs.addEdge(2, 3, 97);
		ucs.addEdge(3, 4, 101);*/
		UniformCostSearch ucs=new UniformCostSearch(7, 0,6);
		ucs.addEdge(0, 1, 5);
		ucs.addEdge(0, 3, 3);
		ucs.addEdge(1, 2, 1);
		ucs.addEdge(2, 4, 6);
		ucs.addEdge(3, 5, 2);
		ucs.addEdge(3, 4, 2);
		ucs.addEdge(4, 1, 4);
		ucs.addEdge(5, 6, 3);
		ucs.addEdge(6, 4, 4);
		ucs.uniformCost();
		System.out.println("Hello");

	}

}
