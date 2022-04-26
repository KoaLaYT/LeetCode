package _20220426_EggDropWith2EggsAndNFloors;

public class Solution {

    public int twoEggDrop(int n) {
        // x + (x-1) + (x-2) + ... + 1 >= n
        // (1+x) * x / 2 >= n
        // 即求满足以上一元二次不等式的最小自然数x
        return (int) Math.ceil((Math.sqrt(8 * n + 1) - 1) / 2);
    }

}
