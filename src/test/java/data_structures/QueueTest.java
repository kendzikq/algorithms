package data_structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QueueTest {

    @Test
    void shouldWorkAsFIFO() {

        // given
        var queue = new Queue(5);

        // when
        queue.queue(0);
        queue.queue(2);
        queue.queue(3);

        // then
        assertEquals(0, queue.peek());
        assertEquals(0, queue.peek());

        // when
        queue.queue(-1);
        queue.queue(8);
        queue.dequeue();
        queue.dequeue();

        // then
        assertEquals(3, queue.peek());

        //should not throw overflow exception
        // the index is starting from the start (0)
        // when
        queue.queue(5);
        queue.dequeue();

        // then
        assertEquals(-1, queue.peek());
        assertFalse(queue::isEmpty);
    }

    @Test
    void shouldThrowOverFlowException() {

        // given
        var queue = new Queue(2);

        // when
        queue.queue(2);
        queue.queue(4);
        queue.dequeue();
        queue.queue(5);

        // then
        assertThrows(RuntimeException.class, () -> queue.queue(6), "queue overflow");
    }

    @Test
    void shouldThrowQueueUnderflowException() {

        // given
        var queue = new Queue(2);

        // when
        queue.queue(2);
        queue.queue(3);
        queue.dequeue();
        queue.queue(4);
        queue.dequeue();
        queue.dequeue();

        // then
        assertThrows(RuntimeException.class, queue::dequeue, "queue underflow");
    }

    @Test
    void isEmptyShouldReflectRightStates() {

        // given
        var queue = new Queue(3);

        // when
        queue.queue(0);
        queue.queue(1);
        queue.queue(2);

        // then
        assertFalse(queue::isEmpty);

        // when
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        // then
        assertTrue(queue::isEmpty);
    }
}