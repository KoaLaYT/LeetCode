package _20220717_CodecTree;

import common.TreeNode;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Base64;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        TreeNode nodeSize = buildNodeSize(root);
        ByteBuffer raw = ByteBuffer.allocate(nodeSize.val * 3 * 4);
        IntBuffer buf = raw.asIntBuffer();
        serialize(root, nodeSize, 0, buf);

        return Base64.getUrlEncoder().encodeToString(raw.array());
    }

    // node type
    // 1 left 0 root 2 right
    private void serialize(TreeNode node, TreeNode nodeSize, int nodeType, IntBuffer buf) {
        if (node == null) {
            return;
        }

        buf.put(nodeSize.val);
        buf.put(nodeType);
        buf.put(node.val);
        serialize(node.left, nodeSize.left, 1, buf);
        serialize(node.right, nodeSize.right, 2, buf);
    }

    private TreeNode buildNodeSize(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode newNode = new TreeNode(1);
        newNode.left = buildNodeSize(node.left);
        newNode.right = buildNodeSize(node.right);

        if (newNode.left != null) {
            newNode.val += newNode.left.val;
        }

        if (newNode.right != null) {
            newNode.val += newNode.right.val;
        }

        return newNode;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isBlank()) {
            return null;
        }

        byte[] raw = Base64.getUrlDecoder().decode(data);
        IntBuffer buf = ByteBuffer.wrap(raw).asIntBuffer();

        int[] preorder = new int[buf.get(0) * 3];
        buf.get(preorder);

        return deserialize(preorder, 0, preorder.length - 3);
    }

    private TreeNode deserialize(int[] preorderWithSize, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        int size = preorderWithSize[lo];
        int val = preorderWithSize[lo + 2];

        TreeNode node = new TreeNode(val);

        int type = lo + 3 <= hi ? preorderWithSize[lo + 4] : 0;
        int leftSize = type == 1 ? preorderWithSize[lo + 3] : 0;
        int rightSize = size - leftSize - 1;
        node.left = deserialize(preorderWithSize, lo + 3, lo + 3 * leftSize);
        node.right = deserialize(preorderWithSize, hi - 3 * (rightSize - 1), hi);

        return node;
    }

}
