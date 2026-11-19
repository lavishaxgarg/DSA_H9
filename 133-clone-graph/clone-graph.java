import java.util.HashMap;
import java.util.Map;

class Solution {
    private final Map<Node, Node> clones = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (clones.containsKey(node)) {
            return clones.get(node);
        }

        Node copy = new Node(node.val);
        clones.put(node, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor));
        }

        return copy;
    }
}