package coding.test.ctci.stack;

import java.util.Stack;

public class SortStack {

    private Stack<Integer> minStack;

    private int size;

    int[] data;
    int top = 0;

    private SortStack(int size) {
        this.size = size;
        data = new int[size];
        minStack = new Stack<Integer>();
    }

    public void push(int value) {

        if (minStack.size() == size) {
            System.out.println("Stack full");
            return;
        }

        if (minStack.isEmpty()) {
            minStack.push(value);
        } else {
            int current = minStack.peek();

            if (value <= current) {
                minStack.push(value);
            } else {

                while (!minStack.isEmpty() && minStack.peek() < value) {
                    int val = minStack.pop();
                    data[top++] = val;
                }

                minStack.push(value);

                while (top > 0) {
                    minStack.push(data[--top]);
                }
            }
        }

    }

    public int pop() {
        if (minStack.isEmpty()) {
            System.out.println("Stack empty");
            return -1;
        }

        return minStack.pop();
    }

    public int peek() {
        if (minStack.isEmpty()) {
            System.out.println("Stack empty");
            return -1;
        }

        return minStack.peek();
    }

    public static void main(String[] args) {

        SortStack sortStack = new SortStack(5);

        sortStack.push(1);
        sortStack.push(2);
        sortStack.push(4);
        sortStack.push(3);
        sortStack.push(5);
        sortStack.push(6);

        for (int i = 0; i < 6; i++) {
            System.out.println(sortStack.pop());
        }
    }
}
