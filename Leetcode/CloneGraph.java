import java.util.*;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a
 * list of its neighbors.
 *
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 *
 * We use # as a separator for each node, and , as a separator for node label
 * and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 *
 * The graph has a total of three nodes, and therefore contains three parts as
 * separated by #.
 *
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming
 * a self-cycle.
 * Visually, the graph looks like the following:
 *
 *        1
 *       / \
 *      /   \
 *     0 --- 2
 *          / \
 *          \_/
 *
 * Tags: DFS, BFS, Graph
 */
class CloneGraph {
	/**
	 * Definition for undirected graph.
	 * class UndirectedGraphNode {
	 *     int label;
	 *     List<UndirectedGraphNode> neighbors;
	 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	 * };
	 */
	public class Solution {
		//DFS
	    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	        if(node == null) return null;
	        HashMap<Integer,UndirectedGraphNode> map = new HashMap<>();
	        return clone(node,map);
	    }
	    public UndirectedGraphNode clone(UndirectedGraphNode node, HashMap<Integer,UndirectedGraphNode> map){
	        if(node==null) return null;
	        if(map.containsKey(node.label)) return map.get(node.label);
	        UndirectedGraphNode n = new UndirectedGraphNode(node.label);
	        map.put(n.label,n);
	        for(UndirectedGraphNode neighbor:node.neighbors){
	            n.neighbors.add(clone(neighbor,map));
	        }
	        return n;
	    }


	    //BFS
	    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	        if(node == null) return null;
	        HashMap<Integer,UndirectedGraphNode> map = new HashMap<>();
	        UndirectedGraphNode NewNode = new UndirectedGraphNode(node.label);
	        map.put(NewNode.label, NewNode);
	        
	        Queue<UndirectedGraphNode> cur = new LinkedList<>();
	        cur.add(node);
	        
	        while(!cur.isEmpty()){
	            UndirectedGraphNode tmpnode = cur.poll();
	            for(UndirectedGraphNode neighbor : tmpnode.neighbors){
	                if(!map.containsKey(neighbor.label)){
	                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
	                    cur.offer(neighbor);
	                }
	                map.get(tmpnode.label).neighbors.add(map.get(neighbor.label));
	            }
	        }
	        return  NewNode;
	    }
	}
}