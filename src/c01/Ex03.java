package c01;

import java.util.Scanner;

class Ex03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 3 number");
        int first = Integer.parseInt(sc.nextLine());
        int second = Integer.parseInt(sc.nextLine());
        int third = Integer.parseInt(sc.nextLine());
        sc.close();
        System.out.println(getMaxValue(first, second, third));
        System.out.println(getMaxValue2(first, second, third));
    }

    private static int getMaxValue(int first, int second, int third) {
        int max = first > second ? first : second;
        return max > third ? max : third;
    }

    private static int getMaxValue2(int first, int second, int third) {
        int x = Math.max(first, second);
        return Math.max(x, third);
    }
}
