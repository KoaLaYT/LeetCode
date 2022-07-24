package _20220724_CustomStack;

public class CustomStack {

    private final int[] stack;
    private int size;
    private final int maxSize;

    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        this.size = 0;
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (size == maxSize) {
            return;
        }
        stack[size++] = x;
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }
        return stack[--size];
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, size); i++) {
            stack[i] += val;
        }
    }

}
