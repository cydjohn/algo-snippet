/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if (node == null) return null;
        HashMap<Integer, UndirectedGraphNode> map = new HashMap();
        return dfs(node, map);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
    	UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
    	map.put(node.label, cloneNode);
    	for (UndirectedGraphNode x : node.neighbors) {
    		UndirectedGraphNode nb = map.get(x.label);
    		if (nb == null) nb = dfs(x, map);
    		cloneNode.neighbors.add(nb);
    	}
    	return cloneNode;
    }
}