import nodes.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import algorithms.*;

public class Factory {
	public static final int coordinate_limit = 100;

	public static Node[] get_node_list(String node_template, int list_size) throws Exception{
		Node[] nodes_list = new Node[list_size];
		for (int i = 1; i<= list_size; i++){
			nodes_list[i-1] = get_node(node_template, i);
		}
		return nodes_list;
	}
	
	public static Node[] get_node_list(String file_name) throws Exception{
		FileReader file_reader = new FileReader(file_name);
        BufferedReader buffered_reader = new BufferedReader(file_reader);
        String file_line = "";
        int node_id = 0;
        ArrayList<Node> al_node_list = new ArrayList<Node>();
        while((file_line = buffered_reader.readLine()) != null) {
        	node_id ++;
        	String[] s_num_list = (file_line.split(" "));
        	int[] coordinates = new int[s_num_list.length];
        	for (int i = 0; i < s_num_list.length; i++){
        		coordinates[i] = Integer.parseInt(s_num_list[i]);
        	}
        	al_node_list.add(new SpaceNode(node_id, coordinates));
        }   
        buffered_reader.close();   
        file_reader.close();
        return al_node_list.toArray(new Node[0]);
	}
	
	public static Node get_node(String node_name, int node_id){
		
		if (node_name.equals("-space-1")){
			return new SpaceNode(node_id, 1, coordinate_limit);
		} else if (node_name.equals("-space-2")){
			return new SpaceNode(node_id, 2, coordinate_limit);
		} else if (node_name.equals("-space-3")){
			return new SpaceNode(node_id, 3, coordinate_limit);
		} else {
			throw new RuntimeException("Unknown Node name");
		}
	}
	
	public static TSPAlgorithm get_algorithm(String algorithm_name){
		if (algorithm_name.equals("-dummy-")){
			return new DummyAlgorithm();
		} else if (algorithm_name.equals("-greedy-")) {
			return new GreedyAlgorithm();
		} else if (algorithm_name.equals("-brute-force-")) {
			return new BruteForceAlgorithm();
		} else {
			throw new RuntimeException("Unknown Algorithm name");
		}
		
	}

}
