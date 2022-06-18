package c02.ex10;

import java.util.Collections;
import java.util.List;
import java.util.Random;

class RandomNumbers {

    private static Random random = new Random();

    public static int randomElement(List<Integer> array) {
        Collections.shuffle(array);
        return array.isEmpty() ? 0 : array.get(0);
        //return array.isEmpty() ? 0 : array.get(random.nextInt(array.size()));
    }

    public static int randomElement(int[] array) {
        return array.length == 0 ? 0 : array[random.nextInt(array.length)];
    }

}

