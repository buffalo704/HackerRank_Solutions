// https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    /*
    class Node
    	int data;
    	Node left;
    	Node right;
	*/
    public static int height(Node root) {
        // Write your code here.
        Node currentNode = root;
        Stack st = new Stack();
        Deque deque = new ArrayDeque<Node>();
        int count = 0;

        Node zeroNode = new Node(0);

        deque.add(root);
        deque.add(zeroNode);
        //System.out.println(root.data);
        //System.out.println(root.left.data);
        //System.out.println(root.right.data);
        //System.out.println(deque.size());

        while (deque.size() > 1) {
            Node node = (Node) deque.removeFirst();
            if (node.left != null) {
                deque.add(node.left);
            }

            if (node.right != null) {
                deque.add(node.right);
            }

            if (node.data == 0) {
                count++;
                deque.add(zeroNode);
            }
        }

        return count;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}