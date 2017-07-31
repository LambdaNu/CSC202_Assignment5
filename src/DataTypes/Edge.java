package DataTypes;

import SpecializedObjects.Restaurant;

public class Edge implements Comparable{
	//Variables
	private double weight; 
	private GraphNode destination; 
	private GraphNode source; 
	private String id; 
	//Constructor
	public Edge(){};
	public Edge(double weight, GraphNode destination){
		this.weight = weight; 
		this.destination = destination; 
	}
	public Edge(double weight, GraphNode destination, GraphNode source, String id){
		this.weight = weight; 
		this.destination = destination; 
		this.source = source; 
		this.id = id; 
	} 
	public Edge(double weight, GraphNode destination, GraphNode source){//, String id){
		this.weight = weight; 
		this.destination = destination; 
		this.source = source; 
		//this.id = id; 
	}
	/**
	 * 
	 * @param weight distance of the objects
	 * @param destination the destination for the object
	 * @param source the starting point, often passed as THIS
	 * @param reciprocal enforcing a "two-way street". Each will have the other as an edge.
	 */
	public Edge(double weight, GraphNode destination, GraphNode source, boolean reciprocal){//, String id){
		if(reciprocal == false){
			this.weight = weight; 
			this.destination = destination; 
			this.source = source; 
		}else{
			this.weight = weight; 
			this.destination = destination; 
			this.source = source; 
			destination.addEdge(weight, source);
		}
		//this.id = id; 
	}
	//SetGet
	public double getWeight() {return weight;}
	public void setWeight(double weight) {this.weight = weight;}
	public GraphNode getDestination() {return destination;}
	public void setDestination(GraphNode destination) {this.destination = destination;}
	public GraphNode getSource() {return source;}
	public void setSource(GraphNode source) {this.source = source;}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	} 
	
	
	
	public String toString(){
		String returnval = "Distance: " + getWeight() + ", Destination: " + getDestination().getData().toString() + ", Source: " + getSource().getData().toString() + ", ID: " + getId() + "]" ;// + getDestination().toString();
		return returnval;
	}
	@Override
	public int compareTo(Object o) {
		Integer compareint = 0; 
		if(o.getClass() == this.getClass()){
			Double total = this.getWeight() - ((Edge) o).getWeight();		
			compareint = (total).intValue();
		}else if(o.getClass().toString() == "Restaurant"){
			GraphNode<Restaurant> g = new GraphNode<Restaurant>();
			Double total = g.getData().compareGeoLocation((Restaurant) o);
			compareint = (total).intValue();
		}
		
		return compareint;
	}
}
