package interview;

import java.util.*;

/**
 * Write algorytm that will count how many occurences of different
 * length words are in given string. Same words are counted as one
 * e.g.:
 * "A sailor went to sea, sea, sea
 * To see what he could see, see, see"
 * Output:
 * 1 Letter(s): 1
 * 2 Letter(s): 2
 * 3 Letter(s): 2
 * 4 Letter(s): 2
 * 5 Letter(s): 1
 * 6 Letter(s): 1
 */
public class SecondTaskClass {

    public static void main(String[] args) {
        SecondTaskClass.method("A sailor went to sea, sea, sea\n" +
                " To see what he could see, see, see");
    }

    public static void method(String s) {
        String[] arr = s.toLowerCase().split("\\W+");
        Set<String> words = new TreeSet<>(Arrays.asList(arr));
        List<Integer> list = new ArrayList<>();

        for (String w : words) {
            list.add(w.length());
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : list) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        map.forEach((k, v) -> System.out.println(k + " Letter(s): " + v));
    }
}
