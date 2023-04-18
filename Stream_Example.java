import java.util.*;
import java.util.stream.*;

public class Stream_Example {
    public static void main(String[] args) {
        System.out.println("Stream generation from a collection");
        // Stream generation from a collection
        List<String> list = new ArrayList<>();
        list.add("Monkey");
        list.add("Lion");
        list.add("Giraffe");
        list.add("Lemur");
        
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);

        // Stream generation from an array
        System.out.println("Stream generation from an array");
        String[] arr = {"Monkey", "Lion", "Giraffe", "Lemur"};
        Stream<String> stream2 = Arrays.stream(arr);
        stream2.forEach(System.out::println);

        // Stream generation from a Stream.of() method
        System.out.println("Stream generation from a Stream.of() method");
        Stream<String> stream3 = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");
        stream3.forEach(System.out::println);

        // Stream generation from a Stream.iterate() method
        System.out.println("Stream generation from a Stream.iterate() method");
        Stream<Integer> stream4 = Stream.iterate(1, x -> x+1);
        stream4
            .limit(10)
            .forEach(System.out::println);

        // Stream generation from a Stream.generate() method
        System.out.println("Stream generation from a Stream.generate() method");
        Stream<Double> stream5 = Stream.generate(Math::random);
        stream5
            .limit(10)
            .forEach(System.out::println);

        // Stream generation from a String.chars() method
        System.out.println("Stream generation from a String.chars() method");
        IntStream stream6 = "Monkey".chars();   
        stream6.forEach(System.out::println);

        // Stream generation from a String.codePoints() method
        // This method is used to generate a stream of Unicode code points
        System.out.println("Stream generation from a String.codePoints() method");
        IntStream stream7 = "Monkey".codePoints();
        stream7.forEach(System.out::println);

        // Stream.filter()
        System.out.println("Stream.filter()");
        Stream<String> stream8 = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");
        stream8
            .filter(x -> x.startsWith("L"))
            .forEach(System.out::println);

        // Stream.map()
        System.out.println("Stream.map()");
        Stream<String> stream9 = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");
        stream9
            .map(String::toUpperCase)
            .forEach(System.out::println);

        // Stream.sorted()
        System.out.println("Stream.sorted()");
        Stream<String> stream10 = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");
        stream10
            .sorted()
            .forEach(System.out::println);

        // Stream.distinct()
        System.out.println("Stream.distinct()");
        Stream<String> stream11 = Stream.of("Monkey", "Lion", "Giraffe", "Lemur", "Lion");
        stream11
            .distinct()
            .forEach(System.out::println);

        // Stream.limit()
        System.out.println("Stream.limit()");
        Stream<String> stream12 = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");
        stream12
            .limit(2)
            .forEach(System.out::println);

        // Stream.skip()
        System.out.println("Stream.skip()");
        Stream<String> stream13 = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");
        stream13
            .skip(2)
            .forEach(System.out::println);

        // Stream.count()
        System.out.println("Stream.count()");
        Stream<String> stream14 = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");
        System.out.println(stream14.count());

        // Stream.collect()
        System.out.println("Stream.collect()");
        Stream<String> stream15 = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");
        List<String> list2 = stream15.collect(Collectors.toList());
        System.out.println(list2);

        // Stream.reduce()
        System.out.println("Stream.reduce()");
        Stream<Integer> stream16 = Stream.of(1, 2, 3, 4, 5);
        System.out.println(stream16.reduce(0, (x, y) -> x + y));

        // Stream.min()
        System.out.println("Stream.min()");
        Stream<Integer> stream17 = Stream.of(1, 2, 3, 4, 5);
        System.out.println(stream17.min((x, y) -> x - y));

        // Stream.max()
        System.out.println("Stream.max()");
        Stream<Integer> stream18 = Stream.of(1, 2, 3, 4, 5);
        System.out.println(stream18.max((x, y) -> x - y));

        // Handling infinite streams
        System.out.println("Handling infinite streams");
        Stream<Double> stream19 = Stream.generate(Math::random);
        stream19
            .limit(10)
            .forEach(System.out::println);

        // Handling Optional values
        System.out.println("Handling Optional values");
        Stream<String> stream20 = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");
        Optional<String> opt = stream20.findFirst();
        if (opt.isPresent()) {
            System.out.println(opt.get());
        }

        // Handling Optional values
        System.out.println("Handling Optional values");
        Stream<Double> stream21 = Stream.generate(Math::random);
        stream21
            .limit(10)
            .map(x -> x * 100)
            .map(x -> (int) Math.round(x))
            .filter( x-> x > 50)
            .forEach(System.out::println);

        // Handling Optional values
        System.out.println("Handling Optional values");
        Optional<Integer> stream22 = Stream.of(1,2,3,4,5)
            .filter(x -> x > 10)
            .findFirst();
        if (stream22.isPresent()) 
            System.out.println(stream22.get());
        else
            System.out.println("No value found");
            
    }
}