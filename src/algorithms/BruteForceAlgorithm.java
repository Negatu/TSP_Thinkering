package algorithms;

import nodes.Node;

public class BruteForceAlgorithm implements TSPAlgorithm{
	
	private Node[] best_solution;
	private int solution_weight;

	@Override
	public Node[] get_ordered_list(Node[] problem_set) {
		best_solution = problem_set;
		solution_weight = get_total_weight(best_solution);
		Node[] empty_list = {};
		rCheck(empty_list, problem_set);
		return best_solution;
	}
	
	public void rCheck(Node[] A, Node[] B){
		if (B.length==0){
			int weight = get_total_weight(A);
			if (weight < solution_weight){
				best_solution = A;
				solution_weight = weight;
			}
		} else {
			for (int i = 0; i < B.length; i++){
				Node[] B2 = deleteNode(B, i);
				Node[] A2 = appendNode(A, B[i]);
				rCheck(A2, B2);
			}
		}
	}
	
	private Node[] deleteNode(Node[] list_with_node, int index){
		Node[] list_without_node = new Node[list_with_node.length - 1];
		for (int i = 0; i < index; i++){
			list_without_node[i] = list_with_node[i];
		}
		for (int i=index +1 ; i < list_with_node.length; i++){
			list_without_node[i-1] = list_with_node[i];
		}
		return list_without_node;
	}
	
	private Node[] appendNode(Node[] list, Node n){
		Node[] new_list = new Node[list.length + 1];
		for (int i = 0; i < list.length; i++){
			new_list[i] = list[i];
		}
		new_list[list.length] = n;
		return new_list;
	}
	
	
	private int get_total_weight(Node[] ordered_list){
		int weight = 0;
		for (int i = 1; i < ordered_list.length; i++){
			weight += ordered_list[i-1].get_distance(ordered_list[i]);
		}
		weight += ordered_list[0].get_distance(ordered_list[ordered_list.length-1]);
		return weight;
	}
	

}
