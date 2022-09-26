package _20220926_RandomPickIndex;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class SolutionTest {

    private static final int LOOP = 10;

    private Solution solution;

    @Test
    public void testCase1() {
        solution = new Solution(new int[]{1, 2, 3, 3, 3});
        assertContains(Set.of(2, 3, 4), 3);
        assertContains(Set.of(1), 2);
        assertContains(Set.of(0), 1);
    }

    @Test
    public void testCase2() {
        solution = new Solution(new int[]{1});
        assertContains(Set.of(0), 1);
    }

    private void assertContains(Set<Integer> set, int target) {
        for (int i = 0; i < LOOP; i++) {
            int index = solution.pick(target);
            Assert.assertTrue(set.contains(index));
        }
    }

}