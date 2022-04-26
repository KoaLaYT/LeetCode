package _20220426_SuperEggDrop;

public class Solution {

    public int superEggDrop(int k, int n) {
        int t = 1;
        while (calF(k, t) < n) {
            t++;
        }
        return t;
    }

    public int calF(int k, int t) {
        if (k == 1) {
            return t;
        }
        if (t == 1) {
            return 1;
        }
        return 1 + calF(k, t - 1) + calF(k - 1, t - 1);
    }

}
