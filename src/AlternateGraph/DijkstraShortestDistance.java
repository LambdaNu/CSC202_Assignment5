package AlternateGraph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class DijkstraShortestDistance {
	 public static DijkstraGraph calculateShortestPathFromSource(DijkstraGraph graph, DijkstraNode source) {

	        source.setDistance(0);

	        Set<DijkstraNode> settledDijkstraNodes = new HashSet<>();
	        Set<DijkstraNode> unsettledDijkstraNodes = new HashSet<>();
	        unsettledDijkstraNodes.add(source);

	        while (unsettledDijkstraNodes.size() != 0) {
	            DijkstraNode currentDijkstraNode = getLowestDistanceDijkstraNode(unsettledDijkstraNodes);
	            unsettledDijkstraNodes.remove(currentDijkstraNode);
	            for (Entry<DijkstraNode, Integer> adjacencyPair : currentDijkstraNode.getAdjacentDijiskstraNodes().entrySet()) {
	                DijkstraNode adjacentDijkstraNode = adjacencyPair.getKey();
	                Integer edgeWeigh = adjacencyPair.getValue();

	                if (!settledDijkstraNodes.contains(adjacentDijkstraNode)) {
	                    CalculateMinimumDistance(adjacentDijkstraNode, edgeWeigh, currentDijkstraNode);
	                    unsettledDijkstraNodes.add(adjacentDijkstraNode);
	                }
	            }
	            settledDijkstraNodes.add(currentDijkstraNode);
	        }
	        return graph;
	    }

	    private static void CalculateMinimumDistance(DijkstraNode evaluationDijkstraNode, Integer edgeWeigh, DijkstraNode sourceDijkstraNode) {
	        Integer sourceDistance = sourceDijkstraNode.getDistance();
	        if (sourceDistance + edgeWeigh < evaluationDijkstraNode.getDistance()) {
	            evaluationDijkstraNode.setDistance(sourceDistance + edgeWeigh);
	            LinkedList<DijkstraNode> shortestPath = new LinkedList<>(sourceDijkstraNode.getShortestPath());
	            shortestPath.add(sourceDijkstraNode);
	            evaluationDijkstraNode.setShortestPath(shortestPath);
	        }
	    }

	    private static DijkstraNode getLowestDistanceDijkstraNode(Set<DijkstraNode> unsettledDijkstraNodes) {
	        DijkstraNode lowestDistanceDijkstraNode = null;
	        int lowestDistance = Integer.MAX_VALUE;
	        for (DijkstraNode node : unsettledDijkstraNodes) {
	            int nodeDistance = node.getDistance();
	            if (nodeDistance < lowestDistance) {
	                lowestDistance = nodeDistance;
	                lowestDistanceDijkstraNode = node;
	            }
	        }
	        return lowestDistanceDijkstraNode;
	    }
}
