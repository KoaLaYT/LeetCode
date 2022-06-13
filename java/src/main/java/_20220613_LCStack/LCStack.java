package _20220613_LCStack;

public class LCStack {

    private static final int INIT_SIZE = 1;
    private int[] arr;
    private int size;

    public LCStack() {
        this.arr = new int[INIT_SIZE];
        this.size = 0;
    }

    public void push(int x) {
        if (size == arr.length) {
            expand();
        }
        arr[size++] = x;
    }

    public void pop() {
        size -= 1;
    }

    public int size() {
        return size;
    }

    public int top() {
        return arr[size - 1];
    }

    private void expand() {
        int[] newArr = new int[size * 2];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }

}
