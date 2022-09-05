package _20220905_VerifyPreorderSerializationOfABinaryTree;

import java.util.Objects;

public class Solution {

    public boolean isValidSerialization(String preorder) {
        String[] order = preorder.split(",");
        int size = getSize(order, 0);
        return size == order.length;
    }

    private int getSize(String[] preorder, int index) {
        if (index > preorder.length) {
            return -1;
        }

        if (index == preorder.length) {
            return 0;
        }

        if (Objects.equals(preorder[index], "#")) {
            return 1;
        }

        int left = getSize(preorder, index + 1);
        if (left <= 0) {
            return -1;
        }

        int right = getSize(preorder, index + 1 + left);
        if (right <= 0) {
            return -1;
        }

        return 1 + left + right;
    }

}
