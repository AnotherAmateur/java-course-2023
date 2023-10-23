package edu.hw2.task1;

import org.junit.jupiter.api.Test;
import edu.hw2.task1.Expression.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionTest {
    private final double eps = 1e-5;

    @Test
    public void testConstant() {
        double testNumber = 124;

        Constant constant = new Constant(testNumber);
        assertEquals(testNumber, constant.evaluate(), eps);
    }

    @Test
    public void testNegate() {
        double testNumber = 124;

        Constant constant = new Constant(testNumber);
        Negate negate = new Negate(constant);
        assertEquals(-testNumber, negate.evaluate(), eps);
    }

    @Test
    public void testExponent() {
        double testBase = 124;
        double testExponent = 124;

        Constant base = new Constant(testBase);
        Exponent exponent = new Exponent(base, testExponent);
        assertEquals(Math.pow(testBase, testExponent), exponent.evaluate(), eps);
    }

    @Test
    public void testAddition() {
        double testConst1 = 124;
        double testConst2 = 1;

        Constant const1 = new Constant(testConst1);
        Constant const2 = new Constant(testConst2);
        Addition addition = new Addition(const1, const2);
        assertEquals(testConst1 + testConst2, addition.evaluate(), eps);
    }

    @Test
    public void testMultiplication() {
        double testConst1 = 124;
        double testConst2 = 3;

        Constant const1 = new Constant(testConst1);
        Constant const2 = new Constant(testConst2);
        Multiplication multiplication = new Multiplication(const1, const2);
        assertEquals(testConst1 * testConst2, multiplication.evaluate(), eps);
    }

    @Test
    public void testCombination() {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));

        assertEquals(37, res.evaluate(), eps);
    }
}
