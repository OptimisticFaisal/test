package ai.lab.exam;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS_Practice {
	private LinkedList<Integer> adjacencyList[];
	private int vertexNumber;
	

	public BFS_Practice(int vertexNumber) {
		super();
		adjacencyList = new LinkedList[vertexNumber];
		this.vertexNumber = vertexNumber;
		for(int i=0;i<vertexNumber;i++){
			adjacencyList[i]=new LinkedList<Integer>();
		}
	}
	public void addEdge(int u, int v){
		adjacencyList[u].add(v);
	}
	void BFS(int start){
		boolean visited[]=new boolean[vertexNumber];
		LinkedList<Integer> queue=new LinkedList<Integer>();
		visited[start]=true;
		queue.add(start);
		while(queue.size()!=0){
			start=queue.pop();
			System.out.print(start+"  ");
			Iterator<Integer> listIterator=adjacencyList[start].listIterator();
			while(listIterator.hasNext()){
				int n=listIterator.next();
				if(!visited[n]){
					visited[n]=true;
					queue.add(n);
				}
			}
		}
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
