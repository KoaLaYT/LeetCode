package _20220201_WordSearchII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public TestCase testCase;

    @Parameters
    public static TestCase[] data() {
        return new TestCase[]{
                new TestCase(
                        new char[][]{
                                {'o', 'a', 'a', 'n'},
                                {'e', 't', 'a', 'e'},
                                {'i', 'h', 'k', 'r'},
                                {'i', 'f', 'l', 'v'}},
                        new String[]{"oath", "pea", "eat", "rain"},
                        Arrays.asList("eat", "oath")),
                new TestCase(
                        new char[][]{
                                {'a', 'b'},
                                {'c', 'd'}},
                        new String[]{"abcb"},
                        Collections.emptyList()),
                new TestCase(
                        new char[][]{
                                {'o', 'a', 'b', 'n'},
                                {'o', 't', 'a', 'e'},
                                {'a', 'h', 'k', 'r'},
                                {'a', 'f', 'l', 'v'}},
                        new String[]{"oa", "oaa"},
                        Arrays.asList("oa", "oaa")),
                new TestCase(
                        new char[][]{{'a', 'a'}},
                        new String[]{"aaa"},
                        Collections.emptyList()),
                new TestCase(
                        new char[][]{{'a'}},
                        new String[]{"a"},
                        Collections.singletonList("a"))
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<String> result = solution.findWords(testCase.board, testCase.words);

        Assert.assertEquals(testCase.expected.size(), result.size());
        Assert.assertTrue(testCase.expected.containsAll(result));
    }

    private static class TestCase {
        private char[][] board;
        private String[] words;
        private List<String> expected;

        TestCase(char[][] board, String[] words, List<String> expected) {
            this.board = board;
            this.words = words;
            this.expected = expected;
        }
    }

}