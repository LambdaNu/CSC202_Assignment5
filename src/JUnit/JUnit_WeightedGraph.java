package JUnit;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import DataTypes.ADTExceptions;
import DataTypes.GraphNode;
import SpecializedObjects.GeoLocation;
import SpecializedObjects.Restaurant;

public class JUnit_WeightedGraph {
	
	@Test
	public void test() throws ADTExceptions {
		
		Restaurant rest1 = new Restaurant(); 
			GeoLocation GL1 = new GeoLocation(38,77);
			rest1.setLocation(GL1);
			rest1.setRestaurantName("Luigi");
			GraphNode<Restaurant> node1 = new GraphNode<Restaurant>(rest1); 
		Restaurant rest2 = new Restaurant(); 
			rest2.setLocation(38, -79);
			rest2.setRestaurantName("Mario");
			GraphNode<Restaurant> node2 = new GraphNode<Restaurant>(rest2); 
		Restaurant rest3 = new Restaurant();
			rest3.setLocation(33,-80);
			rest3.setRestaurantName("Wario");
			GraphNode<Restaurant> node3 = new GraphNode<Restaurant>(rest3); 
		Restaurant rest4 = new Restaurant();
			rest4.setLocation(40,-90);
			rest4.setRestaurantName("Peach");
			GraphNode<Restaurant> node4 = new GraphNode<Restaurant>(rest4); 
		
			node1.addEdge(rest1.compareGeoLocation(rest2), node2,true);
			node1.addEdge(rest1.compareGeoLocation(rest3), node3, false); //this is a "one-way street", meaning the recipient does not get the edge.
			node1.addEdge(rest1.compareGeoLocation(rest4), node4,true);
			node2.addEdge(rest2.compareGeoLocation(rest3), node3,true);
			node3.addEdge(rest3.compareGeoLocation(rest4), node4, true);
			
			assertEquals(node3.getEdges().size(),2);
			System.out.println(node3.getDestinationEdge(1).getData()); //Should be "Peach" as a restaurant.
		

	}

}
