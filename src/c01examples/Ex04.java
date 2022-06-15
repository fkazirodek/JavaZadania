package c01examples;

class Ex04 {

    public static void main(String[] args) {
        double[] numbers = {2.4, 1.8, 1.3, 2.549, 3.14, 5.597, 5.59};
        System.out.println("min = " + minValue(numbers));
        System.out.println("max = " + maxValue(numbers));
    }


    public static double minValue(double[] numbers) {
        double min = Math.nextUp(numbers[0]);
        for (double d : numbers) {
            d = Math.nextUp(d);
            if (d < min) {
                min = d;
            }
        }
        return min;
    }

    public static double maxValue(double[] numbers) {
        double max = Math.nextUp(numbers[0]);
        for (double d : numbers) {
            d = Math.nextUp(d);
            if (d > max) {
                max = d;
            }
        }
        return max;
    }
}
