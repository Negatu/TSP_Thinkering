package algorithms;

import java.util.ArrayList;
import java.util.Arrays;

import nodes.Node;

public class GreedyAlgorithm implements TSPAlgorithm{

	@Override
	public Node[] get_ordered_list(Node[] problem_set) {
		// TODO Auto-generated method stub
		
		ArrayList<Node> unordered_list = new ArrayList<Node>(Arrays.asList(problem_set));
		Node[] ordered_list = new Node[problem_set.length];
		ordered_list[0] = unordered_list.remove(0);
		for (int i = 1; i < problem_set.length; i++){
			int next_node = 0;
			double next_length = ordered_list[i-1].get_distance(unordered_list.get(0));
			for(int j = 1; j < unordered_list.size(); j++){
				double j_length = ordered_list[i-1].get_distance(unordered_list.get(j));
				if (j_length < next_length){
					next_node = j;
					next_length = j_length;
				}
			}
			ordered_list[i] = unordered_list.remove(next_node);
		}
		
		return ordered_list;
	}

}
