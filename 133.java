/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        HashMap<Node, Node> visited = new HashMap<>();
        LinkedList<Node> frontier = new LinkedList<>();
        visited.put(node, new Node(node.val, new ArrayList<>()));
        frontier.add(node);
        
        while (!frontier.isEmpty()) {
            Node curr = frontier.remove();
            
            for (Node neighbor: curr.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    frontier.add(neighbor);
                }
                visited.get(curr).neighbors.add(visited.get(neighbor));
            }
        }
        
        return visited.get(node);
    }
}
