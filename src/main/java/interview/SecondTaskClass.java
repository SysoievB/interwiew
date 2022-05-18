package interview;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static void methodWithoutStream(String s) {
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

    public static void method(String s) {
        String[] arr = s.toLowerCase().split("\\W+");

        List<Integer> words = Arrays.stream(arr)
                .distinct()
                .map(String::length)
                .collect(
                        Collectors.toCollection(ArrayList::new)
                );

        List<Integer> intSequence = IntStream
                .rangeClosed(1, words.size())
                .boxed()
                .collect(
                        Collectors.toCollection(ArrayList::new)
                );

        Map<Integer, Integer> map = IntStream.range(0, intSequence.size())
                .distinct()
                .collect(
                        TreeMap::new,
                        (m, i) -> m.put(intSequence.get(i), words.get(i)),
                        Map::putAll);

        map.forEach((k, v) -> System.out.println(k + " Letter(s): " + v));
    }
}
