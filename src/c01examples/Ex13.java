package c01examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class Ex13 {

    public static void main(String[] args) {
        System.out.println(getSixRandomNumbers(1, 46));
    }

    static List<Integer> getSixRandomNumbers(int from, int to) {
        List<Integer> numbers = getFilledArray(from, to);
        List<Integer> selectedNumbers = new ArrayList<>();

        Random random = new Random();
        do {
            int randomNum = random.nextInt(from, to);
            if (!selectedNumbers.contains(randomNum)) {
                selectedNumbers.add(randomNum);
            }
            numbers.removeIf(n -> n == randomNum);
        } while (selectedNumbers.size() != 6);

        return selectedNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    static List<Integer> getFilledArray(int from, int to) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = from; i < to; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}

