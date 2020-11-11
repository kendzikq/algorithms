package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
/**
 * Basic example for people network
 */
public class BreadthFirstSearch {

    private final int v; // number of vertices (nodes)
    private final Map<Person, LinkedHashSet<Person>> adj; // Adjacency Lists

    public BreadthFirstSearch(int v) {
        this.v = v;
        adj = new HashMap<>(v);
    }


    public void initPerson(Person person) {
        adj.put(person, new LinkedHashSet<>());
    }

    public void addUndirectedEdge(Person v, Person u) {
        adj.get(v).add(u);
        adj.get(u).add(v);
    }


    public List<Person> bfs(Person start) {

        List<Person> result = new LinkedList<>();
        LinkedList<Person> queue = new LinkedList<>();
        Set<Person> visited = new HashSet<>(v);

        queue.add(start);

        while (queue.size() != 0) {
            Person person = queue.poll();
            if (!visited.contains(person)) {
                result.add(person);
                visited.add(person);
                queue.addAll(adj.get(person));
            }
        }
        return result;
    }


    static class Person {
        private final int id;
        private final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return id == person.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

    }
}