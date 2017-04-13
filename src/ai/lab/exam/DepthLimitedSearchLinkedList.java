package ai.lab.exam;

import java.util.Iterator;
import java.util.LinkedList;

public class DepthLimitedSearchLinkedList {
	

	private int V; // No. of vertices
	private int max_limit=3;

	// Array of lists for Adjacency List Representation
	private LinkedList<Integer> adj[];

	// Constructor
	DepthLimitedSearchLinkedList(int v)
	{
		V = v;
		adj = new LinkedList[v];
		for (int i=0; i<v; ++i)
			adj[i] = new LinkedList();
	}
	void addEdge(int v, int w)
	{
		adj[v].add(w); // Add w to v's list.
	}

	// A function used by DFS
	void DFSUtil(int v,boolean visited[],int limit)
	{
		if (limit>max_limit)
			return;
		// Mark the current node as visited and print it
		visited[v] = true;
		++limit;
		System.out.print(v+" ");

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext())
		{
			int n = i.next();
			if (!visited[n])
				DFSUtil(n, visited,limit);
		}
	}
	void DFS(int v,int limit)
	{
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[V];

		// Call the recursive helper function to print DFS traversal
		DFSUtil(v, visited,limit);
	}
	public static void main(String args[])
	{
		DepthLimitedSearchLinkedList g = new DepthLimitedSearchLinkedList(7);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.addEdge(1, 4);
		g.addEdge(4, 5);
		g.addEdge(3, 1);
		g.addEdge(3, 6);
		g.addEdge(3, 5);
		
		System.out.println("Following is Depth First Traversal "+
						"(starting from vertex 2)");

		g.DFS(2,0);
	}

}
