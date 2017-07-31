package AlternateGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DijkstraNode {
	   private String name;

	    private LinkedList<DijkstraNode> shortestPath = new LinkedList<>();

	    private Integer distance = Integer.MAX_VALUE;

	    private Map<DijkstraNode, Integer> adjacentDijiskstraNodes = new HashMap<>();

	    public DijkstraNode(String name) {
	        this.name = name;
	    }

	    public void addDestination(DijkstraNode destination, int distance) {
	        adjacentDijiskstraNodes.put(destination, distance);
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Map<DijkstraNode, Integer> getAdjacentDijiskstraNodes() {
	        return adjacentDijiskstraNodes;
	    }

	    public void setAdjacentDijiskstraNodes(Map<DijkstraNode, Integer> adjacentDijiskstraNodes) {
	        this.adjacentDijiskstraNodes = adjacentDijiskstraNodes;
	    }

	    public Integer getDistance() {
	        return distance;
	    }

	    public void setDistance(Integer distance) {
	        this.distance = distance;
	    }

	    public List<DijkstraNode> getShortestPath() {
	        return shortestPath;
	    }

	    public void setShortestPath(LinkedList<DijkstraNode> shortestPath) {
	        this.shortestPath = shortestPath;
	    }
}
