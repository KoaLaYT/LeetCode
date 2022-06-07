package _20220607_LCArray;

public class LCArray {

    private static final int INIT_CAP = 2;

    private int cap;
    private int len;
    private int[] arr;

    public LCArray() {
        arr = new int[INIT_CAP];
        cap = INIT_CAP;
        len = 0;
    }

    public void push_back(int n) {
        if (len == cap) {
            expand(2 * cap);
        }
        arr[len++] = n;
    }

    public void pop_back() {
        len--;
    }

    public int size() {
        return len;
    }

    public int index(int idx) {
        return arr[idx];
    }

    private void expand(int size) {
        int[] newArr = new int[size];
        System.arraycopy(arr, 0, newArr, 0, len);
        arr = newArr;
        cap = size;
    }

}
