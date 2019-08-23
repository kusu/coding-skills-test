package coding.test.ctci.stack;

import java.util.Stack;

public class SetOfStacks {

    private Stack<Stack<Integer>> stackSet = new Stack<>();

    int size;

    int count;

    public SetOfStacks(int size) {
        this.size = size;
    }


    public void push(int val) {
        if (stackSet.isEmpty() || count % size == 0) {
            Stack<Integer> newStack = new Stack<>();
            newStack.add(val);
            stackSet.add(newStack);
        } else {

            Stack<Integer> stack = stackSet.peek();

            stack.push(val);

        }

        count++;
    }

    public int peek() {
        if (!stackSet.isEmpty()) {

            Stack<Integer> stack = stackSet.peek();

            if (!stack.isEmpty()) {
                return stack.peek();
            }
        }

        System.out.println("Empty Stack");
        return -1;
    }

    public int pop() {
        if (!stackSet.isEmpty()) {

            Stack<Integer> stack = stackSet.peek();

            int val = -1;

            if (!stack.isEmpty()) {
                val = stack.pop();

                count--;

            }

            if (stack.isEmpty()) {
                stackSet.pop();
            }

            return val;
        }

        System.out.println("Empty Stack");
        return -1;
    }


    public static void main(String[] args) {
        SetOfStacks stacks = new SetOfStacks(3);

        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        stacks.push(5);
        stacks.push(6);

        System.out.println(stacks.peek());

        for (int i = 0; i <= 6; i++) {
            System.out.println(stacks.pop());
        }
    }
}
