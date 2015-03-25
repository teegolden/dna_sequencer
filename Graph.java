import java.util.ArrayList;
import java.util.List;

public class Graph {
	ArrayList<String> vertices;
	ArrayList<Edge> edges;
	Edge optEdge;
	public Graph(String[] dnaStrings) {
		vertices = new ArrayList<>();
		for(String s: dnaStrings){
			vertices.add(s);
		}
		optEdge = new Edge(dnaStrings[0], dnaStrings[1]);
		updateEdges();
		
	}

	public Graph(List<String> dnaStrings) {
		this(dnaStrings.toArray(new String[dnaStrings.size()]));
	}

	private void updateEdges() {
		if(vertices.size() >1){
		optEdge = new Edge(vertices.get(0), vertices.get(1));
		edges = new ArrayList<Edge>();
		for(int i = 0; i <vertices.size(); i++){
			for(int j = 0; j <vertices.size(); j++){
				if( i != j){
					Edge e= new Edge(vertices.get(i), vertices.get(j));
					if(e.cost() > optEdge.cost()){
						optEdge = e;
					}
					edges.add(e);
				}
			}
		}
		if(vertices.size() == 2){
			vertices.remove(0);
			vertices.remove(0);
			vertices.add(optEdge.getValue());
		}
		}
		
	}

	public int getNumVertices() {
		// TODO Auto-generated method stub
		return vertices.size();
	}

	public Edge getMinEdge() {
		// TODO Auto-generated method stub
		return optEdge;
	}

	public void addVertex(Edge edge) {
		ArrayList<String> to_remove = new ArrayList<>();
		boolean insert = true;
		for(String vert: vertices){
			if(edge.getValue().contains(vert)){
				to_remove.add(vert);
			}
			else if(vert.contains(edge.getValue())){
				insert = false;
			}
		}
		for(String s: to_remove){
			vertices.remove(s);
		}
		if(insert) vertices.add(edge.getValue());
		updateEdges();

		
	}
	public String toString(){
		String s = "";
		for(String vert: vertices){
			s += vert + " ";
		}
		String s1 = "";
		for(Edge e: edges){
			s1 += e.getValue() + ": " + e.cost() + " ";
		}
		return s+"\n" + s1;
	
		
	}

	public String getVertex() {
		// TODO Auto-generated method stub
		return vertices.get(0);
	}

}
