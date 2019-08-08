package ru.geekbrains.datastructure.lesson2;

import ru.geekbrains.datastructure.lesson2.array.Array;
import ru.geekbrains.datastructure.lesson2.array.ArrayImpl;
import ru.geekbrains.datastructure.lesson2.array.SortedArrayImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
//        Integer[] array = new Integer[5];
//        Integer[] array = new Integer[] {5, 4, 3, 2, 1};
//        Integer[] array = {5, 4, 3, 2, 1};
//        array[0] = 5;
//        displayArray(array);
//
//        List<String> arrayList = new ArrayList<>(5);

        Array<Integer> array = new ArrayImpl<>(5);
//        Array<Integer> array = new SortedArrayImpl<>();
        array.add(5);
        array.add(2);
        array.add(4);
        array.add(1);
        array.add(3);
        array.add(8);


        array.display();
//        array.sortBubble();
//        array.sortSelect();
        array.sortInsert();
        array.display();

        System.out.println("Remove 3:" + array.remove(Integer.valueOf(3)));
        System.out.println("Remove 333:" + array.remove(Integer.valueOf(333)));

        array.display();

        System.out.println("Find 1: " + array.indexOf(1));
        System.out.println("Find 5: " + array.indexOf(5));
        System.out.println("Find 8: " + array.indexOf(8));
        System.out.println("Find 111: " + array.indexOf(111));


    }

    private static void displayArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println("-----");

        Stream.of(array).forEach(System.out::println);
        System.out.println("-----");

        for (Integer element : array) {
            System.out.println(element);
        }
    }
}
