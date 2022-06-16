package c01;

class Ex16 {

    public static void main(String[] args) {
        double average = average(2, 3.14, 4.5);
        System.out.println(average);
    }

    public static double average(double first, double... values) {
        double sum = first;
        for (double d : values) {
            sum += d;
        }
        return sum / values.length + 1;
    }
}
