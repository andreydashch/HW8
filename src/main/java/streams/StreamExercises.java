package streams;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamExercises {
    final int[] array = {1, 3 , 4, 5, 6, 1, 2};
    List<Integer> list;

    StreamExercises() {
        list = IntStream.of(array)
                .boxed()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        StreamExercises main = new StreamExercises();

        main.print(main.firstWithAverage().toString());
        main.print(main.firstWithoutAverage().toString());
    }

    Double firstWithAverage() {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

    Double firstWithoutAverage() {
        return list.stream()
                .mapToDouble(x -> x)
                .reduce(0.0, Double::sum) / list.size();
    }

    void print(String text) {
        System.out.println(text);
    }
}
