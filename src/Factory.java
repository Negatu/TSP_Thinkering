import nodes.*;
import algorithms.*;

public class Factory {
	public static final int coordinate_limit = 100;
	public static final int space_node_dimension = 1;

	public static Node[] get_node_list(String node_template, int list_size) throws Exception{
		Node[] nodes_list = new Node[list_size];
		for (int i = 1; i<= list_size; i++){
			nodes_list[i-1] = get_node(node_template, i);
		}
		return nodes_list;
	}
	
	public static Node get_node(String node_name, int node_id){
		
		if (node_name.equals("-space-")){
			return new SpaceNode(node_id, space_node_dimension, coordinate_limit);
		} else {
			throw new RuntimeException("Unknown Node name");
		}
	}
	
	public static TSPAlgorithm get_algorithm(String algorithm_name){
		if (algorithm_name.equals("-dummy-")){
			return new DummyAlgorithm();
		} else if (algorithm_name.equals("-greedy-")) {
			return new GreedyAlgorithm();
		} else {
			throw new RuntimeException("Unknown Algorithm name");
		}
		
	}

}
