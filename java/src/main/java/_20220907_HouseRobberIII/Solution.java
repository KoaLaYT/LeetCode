package _20220907_HouseRobberIII;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int rob(TreeNode root) {
    Map<TreeNode, Integer> memoRobThis = new HashMap<>();
    Map<TreeNode, Integer> memoNotRobThis = new HashMap<>();
    return rob(root, memoRobThis, memoNotRobThis);
  }

  private int rob(TreeNode node, Map<TreeNode, Integer> memoRobThis, Map<TreeNode, Integer> memoNotRobThis) {
    if (node == null) {
      return 0;
    }

    return Math.max(rob(node, true, memoRobThis, memoNotRobThis),
        rob(node, false, memoRobThis, memoNotRobThis));
  }

  private int rob(
      TreeNode node,
      boolean robThis,
      Map<TreeNode, Integer> memoRobThis,
      Map<TreeNode, Integer> memoNotRobThis
  ) {
    if (node == null) {
      return 0;
    }

    if (robThis && memoRobThis.containsKey(node)) {
      return memoRobThis.get(node);
    }

    if (!robThis && memoNotRobThis.containsKey(node)) {
      return memoNotRobThis.get(node);
    }

    int val = 0;
    if (robThis) {
      val = node.val
          + rob(node.left, false, memoRobThis, memoNotRobThis)
          + rob(node.right, false, memoRobThis, memoNotRobThis);
      memoRobThis.put(node, val);
    } else {
      val = rob(node.left, memoRobThis, memoNotRobThis) + rob(node.right, memoRobThis, memoNotRobThis);
      memoNotRobThis.put(node, val);
    }

    return val;
  }

}
