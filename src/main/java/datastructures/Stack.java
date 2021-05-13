package datastructures;

public class Stack {

    private static final int EMPTY_STACK_IDX = -1;

    private int lastElementIdx;
    private final int[] stack;

    public Stack() {
        this(20);
    }

    public Stack(int stackCapacity) {
        stack = new int[stackCapacity];
        lastElementIdx = EMPTY_STACK_IDX;
    }


    public void push(int element) {
        if (stack.length <= lastElementIdx) {
            throw new RuntimeException("stackOverFlow capacity = " + stack.length);
        }
        stack[++lastElementIdx] = element;
    }

    public int pop() {
        if (lastElementIdx <= EMPTY_STACK_IDX) {
            throw new RuntimeException("stack is empty");
        }
        return stack[lastElementIdx--];
    }
}
