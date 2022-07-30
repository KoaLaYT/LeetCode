package _20220729_Substr;

public class Solution {

    public boolean substr(String a, String b) {
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        int[] states = buildState(bb);

        return substr(aa, bb, states, bb.length - 1);
    }

    private int[] buildState(char[] bb) {
        int[] states = new int[bb.length];
        states[0] = -1;
        int state = -1;

        for (int i = 1; i < bb.length; i++) {
            while (state >= 0 && bb[i] != bb[state + 1]) {
                state = states[state];
            }
            if (bb[i] == bb[state + 1]) {
                state += 1;
            }
            states[i] = state;
        }

        return states;
    }

    private boolean substr(char[] aa, char[] bb, int[] states, int finalState) {
        int state = -1;

        for (char c : aa) {
            while (state >= 0 && c != bb[state + 1]) {
                state = states[state];
            }
            if (c == bb[state + 1]) {
                state += 1;
            }
            if (state == finalState) {
                return true;
            }
        }

        return false;
    }

}
