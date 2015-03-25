public class Edge {
	String value;
	int cost;
	public Edge(String string, String string2) {
		value = merge(string, string2);
		cost = string.length()+string2.length() - value.length();
	}

	private String merge(String string, String string2) {
		if(string.contains(string2)){
			return string;
		}
		else{
			for(int i = 0; i < string.length(); i++){
				int index = 0;
				while(i < string.length() && string.charAt(i) != string2.charAt(0)){
					i++;
				}
				if(i == string.length()){
					return string + string2;
				}
				else{
					while(i +index < string.length() && string.charAt(i + index) == string2.charAt(index++)){
						if(index == string2.length()){
							return string;
						}
						else if(i + index== string.length()){
							return string + string2.substring(index);
						}
					}
				}
			}
			return string + string2;
		}
	}

	public int cost() {
		// TODO Auto-generated method stub
		return cost;
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

}
