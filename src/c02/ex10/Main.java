package c02.ex10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        int[] numbersArray = new int[100];

        IntStream.rangeClosed(1, 100).forEach(numbers::add);
        IntStream.range(0, 100).forEach(i -> numbersArray[i] = i + 1);

        System.out.println(RandomNumbers.randomElement(numbers));
        System.out.println(RandomNumbers.randomElement(numbersArray));
    }
}
