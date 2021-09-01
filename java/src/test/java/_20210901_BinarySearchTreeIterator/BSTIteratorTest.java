package _20210901_BinarySearchTreeIterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author koalayt 2021-09-01
 */
public class BSTIteratorTest {

    @Test
    public void test() {
        TreeNode root = buildTree(Arrays.asList(7, 3, 15, null, null, 9, 20));
        BSTIterator bSTIterator = new BSTIterator(root);

        Assert.assertEquals(3, bSTIterator.next());
        Assert.assertEquals(7, bSTIterator.next());
        Assert.assertTrue(bSTIterator.hasNext());
        Assert.assertEquals(9, bSTIterator.next());
        Assert.assertTrue(bSTIterator.hasNext());
        Assert.assertEquals(15, bSTIterator.next());
        Assert.assertTrue(bSTIterator.hasNext());
        Assert.assertEquals(20, bSTIterator.next());
        Assert.assertFalse(bSTIterator.hasNext());
    }

    private TreeNode buildTree(List<Integer> inputs) {
        return buildTree(inputs, 0);
    }

    private TreeNode buildTree(List<Integer> inputs, int i) {
        if (i >= inputs.size() || Objects.isNull(inputs.get(i))) {
            return null;
        }
        TreeNode node = new TreeNode(inputs.get(i));
        node.left = buildTree(inputs, 2 * i + 1);
        node.right = buildTree(inputs, 2 * i + 2);
        return node;
    }

}