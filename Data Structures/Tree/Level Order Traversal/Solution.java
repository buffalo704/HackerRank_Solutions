// https://www.hackerrank.com/challenges/tree-level-order-traversal/problem

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
    public static void levelOrder(Node root) {
        Deque deque = new LinkedList<Node>();
        deque.add(root);

        while (deque.size() > 0) {
            Node node = (Node) deque.remove();
            System.out.print(node.data + " ");

            if (node.left != null) {
                deque.add(node.left);
            }

            if (node.right != null) {
                deque.add(node.right);
            }
        }
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
        levelOrder(root);
    }
}