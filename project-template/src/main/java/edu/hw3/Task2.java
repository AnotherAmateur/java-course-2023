package edu.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Task2 {
    public static List<String> clusterize(String input) {
        var clustersRes = new ArrayList<String>();
        var stack = new Stack<Integer>();

        int clusterBegin = 0;
        for (int i = 0; i < input.length(); ++i) {
            if (input.charAt(i) == '(') {
                stack.push(i);
            } else if (input.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        clustersRes.add(input.substring(clusterBegin, i + 1));
                        clusterBegin = i + 1;
                    }
                } else {
                    clusterBegin = i + 1;
                }
            }
        }

        return clustersRes;
    }
}
