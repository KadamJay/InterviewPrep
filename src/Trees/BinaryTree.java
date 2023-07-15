package Trees;

/**
 * @author jakadam on 2019-12-20
 */

public class BinaryTree {
  TreeNode root;

  public BinaryTree() {
    root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
    root.left.right = new TreeNode(4);
    root.left.left = new TreeNode(3);
  }

  public TreeNode getRoot() {
    return root;
  }
}

/*
 * 1
 * / \
 * 2 5
 * / \ / \
 * 3 4 null null
 * / \ \
 * null null null
 */