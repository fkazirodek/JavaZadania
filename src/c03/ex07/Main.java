package c03.ex07;

import java.util.ArrayList;
import java.util.Comparator;

class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("a");
        list.add("abcdef");
        list.add("ab");
        list.add("abcde");
        list.add("abcd");

        Sort.luckySort(list, Comparator.comparingInt(String::length));
        System.out.println("Result: Sorted list = " + list);
    }
}
