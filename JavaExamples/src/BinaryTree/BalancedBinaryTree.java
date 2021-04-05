package BinaryTree;
/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * */

public class BalancedBinaryTree {
    TreeNode root;
    public boolean isBalanced(TreeNode root) {

        if(root == null) {
            return true;
        }
        int height = getHeight(root);
        int balance = getBalance(root);
        if(balance > 1 || balance < -1) {
            return false;
        } else {
            isBalanced(root.left);
            isBalanced(root.right);
        }
        return true;
    }
    static int getBalance(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return getHeight(root.left) - getHeight(root.right);
    }

    static int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void main(String[] args) {
        BalancedBinaryTree bbt = new BalancedBinaryTree();
        bbt.root = new TreeNode(1);
        bbt.root.left = new TreeNode(2);
        bbt.root.right = new TreeNode(2);
        bbt.root.left.left = new TreeNode(3);
        bbt.root.left.right = new TreeNode(3);
        bbt.root.left.left.left = new TreeNode(4);
        bbt.root.left.left.right = new TreeNode(4);

        boolean result = bbt.isBalanced(bbt.root);
        System.out.println(result);

    }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
