package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task2Test {
    @Test
    public void testClusterize1() {
        String input = "()()()";
        List<String> clusters = Task2.clusterize(input);

        assertEquals(3, clusters.size());
        assertEquals("()", clusters.get(0));
        assertEquals("()", clusters.get(1));
        assertEquals("()", clusters.get(2));
    }

    @Test
    public void testClusterize2() {
        String input = "((()))";
        List<String> clusters = Task2.clusterize(input);

        assertEquals(1, clusters.size());
        assertEquals("((()))", clusters.get(0));
    }

    @Test
    public void testClusterize3() {
        String input = "((()))(())()()(()())";
        List<String> clusters = Task2.clusterize(input);
        assertEquals(5, clusters.size());

        assertEquals("((()))", clusters.get(0));
        assertEquals("(())", clusters.get(1));
        assertEquals("()", clusters.get(2));
        assertEquals("()", clusters.get(3));
        assertEquals("(()())", clusters.get(4));
    }

    @Test
    public void testClusterize4() {
        String input = "((())())(()(()()))";
        List<String> clusters = Task2.clusterize(input);

        assertEquals(2, clusters.size());
        assertEquals("((())())", clusters.get(0));
        assertEquals("(()(()()))", clusters.get(1));
    }
}
