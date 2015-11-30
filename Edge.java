package lop;

public class Edge {
	public Vertex u;
	public Vertex v;
	public int weight;
	public String number;

	public Edge(Vertex u, Vertex v, int weight, String label) {
		super();
		this.u = u;
		this.v = v;
		this.weight = weight;
		this.number = label;
	}

	@Override
	public String toString() {
		return number;
	}

}
