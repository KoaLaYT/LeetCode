package _20220729_Substr;

public class Solution {

    private static final long MODULO = 1000000007;

    public boolean substr(String a, String b) {
        if (a.length() < b.length()) {
            return false;
        }

        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();

        long aNum = aa[0] - 'a';
        long bNum = bb[0] - 'a';
        long base = 1;
        int i = 1;
        for (; i < bb.length; i++) {
            aNum = (aNum * 26 + (aa[i] - 'a')) % MODULO;
            bNum = (bNum * 26 + (bb[i] - 'a')) % MODULO;
            base = (base * 26) % MODULO;
        }

        while (true) {
            if (aNum == bNum) {
                return ensureEqual(aa, bb, i);
            }
            if (i >= aa.length) {
                break;
            }
            aNum -= (aa[i - bb.length] - 'a') * base;
            aNum = Math.floorMod(aNum * 26 + (aa[i] - 'a'), MODULO);
            i++;
        }

        return false;
    }

    private static boolean ensureEqual(char[] aa, char[] bb, int k) {
        for (int i = 0, j = k - bb.length; i < bb.length; i++, j++) {
            if (aa[j] != bb[i]) {
                return false;
            }
        }
        return true;
    }

}
