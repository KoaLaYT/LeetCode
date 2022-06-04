package _20220604_SmallestSufficientTeam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String[] req_skills;

    @Parameterized.Parameter(1)
    public List<List<String>> people;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {
                        new String[]{"java", "nodejs", "reactjs"},
                        Arrays.asList(
                                Arrays.asList("java"),
                                Arrays.asList("nodejs"),
                                Arrays.asList("nodejs", "reactjs")
                        ),
                        2
                },
                {
                        new String[]{"algorithms", "math", "java", "reactjs", "csharp", "aws"},
                        Arrays.asList(
                                Arrays.asList("algorithms", "math", "java"),
                                Arrays.asList("algorithms", "math", "reactjs"),
                                Arrays.asList("java", "csharp", "aws"),
                                Arrays.asList("reactjs", "csharp"),
                                Arrays.asList("csharp", "math"),
                                Arrays.asList("aws", "java")
                        ),
                        2
                },
                {
                        new String[]{"mmcmnwacnhhdd", "vza", "mrxyc"},
                        Arrays.asList(
                                Arrays.asList("mmcmnwacnhhdd"),
                                Arrays.asList(),
                                Arrays.asList(),
                                Arrays.asList("vza", "mrxyc")
                        ),
                        2
                },
                {
                        new String[]{"gvp", "jgpzzicdvgxlfix", "kqcrfwerywbwi", "jzukdzrfgvdbrunw", "k"},
                        Arrays.asList(
                                Arrays.asList(),
                                Arrays.asList(),
                                Arrays.asList(),
                                Arrays.asList(),
                                Arrays.asList("jgpzzicdvgxlfix"),
                                Arrays.asList("jgpzzicdvgxlfix", "k"),
                                Arrays.asList("jgpzzicdvgxlfix", "kqcrfwerywbwi"),
                                Arrays.asList("gvp"),
                                Arrays.asList("jzukdzrfgvdbrunw"),
                                Arrays.asList("gvp", "kqcrfwerywbwi")
                        ),
                        3
                },
                {
                        new String[]{"mwobudvo", "goczubcwnfze", "yspbsez", "pf", "ey", "hkq"},
                        Arrays.asList(
                                Arrays.asList(), // 0
                                Arrays.asList("mwobudvo"), // 1
                                Arrays.asList("hkq"), // 2
                                Arrays.asList("pf"), // 3
                                Arrays.asList("pf"),// 4
                                Arrays.asList("mwobudvo", "pf"),// 5
                                Arrays.asList(), // 6
                                Arrays.asList("yspbsez"), //7
                                Arrays.asList(),//8
                                Arrays.asList("hkq"),//9
                                Arrays.asList(),//10
                                Arrays.asList(),//11
                                Arrays.asList("goczubcwnfze", "pf", "hkq"),//12
                                Arrays.asList("goczubcwnfze"),//13
                                Arrays.asList("hkq"),//14
                                Arrays.asList("mwobudvo"),//15
                                Arrays.asList(),//16
                                Arrays.asList("mwobudvo", "pf"),//17
                                Arrays.asList("pf", "ey"),//18
                                Arrays.asList("mwobudvo"),//19
                                Arrays.asList("hkq"),//20
                                Arrays.asList(),//21
                                Arrays.asList("pf"),//22
                                Arrays.asList("mwobudvo", "yspbsez"),//23
                                Arrays.asList("mwobudvo", "goczubcwnfze"),//24
                                Arrays.asList("goczubcwnfze", "pf"),//25
                                Arrays.asList("goczubcwnfze"),//26
                                Arrays.asList("goczubcwnfze"),//27
                                Arrays.asList("mwobudvo"),//28
                                Arrays.asList("mwobudvo", "goczubcwnfze"),//29
                                Arrays.asList(),//30
                                Arrays.asList("goczubcwnfze"),//31
                                Arrays.asList(),//32
                                Arrays.asList("goczubcwnfze"),//33
                                Arrays.asList("mwobudvo"),//34
                                Arrays.asList(),//35
                                Arrays.asList("hkq"),//36
                                Arrays.asList("yspbsez"),//37
                                Arrays.asList("mwobudvo"),//38
                                Arrays.asList("goczubcwnfze", "ey")//39
                        ),
                        3
                },
                {
                        new String[]{"jzjgkjymmlsv", "ryeqispun", "pgbxnmcqj", "gurg", "xweykqj", "paiutrvmzg", "lmdghrdhqr", "dvkplbbs", "sxx"},
                        Arrays.asList(Arrays.asList("gurg", "dvkplbbs"), Arrays.asList("xweykqj"), Arrays.asList("jzjgkjymmlsv", "ryeqispun", "gurg", "lmdghrdhqr", "sxx"), Arrays.asList("ryeqispun", "gurg"), Arrays.asList("ryeqispun", "lmdghrdhqr"), Arrays.asList(), Arrays.asList("xweykqj"), Arrays.asList(), Arrays.asList("gurg"), Arrays.asList("ryeqispun", "gurg", "lmdghrdhqr"), Arrays.asList("ryeqispun"), Arrays.asList("gurg", "lmdghrdhqr"), Arrays.asList(), Arrays.asList("ryeqispun", "gurg", "lmdghrdhqr"), Arrays.asList(), Arrays.asList("pgbxnmcqj", "gurg", "sxx"), Arrays.asList("lmdghrdhqr"), Arrays.asList("gurg"), Arrays.asList("ryeqispun"), Arrays.asList("xweykqj", "sxx"), Arrays.asList(), Arrays.asList("jzjgkjymmlsv", "dvkplbbs"), Arrays.asList("ryeqispun"), Arrays.asList("ryeqispun", "paiutrvmzg", "dvkplbbs"), Arrays.asList(), Arrays.asList("sxx"), Arrays.asList(), Arrays.asList("jzjgkjymmlsv", "xweykqj"), Arrays.asList("xweykqj"), Arrays.asList("gurg", "dvkplbbs"), Arrays.asList("lmdghrdhqr", "sxx"), Arrays.asList("gurg", "lmdghrdhqr", "dvkplbbs", "sxx"), Arrays.asList("gurg"), Arrays.asList("xweykqj"), Arrays.asList(), Arrays.asList(), Arrays.asList(), Arrays.asList("jzjgkjymmlsv"), Arrays.asList("ryeqispun"), Arrays.asList("xweykqj", "lmdghrdhqr"), Arrays.asList("xweykqj"), Arrays.asList("paiutrvmzg"), Arrays.asList(), Arrays.asList("jzjgkjymmlsv", "gurg"), Arrays.asList("gurg", "paiutrvmzg", "dvkplbbs"), Arrays.asList("gurg"), Arrays.asList("lmdghrdhqr"), Arrays.asList(), Arrays.asList(), Arrays.asList("ryeqispun", "sxx")),
                        4
                },
                {
                        new String[]{"hfkbcrslcdjq", "jmhobexvmmlyyzk", "fjubadocdwaygs", "peaqbonzgl", "brgjopmm", "x", "mf", "pcfpppaxsxtpixd", "ccwfthnjt", "xtadkauiqwravo", "zezdb", "a", "rahimgtlopffbwdg", "ulqocaijhezwfr", "zshbwqdhx", "hyxnrujrqykzhizm"},
                        Arrays.asList(Arrays.asList("peaqbonzgl", "xtadkauiqwravo"), Arrays.asList("peaqbonzgl", "pcfpppaxsxtpixd", "zshbwqdhx"), Arrays.asList("x", "a"), Arrays.asList("a"), Arrays.asList("jmhobexvmmlyyzk", "fjubadocdwaygs", "xtadkauiqwravo", "zshbwqdhx"), Arrays.asList("fjubadocdwaygs", "x", "zshbwqdhx"), Arrays.asList("x", "xtadkauiqwravo"), Arrays.asList("x", "hyxnrujrqykzhizm"), Arrays.asList("peaqbonzgl", "x", "pcfpppaxsxtpixd", "a"), Arrays.asList("peaqbonzgl", "pcfpppaxsxtpixd"), Arrays.asList("a"), Arrays.asList("hyxnrujrqykzhizm"), Arrays.asList("jmhobexvmmlyyzk"), Arrays.asList("hfkbcrslcdjq", "xtadkauiqwravo", "a", "zshbwqdhx"), Arrays.asList("peaqbonzgl", "mf", "a", "rahimgtlopffbwdg", "zshbwqdhx"), Arrays.asList("xtadkauiqwravo"), Arrays.asList("fjubadocdwaygs"), Arrays.asList("x", "a", "ulqocaijhezwfr", "zshbwqdhx"), Arrays.asList("peaqbonzgl"), Arrays.asList("pcfpppaxsxtpixd", "ulqocaijhezwfr", "hyxnrujrqykzhizm"), Arrays.asList("a", "ulqocaijhezwfr", "hyxnrujrqykzhizm"), Arrays.asList("a", "rahimgtlopffbwdg"), Arrays.asList("zshbwqdhx"), Arrays.asList("fjubadocdwaygs", "peaqbonzgl", "brgjopmm", "x"), Arrays.asList("hyxnrujrqykzhizm"), Arrays.asList("jmhobexvmmlyyzk", "a", "ulqocaijhezwfr"), Arrays.asList("peaqbonzgl", "x", "a", "ulqocaijhezwfr", "zshbwqdhx"), Arrays.asList("mf", "pcfpppaxsxtpixd"), Arrays.asList("fjubadocdwaygs", "ulqocaijhezwfr"), Arrays.asList("fjubadocdwaygs", "x", "a"), Arrays.asList("zezdb", "hyxnrujrqykzhizm"), Arrays.asList("ccwfthnjt", "a"), Arrays.asList("fjubadocdwaygs", "zezdb", "a"), Arrays.asList(), Arrays.asList("peaqbonzgl", "ccwfthnjt", "hyxnrujrqykzhizm"), Arrays.asList("xtadkauiqwravo", "hyxnrujrqykzhizm"), Arrays.asList("peaqbonzgl", "a"), Arrays.asList("x", "a", "hyxnrujrqykzhizm"), Arrays.asList("zshbwqdhx"), Arrays.asList(), Arrays.asList("fjubadocdwaygs", "mf", "pcfpppaxsxtpixd", "zshbwqdhx"), Arrays.asList("pcfpppaxsxtpixd", "a", "zshbwqdhx"), Arrays.asList("peaqbonzgl"), Arrays.asList("peaqbonzgl", "x", "ulqocaijhezwfr"), Arrays.asList("ulqocaijhezwfr"), Arrays.asList("x"), Arrays.asList("fjubadocdwaygs", "peaqbonzgl"), Arrays.asList("fjubadocdwaygs", "xtadkauiqwravo"), Arrays.asList("pcfpppaxsxtpixd", "zshbwqdhx"), Arrays.asList("peaqbonzgl", "brgjopmm", "pcfpppaxsxtpixd", "a"), Arrays.asList("fjubadocdwaygs", "x", "mf", "ulqocaijhezwfr"), Arrays.asList("jmhobexvmmlyyzk", "brgjopmm", "rahimgtlopffbwdg", "hyxnrujrqykzhizm"), Arrays.asList("x", "ccwfthnjt", "hyxnrujrqykzhizm"), Arrays.asList("hyxnrujrqykzhizm"), Arrays.asList("peaqbonzgl", "x", "xtadkauiqwravo", "ulqocaijhezwfr", "hyxnrujrqykzhizm"), Arrays.asList("brgjopmm", "ulqocaijhezwfr", "zshbwqdhx"), Arrays.asList("peaqbonzgl", "pcfpppaxsxtpixd"), Arrays.asList("fjubadocdwaygs", "x", "a", "zshbwqdhx"), Arrays.asList("fjubadocdwaygs", "peaqbonzgl", "x"), Arrays.asList("ccwfthnjt")),
                        6
                }
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int[] result = solution.smallestSufficientTeam(req_skills, people);
        Assert.assertEquals(expected, result.length);

        Set<String> skills = Arrays.stream(req_skills).collect(Collectors.toSet());
        for (int index : result) {
            skills.removeAll(people.get(index));
        }
        Assert.assertTrue(skills.isEmpty());
    }

}