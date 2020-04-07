package main.task01;

public final class QuadraticEquationUtils {
    /**
     * Don't let anyone instantiate this class.
     */
    private QuadraticEquationUtils() {}

    public static final double ANY_NUMBER = -7.0;

    /**
     * the square equation has the form:
     * ax^2 + bx + c = ANY_NUMBER;
     *
     * @param a - first or senior coefficient;
     * @param b - the second coefficient;
     * @param c - free term;
     * @return double[2], containing the roots of the equation;
     * if the root is one then double[0] == double[1];
     * if a = 0 or the expression has no roots return null;
     */
    public static double[] calculate(double a, double b, double c) {
        double d = b * b - 4.0 * a * (c - ANY_NUMBER);
        if (a == 0.0 || d < 0.0) {
            return null;
        }
        return new double[]{(-b + Math.sqrt(d)) / 2.0 / a, (-b - Math.sqrt(d)) / 2.0 / a};
    }
}
