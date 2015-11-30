package lop;

import java.util.List;

public class DynamicProgram {

	public Integer[] LOP = null;
	public String[] s = null;
	public Graph[] gList = null;

	public static void main(String[] args) {

		String input = "input.txt", output = "output.txt";
		DynamicProgram ms = new DynamicProgram();
		List<String> fileText = FileOperator.readFile(input);
		ms.parseToGraph(fileText);
		String text = ms.longestOrderPath();
		System.out.print(text);
		FileOperator.writeToFile(output, text);

	}

	private String longestOrderPath() {
		String text = "";
		int instance = gList.length;
		int temp = 0;
		int max = 0;
		for (int i = 0; i < instance; i++) {
			Graph g = gList[i];
			temp = 0;
			max = 0;
			int n = g.getOrder();
			LOP = new Integer[n];
			s = new String[n];
			int k = 0;
			for (int j = 0; j < n; j++) {
				LOP[j] = -1;
			}
			for (int j = 0; j < n; j++) {
				temp = longestOrderPath(g, j, n - 1);
				if (temp > max) {
					max = temp;
					k = j;
				}
			}
			String sp = System.getProperty("line.separator");
			text = text + String.valueOf(max) + sp + s[k];
			if (i < instance - 1) {
				text = text + sp + sp;
			}
		}
		return text;
	}

	private int longestOrderPath(Graph g, int i, int n) {
		if (i == n) {
			LOP[i] = 0;
			return 0;
		} else if (LOP[i] != -1)
			return LOP[i];
		else {
			int max = 0;
			int temp;
			Vertex temp2 = null;
			Vertex u = g.getVertex(i);
			Vertex[] neighbors = g.neighborhoods(u);
			for (Vertex v : neighbors) {
				int k = v.number;
				temp = 1 + longestOrderPath(g, k, n);
				if (temp > max) {
					max = temp;
					temp2 = v;
				}
			}
			LOP[i] = max;
			if (temp2 != null) {
				String e = g.getEdge(u, temp2).toString();
				if (s[temp2.number] == null)
					s[i] = e;
				else
					s[i] = e + " " + s[temp2.number];
			}
			return max;
		}
	}

	private void parseToGraph(List<String> lines) {
		int l = 0;// number of line
		String line = lines.get(l++);
		if (line != null) {// parse the first line
			int instance = Integer.parseInt(line);
			this.gList = new Graph[instance];
			for (int k = 0; k < instance; k++) {
				l++;
				line = lines.get(l++);
				String[] s = line.split(" ");
				int n = Integer.parseInt(s[0]);
				int m = Integer.parseInt(s[1]);
				AdjacencyListGraph g = new AdjacencyListGraph();
				g.graph(n);
				gList[k] = g;
				for (int i = 0; i < n; i++) {
					Vertex v = new Vertex();
					v.number = i;
					g.addVertex(v.number, v);
				}
				for (int i = 0; i < m; i++) {
					line = lines.get(l++);
					s = line.split(" ");
					Vertex u = g.getVertex(Integer.parseInt(s[0]) - 1);
					Vertex v = g.getVertex(Integer.parseInt(s[1]) - 1);
					g.addEdge(new Edge(u, v, 1, String.valueOf(i + 1)));
				}
			}
		}
	}
}
