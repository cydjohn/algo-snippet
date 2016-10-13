import java.util.*; 
class Connection{
    String node1;
    String node2;
    int cost;
    public Connection(String a, String b, int c){
        node1 = a;
        node2 = b;
        cost = c;
    }
}
public class City_Connections {
	private static int unionNum = 0;
	public static ArrayList<Connection> getLowCost(ArrayList<Connection> connections) {
		ArrayList<Connection> res = new ArrayList<>();
		if (connections == null || connections.size() == 0) return res; //or return null;
		Collections.sort(connections, new Comparator<Connection>(){
			public int compare(Connection a, Connection b) {
				return a.cost - b.cost;
			}
		});
		Map<String, Integer> map = new HashMap<>();
		for (Connection c : connections) {
			String a = c.node1;
			String b = c.node2;
			//check if a and b are already connected, if not, connect them.
			if (union(map, a, b)) res.add(c);
		}
		//check if all cities are in the same connected group
		int group = map.get(connections.get(0).node1);
		for (String s : map.keySet()) {
			if (map.get(s) != group) return new ArrayList<>();
		}
		//print out the city names based on their name order
		Collections.sort(res, new Comparator<Connection>() {
			public int compare(Connection a, Connection b) {
				if (a.node1.equals(b.node1)) return a.node2.compareTo(b.node2);
				return a.node1.compareTo(b.node1);
			}
		});
		return res;
	}
	private static boolean union(Map<String, Integer> map, String a, String b) {
		if (!map.containsKey(a) && !map.containsKey(b)) {
			map.put(a, unionNum);
			map.put(b, unionNum);
			unionNum++;
			return true;
		}
		else if (!map.containsKey(a) && map.containsKey(b)) {
			map.put(a, map.get(b));
			return true;
		}
		else if (map.containsKey(a) && !map.containsKey(b)) {
			map.put(b, map.get(a));
			return true;
		}
		else {
			if (map.get(a) == map.get(b)) return false;
			else {
				for (String key : map.keySet()) {
					if (map.get(key) == map.get(a)) map.put(key, map.get(b));
				}
				return true;
			}
		}
	}
    public static void main(String[] args) {
    ArrayList<Connection> connections = new ArrayList<>();
    connections.add(new Connection("A","B",6));
    connections.add(new Connection("B","C",4));
    connections.add(new Connection("C","D",5));
    connections.add(new Connection("D","E",8));
    connections.add(new Connection("E","F",2));
    connections.add(new Connection("B","F",10));
    connections.add(new Connection("E","C",9));
    connections.add(new Connection("F","C",7));
    connections.add(new Connection("B","E",3));
    connections.add(new Connection("A","F",16));
    ArrayList<Connection> res = getLowCost(connections);
    for (Connection c : res){
        System.out.println(c.node1 + " -> " + c.node2 + " " + c.cost);
    }
}
}