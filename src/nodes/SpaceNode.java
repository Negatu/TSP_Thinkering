package nodes;

import java.util.Random;

public class SpaceNode implements Node{
	
	private int my_id;
	private int my_dimension;
	private int my_coordinate_limit;
	private int[]  my_coordinates;
	
	public SpaceNode(int id, int dimension, int coordinate_limit){
		my_id = id;
		my_dimension = dimension;
		my_coordinate_limit = coordinate_limit;
		construct_myself_randomly();
	}

	@Override
	public double get_distance(Node neighbor) {
		int distance = 0;
		int[] neighbor_coordinates = neighbor.get_coordinates();
		for (int i = 0; i < my_coordinates.length; i++){
			int distance_i = Math.abs(my_coordinates[i] - neighbor_coordinates[i]);
			distance += Math.pow(distance_i, 2);
		}
		return distance;
	}

	@Override
	public void construct_myself_randomly() {
		Random myGen = new Random();
		my_coordinates = new int[my_dimension];
		for (int i = 0; i < my_dimension; i++){
			my_coordinates[i] = myGen.nextInt(my_coordinate_limit);
		}
		
	}

	@Override
	public int get_id() {
		return my_id;
	}

	@Override
	public int[] get_coordinates() {
		return my_coordinates;
	}


}
