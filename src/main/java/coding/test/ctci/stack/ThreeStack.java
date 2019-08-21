package coding.test.ctci.stack;

public class ThreeStack {

    private int[] data;

    private int[] top;

    int size;

    public ThreeStack(int size) {
        data = new int[3 * size];
        this.size = size;
        top = new int[3];

        for (int i = 0; i < top.length; i++) {
            top[i] = 0;
        }
    }

    public void push(int value, int stackNum) {
        if (top[stackNum] >= size) {
            System.out.println("Stack Full");
            return;
        }

        int index = stackNum * size + top[stackNum];

        data[index] = value;
        top[stackNum]++;
    }

    public int pop(int stackNum) {
        int peek = peek(stackNum);

        if (peek >= 0) {
            top[stackNum]--;
        }
        return peek;
    }

    public int peek(int stackNum) {
        if (top[stackNum] == 0) {
            System.out.println("Empty stack");

            return -1;
        } else {
            int index = stackNum * size + top[stackNum]-1;
            return data[index];
        }
    }

    public static void main(String[] args) {
        ThreeStack stack = new ThreeStack(3);

        stack.pop(1);

        stack.push(1, 0);
        stack.push(2, 0);
        stack.push(3, 0);
        stack.push(4, 0);

        int pop1 = stack.pop(0);
        int pop2 = stack.pop(0);
        int pop3 = stack.pop(0);
        int pop4 = stack.pop(0);

        System.out.println(pop1);
        System.out.println(pop2);
        System.out.println(pop3);

        stack.push(4, 1);
        stack.push(3, 1);
        stack.push(2, 1);
        stack.push(1, 1);

         pop1 = stack.pop(1);
         pop2 = stack.pop(1);
         pop3 = stack.pop(1);
         pop4 = stack.pop(1);

        System.out.println(pop1);
        System.out.println(pop2);
        System.out.println(pop3);

    }

}
