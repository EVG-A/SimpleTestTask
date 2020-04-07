package main.task01;

public class QuadraticEquation {
    /**
     * the square equation has the form:
     * ax^2 + bx + c = -7;
     *
     * @param a - first or senior coefficient;
     * @param b - the second coefficient;
     * @param c - free term;
     * @return double[2], containing the roots of the equation;
     * if the root is one then double[0] == double[1];
     * if a = 0 or the expression has no roots return null;
     */
    public static double[] calculate(double a, double b, double c) {
        c = c + 7.0;
        double d = b * b - 4 * a * c;
        if (a == 0 || d < 0) {
            return null;
        }
        return new double[]{(-1 * b + Math.sqrt(d)) / 2 / a, (-1 * b - Math.sqrt(d)) / 2 / a};
    }
}
