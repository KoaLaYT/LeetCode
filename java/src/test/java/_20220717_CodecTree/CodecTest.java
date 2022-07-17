package _20220717_CodecTree;

import common.TreeNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tools.Utils;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class CodecTest {

    private Codec codec;

    @Parameterized.Parameter
    public List<Integer> input;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {Arrays.asList(12, 11, 13)},
                {Arrays.asList(2, 1, 3)},
                {Arrays.asList(1, 1, 2, 1, 1, null, null, null, null, 1)},
                {Arrays.asList(1, null, 2)}
        };
    }

    @Before
    public void setup() {
        codec = new Codec();
    }

    @Test
    public void test() {
        TreeNode root = Utils.buildTree(input);
        String serialized = codec.serialize(root);
        TreeNode deserialized = codec.deserialize(serialized);
        Utils.assertTreeEquals(root, deserialized);
    }

}