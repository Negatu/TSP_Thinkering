
import nodes.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Node[] node_list = Factory.get_node_list("-space-2", 10);
		//Node[] node_list = Factory.get_node_list("one_d_test.txt");
		
		System.out.println("Brute Force Algorithm - ");
		Test_Algorithm brute_force_test = new Test_Algorithm("-brute-force-", node_list);
		brute_force_test.run_test();
		
		System.out.println("Greedy Algorithm - ");
		Test_Algorithm greedy_test = new Test_Algorithm("-greedy-", node_list);
		greedy_test.run_test();
		
		System.out.println("Dummy Algorithm - ");
		Test_Algorithm dummy_test = new Test_Algorithm("-dummy-", node_list);
		dummy_test.run_test();
	}

}
