package edu.hw2.Task1;

sealed interface Expression {
    double evaluate();

     record Constant(double number) implements Expression {
        @Override
        public double evaluate() {
            return number;
        }
    }

    record Negate(Expression expr) implements Expression {
        @Override
        public double evaluate() {
            return -expr.evaluate();
        }
    }

    record Exponent(Expression base, double exponent) implements Expression {
        @Override
        public double evaluate() {
            return Math.pow(base.evaluate(), exponent);
        }
    }

    record Addition(Expression param1, Expression param2) implements Expression {
        @Override
        public double evaluate() {
            return param1.evaluate() + param2.evaluate();
        }
    }

    record Multiplication(Expression param1, Expression param2) implements Expression {
        @Override
        public double evaluate() {
            return param1.evaluate() * param2.evaluate();
        }
    }
}
