package algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static algorithms.BreadthFirstSearch.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 *
 * see the model graph for the test: ../resources/BTSGraphExample.png
 */
class BreadthFirstSearchTest {

    private BreadthFirstSearch bts = new BreadthFirstSearch(7);

    private Person john = new Person(0, "John");
    private Person ann = new Person(1, "Ann");
    private Person peter = new Person(2, "Peter");
    private Person monica = new Person(3, "Monica");
    private Person rachel = new Person(4, "Rachel");
    private Person phoebe = new Person(5, "Phoebe");
    private Person richard = new Person(6, "Richard");


    @Test
    void shouldReturnNodesInTheRightOrderForJohn() {

        // given
        initGraph();

        // when
        var result = bts.BTS(john);

        // then
        List<Person> expectedResult = List.of(john, ann, peter, monica, rachel, phoebe, richard);
        assertEquals(expectedResult, result);
    }

    @Test
    void shouldReturnNodesInTheRightOrderForPhoebe() {

        // given
        initGraph();

        // when
        var result = bts.BTS(phoebe);

        // then
        List<Person> expectedResult = List.of(phoebe, ann, monica, rachel, john, peter, richard);
        assertEquals(expectedResult, result);
    }

    private void initGraph() {

        bts.initPerson(john);
        bts.initPerson(ann);
        bts.initPerson(peter);
        bts.initPerson(monica);
        bts.initPerson(rachel);
        bts.initPerson(phoebe);
        bts.initPerson(richard);

        bts.addUndirectedEdge(john, ann);
        bts.addUndirectedEdge(john, peter);
        bts.addUndirectedEdge(john, monica);

        bts.addUndirectedEdge(ann, rachel);
        bts.addUndirectedEdge(ann, phoebe);

        bts.addUndirectedEdge(peter, monica);

        bts.addUndirectedEdge(monica, rachel);
        bts.addUndirectedEdge(monica, phoebe);
        bts.addUndirectedEdge(monica, richard);

        bts.addUndirectedEdge(rachel, phoebe);
    }
}