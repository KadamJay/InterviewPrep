package Trees;

public class NaryInorder {
    static class Node {
        int data;
        Node children[];

        Node(int n, int data) {
            children = new Node[n];
            this.data = data;
        }
    }

    static void inorder(Node node) {
        if (node == null)
            return;

        int total = node.children.length;
        for (int i = 0; i < total - 1; i++)
            inorder(node.children[i]);

        System.out.print("" + node.data + " ");

        inorder(node.children[total - 1]);
    }

    public static void main(String[] args) {
        int n = 3;
        Node root = new Node(n, 1);
        root.children[0] = new Node(n, 2);
        root.children[1] = new Node(n, 3);
        root.children[2] = new Node(n, 4);
        root.children[0].children[0] = new Node(n, 5);
        root.children[0].children[1] = new Node(n, 6);
        root.children[0].children[2] = new Node(n, 7);

        inorder(root);
    }
}
