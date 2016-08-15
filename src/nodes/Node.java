package nodes;

public interface Node {
	
	public double get_distance(Node neighbor);
	public int[] get_coordinates();
	public void construct_myself_randomly();
	public int get_id();
	
}
