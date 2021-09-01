package _20210901_BinarySearchTreeIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author koalayt 2021-09-01
 */
public class BSTIterator {

    private final List<Integer> values;
    private int index;

    public BSTIterator(TreeNode root) {
        values = new ArrayList<>();
        index = 0;
        inOrder(root);
    }

    private void inOrder(TreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        inOrder(node.left);
        values.add(node.val);
        inOrder(node.right);
    }

    public int next() {
        return values.get(index++);
    }

    public boolean hasNext() {
        return index < values.size();
    }

}
