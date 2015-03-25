import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DnaSequence {
	public static String getMatch(List<String> dnaStrings){
		Graph graph = new Graph(dnaStrings);
		while(graph.getNumVertices() > 1){
			Edge edge = graph.getMinEdge();
			graph.addVertex(edge);
		}
		return graph.getVertex();
	}
	
	public static void test(){
		try{
			for(int j = 1;j < 5; j++){
				String path = "DataSet//answer" + j + ".txt";
				String path2 = "DataSet//output" + j + ".txt";
	
				List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
				List<String> lines2 = Files.readAllLines(Paths.get(path2), StandardCharsets.UTF_8);
				for(int i =0; i < lines.size(); i++){
					if(!lines.get(i).equals(lines2.get(i))){
						System.out.println("Error " + lines2.get(i) +"\n instead " + lines.get(i));
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String argv[]){
		try {
			int maxInput = 17;
			for(int i = 1; i < maxInput; i++){
				String path = "DataSet//reads" + i + ".txt";
				String path2 = "DataSet//output" + i + ".txt";
	
			List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
			PrintWriter writer = new PrintWriter(path2, "UTF-8");
			writer.println(getMatch(lines));
			writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

