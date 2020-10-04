public class Queue {

    private final int[] queue;
    private final int capacity;
    private int rear, front, elementsCounter = 0;


    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
    }

    public void queue(int element) {
        checkOverFlow();
        queue[rear] = element;
        rear = (rear + 1) % capacity; // elements constantly revolve around 0..capacity-1
        elementsCounter++;
    }

    public void dequeue() {
        checkUnderFlow();
        front = (front + 1) % capacity; // elements constantly revolve around 0..capacity-1
        elementsCounter--;
    }

    public int peek() {
        checkUnderFlow();
        return queue[front];
    }

    public boolean isEmpty() {
        return elementsCounter == 0;
    }

    private void checkUnderFlow() {
        if (elementsCounter == 0) {
            throw new RuntimeException("queue underflow");
        }
    }

    private void checkOverFlow() {
        if (elementsCounter == capacity) {
            throw new RuntimeException("queue overflow");
        }
    }
}