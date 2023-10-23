package edu.hw2.Task1;

sealed interface Expression {
    double evaluate();

    public record Constant(double number) implements Expression {
        @Override
        public double evaluate() {
            return number;
        }
    }

    public record Negate(Expression expr) implements Expression {
        @Override
        public double evaluate() {
            return -expr.evaluate();
        }
    }

    public record Exponent(Expression base, double exponent) implements Expression {
        @Override
        public double evaluate() {
            return Math.pow(base.evaluate(), exponent);
        }
    }

    public record Addition(Expression param1, Expression param2) implements Expression {
        @Override
        public double evaluate() {
            return param1.evaluate() + param2.evaluate();
        }
    }

    public record Multiplication(Expression param1, Expression param2) implements Expression {
        @Override
        public double evaluate() {
            return param1.evaluate() * param2.evaluate();
        }
    }
}
