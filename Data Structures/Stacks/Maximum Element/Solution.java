// https://www.hackerrank.com/challenges/maximum-element/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Deque<Integer> mainStack = new LinkedList<>();
        Deque<Integer> trackStack = new LinkedList<>();

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        while (t-- >= 0) {
            String line = scan.nextLine();
            String[] nm = line.split(" ");

            int command = (nm[0].equals("")) ? 0 : Integer.parseInt(nm[0]);

            switch (command) {
                case 1:
                    int insertValue = Integer.parseInt(nm[1]);
                    if (mainStack.size() == 0) {
                        trackStack.push(insertValue);
                    } else {
                        int trackStackValue = (Integer) trackStack.peek();
                        int largerValue = trackStackValue < insertValue
                                ? insertValue : trackStackValue;
                        trackStack.push(largerValue);
                    }
                    mainStack.push(insertValue);
                    break;
                case 2:
                    mainStack.pop();
                    trackStack.pop();
                    break;
                case 3:
                    int trackStackValue = (Integer) trackStack.peek();
                    System.out.println(trackStackValue);
                    break;
            }
        }

        scan.close();
    }
}