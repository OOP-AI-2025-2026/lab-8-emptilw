package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;

public class GenericFilter {
    public static <T> T[] filter(T[] input, Predicate<T> predicate) {
        T[] result = (T[]) new Object[input.length];
        int count = 0;
        for (T item : input) {
            if (predicate.test(item)) {
                result[count++] = item;
            }
        }
        return Arrays.copyOf(result, count); // обрізаємо масив до потрібної довжини
    }
}


