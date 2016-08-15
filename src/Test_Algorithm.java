import nodes.*;
import algorithms.*;

public class Test_Algorithm {
	private String algorithm_template;
	private int node_list_size;
	private Node[] node_list;
	
	public Test_Algorithm(String name_algorithm, String node_template, int set_size) throws Exception{
		algorithm_template = name_algorithm;
		node_list_size = set_size;
		node_list = Factory.get_node_list(node_template, node_list_size);
	}
	
	public Test_Algorithm(String name_algorithm, Node[] problem_set) throws Exception{
		algorithm_template = name_algorithm;
		node_list_size = problem_set.length;
		node_list = problem_set;
	}
	
	public void run_test() throws Exception{
		double start_time = System.currentTimeMillis();
		
		TSPAlgorithm myAlgorithm = Factory.get_algorithm(algorithm_template);
		Node[] ordered_node_list = myAlgorithm.get_ordered_list(node_list);
		
		double total_edge_weight = 0;
		String ordered_list = ordered_node_list[0].get_id() + ", ";
		for (int i = 1; i < ordered_node_list.length; i++){
			ordered_list += ordered_node_list[i].get_id() + ", ";
			total_edge_weight += ordered_node_list[i].get_distance(ordered_node_list[i-1]);
		}
		System.out.println(ordered_list);
		System.out.println("Total Weight : " + total_edge_weight);
		
		// Time took for test
		double end_time = System.currentTimeMillis();
		double computation_duration = (end_time - start_time) / 1000;
		System.out.println("Took : "+ computation_duration);
	}

}
