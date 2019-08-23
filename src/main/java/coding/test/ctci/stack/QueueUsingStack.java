package coding.test.ctci.stack;

import java.util.Stack;

public class QueueUsingStack {

    int size;

    int top;
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStack(int size) {
        this.size = size;

        stack2 = new Stack<>();
        stack1 = new Stack<>();
    }

    public void push(int val) {
        if (top == size) {
            System.out.println("queue full");
        } else {
            if (stack2.isEmpty()) {
                stack2.push(val);
            } else {

                while (!stack2.isEmpty()) {

                    stack1.push(stack2.pop());
                }
                stack2.push(val);

                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }

            }
            top++;
        }
    }

    public int deque() {

        if (top == 0) {
            System.out.println("Empty queue");
            return -1;
        } else {

            top--;

            return stack2.pop();
        }
    }

    public int peek() {

        if (top == 0) {
            System.out.println("Empty queue");
            return -1;
        } else {

            return stack2.peek();
        }
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack(3);

        queue.deque();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        int pop1 = queue.deque();
        int pop2 = queue.deque();
        int pop3 = queue.deque();
        int pop4 = queue.deque();

        System.out.println(pop1);
        System.out.println(pop2);
        System.out.println(pop3);

        queue.push(4);
        queue.push(3);
        queue.push(2);
        queue.push(1);

        pop1 = queue.deque();
        pop2 = queue.deque();
        pop3 = queue.deque();
        pop4 = queue.deque();

        System.out.println(pop1);
        System.out.println(pop2);
        System.out.println(pop3);

    }

}
