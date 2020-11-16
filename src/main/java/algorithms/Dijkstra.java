package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Dijkstra {

    private Map<Node, Map<Node, Long>> adjacencyList;
    private Map<Node, Node> parents = new HashMap<>();
    private Map<Node, Long> costs = new HashMap<>();
    private Set<Node> visited = new HashSet<>();


    public Dijkstra(Map<Node, Map<Node, Long>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public ResponseDto calculateRoad(Node start) {
        parents.clear();
        visited.clear();
        costs.clear();
        visited.add(start);
        costs.putAll(adjacencyList.get(start));

        Node node = findCheapestNode(costs);
        while (node != null) {
            Long cost = costs.get(node);
            Map<Node, Long> neighbours = adjacencyList.get(node);

            for (Node neighbour : neighbours.keySet()) {
                Long newCost = cost + neighbours.get(neighbour);
                if (newCost <= costs.getOrDefault(neighbour, Long.MAX_VALUE)) {
                    costs.put(neighbour, newCost);
                    parents.put(neighbour, node);
                }
            }
            visited.add(node);
            node = findCheapestNode(costs);
        }
        return new ResponseDto(parents, costs);
    }

    private Node findCheapestNode(Map<Node, Long> costs) {

        Node node = null;
        Long cost = Long.MAX_VALUE;

        for (Map.Entry<Node, Long> entry : costs.entrySet()) {
            if (!visited.contains(entry.getKey()) && entry.getValue() <= cost) {
                node = entry.getKey();
                cost = entry.getValue();
            }
        }

        return node;
    }

    static class ResponseDto {
        private Map<Node, Node> parents;
        private Map<Node, Long> costs;

        public ResponseDto(Map<Node, Node> parents, Map<Node, Long> costs) {
            this.costs = costs;
            this.parents = parents;
        }

        public Map<Node, Node> getParents() {
            return parents;
        }

        public Map<Node, Long> getCosts() {
            return costs;
        }
    }


    static class Node {
        private long id;
        private String name;

        public Node(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return id == node.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}