package coding.test.ctci.stack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> min;

    private int top = 0;
    int[] data;
    int size;

    public MinStack(int size) {
        this.data = new int[size];
        this.size = size;
        this.min = new Stack<Integer>();
    }

    public void push(int val) {
        if (top == size) {
            System.out.println("Stack full");
        } else {
            if (top == 0) {
                min.push(val);
            } else {
                int currentMin = min.peek();

                if (val < currentMin) {
                    min.push(val);
                }
            }

            data[top++] = val;
        }

    }

    public int peek() {
        if (top == 0) {
            System.out.println("Empty stack");
            return -1;
        } else {
            return data[top - 1];
        }
    }

    public int pop() {
        int val = peek();

        if (val >= 0) {
            top--;

            if (val == min.peek()) {
                min.pop();
            }
        }


        return val;
    }

    public int min() {
        if (top == 0) {
            System.out.println("Empty stack");
            return -1;
        }

        return min.peek();
    }


    public static void main(String[] args) {
        MinStack stack = new MinStack(3);

        stack.pop();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        int pop1 = stack.pop();
        int min = stack.min();

        System.out.println("p1:" + pop1);
        System.out.println("min1:" + min);

        int pop2 = stack.pop();
        min = stack.min();

        System.out.println("p2:" + pop2);
        System.out.println("min2:" + min);
        int pop3 = stack.pop();
        min = stack.min();

        System.out.println("p3:" + pop3);
        System.out.println("min3:" + min);
        int pop4 = stack.pop();
    }
}
