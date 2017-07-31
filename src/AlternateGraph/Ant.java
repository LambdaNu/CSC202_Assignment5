package AlternateGraph;

public class Ant {
	protected int distance;
	protected int path[];
	protected boolean touched[];

	public Ant(int tourSize) {
		this.distance = tourSize;
		this.path = new int[tourSize];
		this.touched = new boolean[tourSize];
	}

	public void visitNode(int currIndex, int node) {
		path[currIndex + 1] = node;
		touched[node] = true;
	}

	protected boolean touched(int i) {
		return touched[i];
	}

	public double pathLength(double graph[][]) {
		double length = graph[path[distance - 1]][path[0]];
		for (int i = 0; i < distance - 1; i++) {
			length += graph[path[i]][path[i + 1]];
		}
		return length;
	}

	public void clear() {
		for (int i = 0; i < distance; i++)
			touched[i] = false;
	}
}
