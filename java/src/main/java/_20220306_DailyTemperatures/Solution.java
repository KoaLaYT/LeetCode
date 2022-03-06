package _20220306_DailyTemperatures;

public class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        TempInfo[] stack = new TempInfo[temperatures.length];
        int top = 0;

        for (int i = 0; i < temperatures.length; i++) {
            while (top > 0 && stack[top - 1].temp < temperatures[i]) {
                res[stack[top - 1].index] = i - stack[top - 1].index;
                top--;
            }
            stack[top++] = new TempInfo(temperatures[i], i);
        }

        return res;
    }

    private static class TempInfo {
        int temp;
        int index;

        TempInfo(int temp, int index) {
            this.temp = temp;
            this.index = index;
        }
    }

}
