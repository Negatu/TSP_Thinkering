package algorithms;

import nodes.Node;

public class DummyAlgorithm implements TSPAlgorithm{

	@Override
	public Node[] get_ordered_list(Node[] problem_set) {
		return problem_set;
	}

}
