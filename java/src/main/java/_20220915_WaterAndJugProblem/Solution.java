package _20220915_WaterAndJugProblem;

public class Solution {

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }
        if (jug1Capacity == 0 || jug2Capacity == 0) {
            return targetCapacity == 0 || jug1Capacity + jug2Capacity == targetCapacity;
        }
        return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
    }

    private int gcd(int x, int y) {
        int remainder = x % y;
        while (remainder != 0) {
            x = y;
            y = remainder;
            remainder = x % y;
        }
        return y;
    }

}
