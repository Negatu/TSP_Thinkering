
import nodes.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Node[] node_list = Factory.get_node_list("-space-", 10);

		Test_Algorithm dummy_test = new Test_Algorithm("-dummy-", node_list);
		dummy_test.run_test();
		
		Test_Algorithm greedy_test = new Test_Algorithm("-greedy-", node_list);
		greedy_test.run_test();
	}

}
