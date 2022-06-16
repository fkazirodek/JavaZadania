package c01;

import java.util.Random;

class Ex07 {

    public static void main(String[] args) {

        Random random = new Random();
        short a = (short) random.ints(0, 65535).filter(i -> i > 0).findAny().getAsInt();
        short b = (short) random.ints(0, 65535).filter(i -> i > 0).findAny().getAsInt();
        System.out.println("a = " + a + ",b = " + b);


        short sum = (short) (a + b);
        System.out.println("sum = " + sum);
    }
}
