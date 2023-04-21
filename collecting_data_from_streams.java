import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Animal implements Comparable<Animal>{
    private String name;
    private String type;

    public Animal(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String toString(){
        return "Animal Name : " + name + " Animal Type : " + type ;
    }

    // Without overloading compareTo() when creating a treeset from stream 
    // It'll throw ClassCastException
    // Treeset requires its elements to be comparable.
    @Override
    public int compareTo(Animal other){
        return name.compareTo(other.name);
    }
}

public class collecting_data_from_streams {
    public static void main(String[] args) {
        // Below objects are to be uses as examples
        Animal cat = new Animal("Cat", "Mammel");
        Animal lizard = new Animal("Lizard",  "Reptile");
        Animal falcon = new Animal("Falcon", "Bird");
        Animal dog = new Animal("Dog", "Mammel");

        // 1. stream.forEach()
        System.out.println("\n1. stream.forEach()");
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5);
        stream1.forEach(System.out::println);

        // 2. stream.toArray()
        System.out.println("\n2. stream.toArray()");
        Stream<Integer> stream2 = Stream.of(1,2,3,4,5);
        Object[] arr_stream2 = stream2.toArray();
        for(Object i : arr_stream2 ){
            System.out.println("Integer value : " + i + " Class : " + i.getClass().getName());
        }

        // we can pass on a constructor reference to the toArray() method
        System.out.println("\nwe can pass on a constructor reference to the toArray() method");
        Stream<String> stream3 = Stream.of("Monkey", "Cat", "Mongoose");
        String[] arr_stream3 = stream3.toArray(String[]::new);
        for(String animal : arr_stream3){
            System.out.println("Name of animal : " + animal + " Class : " +animal.getClass().getName());
        }

        // 3. stream.collect()
        // We can use stream.collect() with Collectors class to collect data from stream.
        System.out.println("\n 3. stream.collect()");
        System.out.println("We can use stream.collect() with Collectors class to collect data from stream.");
        Stream<Animal> stream4 = Stream.of(cat, lizard, falcon);
        List<Animal> list_animal_from_stream4 = stream4.collect(Collectors.toList());
        System.out.println("List of animals : " + list_animal_from_stream4);
        // pushing another animal to the list .push()
        list_animal_from_stream4.add(dog);
        System.out.println("List after adding dog animal " + list_animal_from_stream4);
        // popping the last animal from the list .pop()
        list_animal_from_stream4.remove(dog);
        System.out.println("List after removing dog animal " + list_animal_from_stream4 );
        // finding the size of the list .size()
        System.out.println("Size of the List " + list_animal_from_stream4.size());
        // finding the index of an animal in the list .indexOf()
        System.out.println("Index of cat in the animal list : " + list_animal_from_stream4.indexOf(cat));
        // finding the index of the last occurence of an animal cat in the list .lastIndexOf()
        list_animal_from_stream4.add(cat);
        list_animal_from_stream4.add(dog);
        System.out.println("Last index of cat in the list : " + list_animal_from_stream4.lastIndexOf(cat));

        // converting a stream into a set
        System.out.println("\nCollect a stream into a set. ");
        Stream<Animal> stream5 = Stream.of(cat, dog, lizard, cat, cat, falcon);
        Set<Animal> set_animal_from_stream5 = stream5.collect(Collectors.toSet());
        // Duplicate of cat will be removed.
        System.out.println("Set from stream5 : " + set_animal_from_stream5);

        // Collecting a stream into a treeset
        System.out.println("\nCollecting a stream into a treeset.");
        Stream<String> stream6 = Stream.of("Monkey", "Zebra", "Dog", "Mongoose");
        TreeSet<String> treeset_from_stream6 = stream6.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(treeset_from_stream6);

        // Collecting a stream of type Animal into a treeset
        System.out.println("\nCollecting a stream of type Animal into a TreeSet");
        Stream<Animal> stream7 = Stream.of(cat, dog, falcon, lizard);
        TreeSet<Animal> treeset_animal = stream7.collect(Collectors.toCollection(TreeSet::new));
        System.out.println("treeset_animal" + treeset_animal); 

    }
}
