package streams;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamExercises {
    final int[] array = {1, 3 , 4, 5, 6, 1, 2, 0, 0, -1};
    List<Integer> list;

    StreamExercises() {
        list = IntStream.of(array)
                .boxed()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        StreamExercises main = new StreamExercises();

        main.print(main.firstWithAverage());
        main.print(main.firstWithoutAverage());
        main.print(main.countZeroElements());
        main.print(main.countElementBiggerZero());
        main.print(main.multiplyElements(2));
    }

    Double firstWithAverage() {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

    Double firstWithoutAverage() {
        return (double) list.stream()
                .reduce(0, Integer::sum) / list.size();
    }

    Long countZeroElements() {
        return list.stream()
                .filter(x -> x.equals(0))
                .count();
    }

    Long countElementBiggerZero() {
        return list.stream()
                .filter(x -> x > 0)
                .count();
    }

    List<Integer> multiplyElements(int multiplier) {
        return list.stream()
                .map(x -> x * multiplier)
                .collect(Collectors.toList());
    }

    void print(Object value) {
        System.out.println(value.toString());
    }
}
