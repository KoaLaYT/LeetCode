package _20220729_Substr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String a;

    @Parameterized.Parameter(1)
    public String b;

    @Parameterized.Parameter(2)
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"abcdefg", "efg", true},
                {"abcdefg", "def", true},
                {"abcdefg", "cdef", true},
                {"abcdefg", "adef", false},
                {
                        "eabcededeaeeabbbaedbaeedbaeaaebaeeeeceddbaecdbcbdcbabeecddaaaedadaaadabcedcececaecaccddbaceecebbccbedddcedebbbacadddbeccaaaccdbebcdcdaebddbceeeeeebedbbaeedbbcdccededacdcedaecbdebdaedbededcdcdccdbcddabcadbbabbdeeecdabedcccbecbcccacecceedcebacabdeaddaebadacbabeaeaacbbbcebddbedadaddcecebeabbcdbcddcbeaacababaaaaadadacbabbebebbabbccbebcdacedebaeccedeebdadcdddccecdcdaabbcddaecbcebdbaecadecdabebccceececbdbabdbecacabdcadbceaeabadaadadecddadadaddacdcbabadcbccbbceeedddcdaabaebcdddcbcdeaaabccceabddbcbabbabccbbaebdcdcaadebeaeccadaeeeaccacbbceaedcdcccdbcbcdabcecbeeacbeeaaeeeedabbeabdebcedbeeceedbaeedcccdebbccebddacbcedbaddcaccaccecdcaabcddbdccbdabdebeabdbceebecdacadcddeedababeddbbaacdbadcdeddaddbadcbcbcececebecabaeebbbbebdeaaadbaaebabedcdebdbaedccabbdeaddaceaaecbcdddabcccedcddeadcbadedeeedccaceaadecbecacdbeadbcedacddcbcdaeeabddddccdcadbcecebaaaaacbbaedcdcdeadcbebdbbcaeacbebdadeeecdcecaacecdcedaabaebbddabadecbceaddbcdbbedbbaddaacedbedaccaadbbbdbbeadcbcbdacbadbcadaddbaababcdccbdbababecdadbdcabeeeecdcdedcbcbcedbdebcaebcdcbabcedbbcbcabeceddbaccecabbeceaddedabbdaddcacbdcbcccbcacbdaedeaebcababeabceabecdceedeeceedbbdcccbcbaeaeaebaedeccaaccadbbddbecbbebcebbaddebebbaaedecbdbdabeaaaaabbba",
                        "ddbaeaebdcddabbaaaceebbaccdedaecdeccbcbedaacbedacaaceabdddbddbdccaaecddaebaecedaebdbcacdebbdbadcdabaabcddeceaecaabbdccacbbbdbcbbddbacaeacaededdbbbaddcdaadeaeacdbadceaddcbdeadaceaaedbaddbebbdddd",
                        false
                },
                {
                        "daeeeeeeeceabaddeebbebeebaaaddbacdbdccecebecaecbecaeacccccddacbaacedcccbccaebeaddecbbddecebddceaabedcdaddaebdecaaaedeaaadcbdaaaedabddadadceecebbdadeccceebabcbaacabbdacdaeececcceeddedcaabeabaddbbcedadcccbdacbbabcebbddaecdbbddbacdadecccddeedddedeabaabebecaecddeccaeaabecaccccdceabeeaccdeabeaabeaeccbdababbeedbbcadaddabaecaaaceaaacccdeceeecccdebbaeaddddeeedebcbabbbeccdddaedbbbabaccdeaebdcdecbedeecddcedbaaeddbbabaedddacccdcbcadedabecdbaacecbededeabdebbccdcdacdbedaabebbecdabebccbbddeabeeadcbeadedaceedcbccbeddabbecccadebbcdeeddbebabacdcccbeaddbdbceadecebcbceecbaacccbcbebacbadbeaacddabdcebdaebadccbbdcbeeeeddcdabadebecdabaecedccbacebdcaabaabbbcaebebaecbacbbcaadebcbedeebdeadcdbebbeddaeeacdacadcacbdcccbabecebddbedbbdebecbeebdaeadcdcbacaddddabbecacacababdaacbabdbbaeaeebacbbecabaedcbbcedaaadabaadbacddcddddbdbaddacecbdbeedadaaebaedcacaaceaaaddbeabecaeceaabcddceacbcbccbabebcccbbebdbbdccbaaeadebbccdbddacadebcbeeeedacbbacaaaacccdcebaacbddabcdadddcebbccdadadeabcdcadedbcbcecaaeecededbcadccacceddcbcccebcddeaebdabadebdacacdcddecccdbcabbdbddbecdccbdacbcadbecedcaaaeadaecededeeaaabcaedbcbacdcbbecbebcbbebbaaedaeedecdbceddbaeabceaabdcdadbadbdebbbabbbacedbecedbeceacbbeeebdedbdbebaaabdecbbabbbbadcbaeedaaceddbcaecbeedecabbdbbbeacbeeceeadabadebcaeadcddcbceececcaeccdbaebcccdbaeacadaacceedebeaacccaeebeeaccccbdabacedcaeaceebebabeebbcbcbbcedbccecdaceedbeaccaeeedcabacddbadcdcbdcdbdcdaadbabcbcbcbeeeaddcbdaedebbabddcacacebbcdacecceadaaecdcdcacacbdcabdeccccdcdecebabbabcbdecdbdaebec",
                        "acdbedaabebbecdabebccbbddeabeeadcbeadedaceedcbccbeddabbecccadebbcdeeddbebabacdcccbeaddbdbceadecebcbceecbaacccbcbebacbadbeaacddabdcebdaebadccbbdcbeeeeddcdab",
                        true
                }
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.substr(a, b);
        Assert.assertEquals(expected, result);
    }

}