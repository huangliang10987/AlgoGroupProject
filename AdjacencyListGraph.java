package lop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Liang Huang
 *
 */
public class AdjacencyListGraph extends Graph {
	public List<Map<Integer, Edge>> adjacencyList;
	private List<Vertex> vertices;

	@Override
	public Vertex[] getVertices() {
		return vertices.toArray(new Vertex[0]);
	}

	@Override
	public void graph(int n) {
		this.adjacencyList = new ArrayList<Map<Integer, Edge>>(n);
		this.vertices = new ArrayList<Vertex>(n);
		this.setOrder(n);
		for (int i = 0; i < n; i++)
			adjacencyList.add(new HashMap<Integer, Edge>());
	}

	@Override
	public void addEdge(Edge e) {
		int u = e.u.number;
		Map<Integer, Edge> a = this.adjacencyList.get(u);
		if (!a.containsKey(e.v.number)) {
			a.put(e.v.number, e);
		}
	}

	@Override
	public void deleteEdge(Edge e) {
		int u = e.u.number;
		Map<Integer, Edge> a = this.adjacencyList.get(u);
		if (a.containsKey(e.v.number)) {
			a.remove(e.v.number);
		}
	}

	@Override
	public boolean isAjacency(Vertex u, Vertex v) {
		Map<Integer, Edge> a = this.adjacencyList.get(u.number);
		if (a.containsKey(v.number))
			return true;
		return false;
	}

	@Override
	public Vertex[] neighborhoods(Vertex v) {
		Map<Integer, Edge> a = this.adjacencyList.get(v.number);
		if (a == null)
			return null;
		int size = a.size();
		Vertex[] b = new Vertex[size];
		int i = 0;
		for (Edge e : a.values()) {
			b[i++] = e.v;
		}
		return b;
	}

	@Override
	public Vertex getVertex(int i) {
		return this.vertices.get(i);
	}

	@Override
	public void addVertex(int i, Vertex v) {
		if (i < this.getOrder())
			this.vertices.add(i, v);
	}

	@Override
	public Edge getEdge(Vertex u, Vertex v) {
		return this.adjacencyList.get(u.number).get(v.number);
	}
}
