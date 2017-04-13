package ai.lab.exam;

import java.util.Comparator;

public class CostComparator implements Comparator<Node> {

	@Override
	public int compare(Node x, Node y) {
		if(x.pathCost<y.pathCost)
			return -1;
		if(x.pathCost>y.pathCost)
			return 1;
		return 0;
	}

}
