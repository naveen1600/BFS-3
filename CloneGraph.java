// Time Complexity: O(V * E)
// Space Complexity: O(V * E)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        this.neighbors = new ArrayList<Node>();
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

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();
        Node copyCurr = new Node(node.val);
        q.add(node);
        map.put(node, copyCurr);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (Node ne : curr.neighbors) {
                if (!map.containsKey(ne)) {
                    q.add(ne);
                }
                Node neighbor = clone(ne, map);
                map.get(curr).neighbors.add(neighbor);
            }
        }

        return copyCurr;
    }

    private Node clone(Node node, HashMap<Node, Node> map) {
        if (map.containsKey(node))
            return map.get(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }
}