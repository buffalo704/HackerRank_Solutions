// https://www.hackerrank.com/challenges/equal-stacks/problem

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

class Node {
    public int data;
    public int sum;

    public Node(int data, int sum) {
        this.data = data;
        this.sum= sum;
    }

    public int getData() {
        return this.data;
    }

    public int getSum() {
        return this.sum;
    }
}
public class Solution {

    /*
     * Complete the equalStacks function below.
     */
    static Deque loadDeque(int[] h) {
        Deque<Node> deque = new LinkedList<>();
        int sum = 0;

        for (int i= h.length -1; i>=0; i--){
            int data = h[i];
            sum+=h[i];
            deque.push(new Node(data, sum));
            System.out.print(sum + " ");
        }
        System.out.println("");
        return deque;
    }


    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */

        Deque<Node> deque1 = new LinkedList<>();
        Deque<Node> deque2 = new LinkedList<>();
        Deque<Node> deque3 = new LinkedList<>();

        deque1 = loadDeque(h1);
        deque2 = loadDeque(h2);
        deque3 = loadDeque(h3);

        while(!deque1.isEmpty() && !deque2.isEmpty() && !deque3.isEmpty()){
            if ((deque1.peek().getSum() == deque2.peek().getSum()
                    && deque2.peek().getSum() == deque3.peek().getSum())) {
                return deque1.peek().sum;
            }

            if (deque1.peek().getSum() > deque2.peek().getSum()) {
                deque1.pop();
            }

            if (deque2.peek().getSum() > deque3.peek().getSum()) {
                deque2.pop();
            }

            if (deque3.peek().getSum() > deque1.peek().getSum()) {
                deque3.pop();
            }

        }

        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

//        int[] h1 = new int[]{1,1,1,1,2};
//        int[] h2 = new int[]{3,7};
//        int[] h3 = new int[]{1,3,1};

//        int[] h1 = new int[]{3,2,1,1,1};
//        int[] h2 = new int[]{4,3,2};
//        int[] h3 = new int[]{1,1,4,1};

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
