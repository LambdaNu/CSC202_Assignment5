package DataTypes;

import java.util.ArrayList;
import java.util.List;


public class GraphNode<T extends Comparable<T>> {
	private T data; 
	public ArrayList<Edge> edges  = new ArrayList<Edge>(); 
	
	public GraphNode(){}
	public GraphNode(T data){
		this.data = data; 

	}
	
	
	public T getData() {return data;}
	public void setData(T data) {this.data = data;}
	

	public void addEdge(double weight,  GraphNode<T> destination){
		edges.add(new Edge(weight, destination,this));
	}
	/*public void addEdge(double weight,  GraphNode<T> destination, int id){
		edges.add(new Edge(weight, destination,this));
	} */
	public void addEdge(double weight,  GraphNode<T> destination, boolean reciprocal){
		edges.add(new Edge(weight, destination,this,reciprocal));
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addEdge(double weight, T destination){
		GraphNode newNode = new GraphNode(destination);
		edges.add(new Edge(weight, newNode,this));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addEdge(double weight, T destination, boolean reciprocal){
		GraphNode newNode = new GraphNode(destination);
		edges.add(new Edge(weight, newNode,this,reciprocal));
	}
	
	
	/*@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addEdge(double weight, T destination,int id){
		GraphNode newNode = new GraphNode(destination);
		edges.add(new Edge(weight, newNode,this));
		//edges.add(new Edge(weight, newNode,this,Integer.toString(id)));
	} */
	public GraphNode getDestinationEdge(int i) throws ADTExceptions{
		if(i > this.getEdges().size()){
			throw new ADTExceptions("Out of Bounds.");
		}
		GraphNode destinat = edges.get(i).getDestination();
		return destinat; 
	}
	
	
	public ArrayList<Edge> getEdges(){
		return edges; 
	}
	
		
	public String toString(){
		String returnval = "" + this.getData();
		return returnval; 	}
	
	public String edgesToString(){
		String header = this.getData().toString() + ": [Destination, Distance] \n ----------------- \n";
		String returnval = "";
		if(edges.size() == 0){
			//String header = this.getData().toString() + ": \t Distance  \t Destination \n ----------------------------------- \n";
			return header; 
			//return returnval; 
		}else{
			
	
		for(int i = 0; i < edges.size(); i++){
			returnval = returnval  + edges.get(i).toString() + "\n";
		}

		returnval = header + returnval; 
		return returnval; 	}
	}
	
}

