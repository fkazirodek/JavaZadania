package c03.ex07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Sort {
    static <T> void luckySort(ArrayList<T> list, Comparator<T> comparator) {
        ArrayList<T> sortedList = list.stream()
                .sorted(comparator)
                .collect(Collectors.toCollection(ArrayList::new));

        do {
            Collections.shuffle(list);
            System.out.println("Sorted list " + sortedList);
            System.out.println("Shuffled list " + list);
        } while (isNotEqual(list, sortedList));

    }

    private static <T> boolean isNotEqual(List<T> list1, List<T> list2) {
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return true;
            }
        }
        return false;
    }
}
