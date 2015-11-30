package lop;

public abstract class Graph {
	/**
	 * number of vertices
	 */
	private int order;
	/**
	 * number of edges
	 */
	private int size;

	/**
	 * Initialize graph with no edge
	 * 
	 * @param n
	 *            number of vertices
	 */
	public abstract void graph(int n);

	/**
	 * Add edge to graph
	 * 
	 * @param e
	 */
	public abstract void addEdge(Edge e);

	/**
	 * delete edge
	 * 
	 * @param e
	 */
	public abstract void deleteEdge(Edge e);

	/**
	 * Is v adjacent to u.
	 * 
	 * @param u
	 * @param v
	 * @return
	 */
	public abstract boolean isAjacency(Vertex u, Vertex v);

	/**
	 * get neighbors of v
	 * 
	 * @param v
	 * @return
	 */
	public abstract Vertex[] neighborhoods(Vertex v);

	/**
	 * get all vertices of graph
	 * 
	 * @return
	 */
	public abstract Vertex[] getVertices();

	/**
	 * get vertex by number
	 * 
	 * @param i
	 * @return
	 */
	public abstract Vertex getVertex(int i);

	/**
	 * add vertex to position i
	 * 
	 * @param i
	 * @param v
	 */
	public abstract void addVertex(int i, Vertex v);

	/**
	 * get edge connected two vertices
	 * 
	 * @param u
	 * @param v
	 * @return
	 */
	public abstract Edge getEdge(Vertex u, Vertex v);

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
