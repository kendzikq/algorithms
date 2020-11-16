package algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static algorithms.Dijkstra.Node;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * see the model graph for the test: ../resources/DijkstraGraphExample.png
 */
class DijkstraTest {


    @Test
    @DisplayName("should calculate road correctly")
    void shouldCalculateRoadCorrectly() {

        // given
        var warsaw = new Node(1L, "Warsaw");
        var newYork = new Node(2L, "NewYork");
        var cracow = new Node(3L, "Cracow");
        var vietnam = new Node(4L, "Vietnam");

        var warsawNeighbours = new HashMap<Node, Long>();
        warsawNeighbours.put(newYork, 6L);
        warsawNeighbours.put(cracow, 2L);

        var newYorkNeighbours = new HashMap<Node, Long>();
        newYorkNeighbours.put(vietnam, 1L);

        var cracowNeighbours = new HashMap<Node, Long>();
        cracowNeighbours.put(newYork, 3L);
        cracowNeighbours.put(vietnam, 5L);

        var vietnamNeighbours = new HashMap<Node, Long>();

        var adjacencyList = new HashMap<Node, Map<Node, Long>>();
        adjacencyList.put(warsaw, warsawNeighbours);
        adjacencyList.put(newYork, newYorkNeighbours);
        adjacencyList.put(cracow, cracowNeighbours);
        adjacencyList.put(vietnam, vietnamNeighbours);

        var dijkstra = new Dijkstra(adjacencyList);

        // when
        var response = dijkstra.calculateRoad(warsaw);

        // then
        assertAll(
                () -> assertThat(response.getParents().get(newYork)).isEqualTo(cracow),
                () -> assertThat(response.getParents().get(vietnam)).isEqualTo(newYork),

                () -> assertThat(response.getCosts().get(cracow)).isEqualTo(2L),
                () -> assertThat(response.getCosts().get(newYork)).isEqualTo(5L),
                () -> assertThat(response.getCosts().get(vietnam)).isEqualTo(6L)
        );
    }
}