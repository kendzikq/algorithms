package data_structures;

public class Stack {

    private int lastElementIdx;
    private final int[] stack;

    public Stack() {
        this(20);
    }

    public Stack(int stackCapacity) {
        stack = new int[stackCapacity];
        lastElementIdx = -1; // means stack is empty
    }


    public void push(int element) {
        if (stack.length <= lastElementIdx) {
            throw new RuntimeException("stackOverFlow capacity = " + stack.length);
        }
        stack[++lastElementIdx] = element;
    }

    public int pop() {
        if (lastElementIdx <= -1) {
            throw new RuntimeException("stack is empty");
        }
        return stack[lastElementIdx--];
    }
}
