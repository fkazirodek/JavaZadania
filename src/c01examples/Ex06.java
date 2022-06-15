package c01examples;

import java.math.BigInteger;

class Ex06 {

    public static void main(String[] args) {
        System.out.println("Loop:");
        System.out.println(getFactorial(100));
        System.out.println(getFactorial(1000));

        System.out.println("Recursion:");
        System.out.println(getFactorialRecursion(100));
        System.out.println(getFactorialRecursion(1000));
    }

    private static BigInteger getFactorial(int from) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= from; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    private static BigInteger getFactorialRecursion(int from) {
        if (from == 0) return BigInteger.ONE;
        return BigInteger.valueOf(from).multiply(getFactorialRecursion(from - 1));
    }
}
