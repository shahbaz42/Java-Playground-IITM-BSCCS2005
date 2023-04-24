import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.lang.reflect.Array;
import java.util.HashMap;

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

class Person implements Comparable<Person>{
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "Person { id : " + id + ", name : " + name + ", age : " + age + "}";
    }

    @Override
    public int compareTo(Person other){
        return Integer.compare(id, other.id);
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
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
        System.out.println("treeset_animal : " + treeset_animal); 

        // Converting a stream into a map
        System.out.println("\nConverting a stream into a map");
        Person shahbaz = new Person(01, "Shahbaz", 21 );
        Person madhavan = new Person(2, "Madhavan", 35);
        Person keshav = new Person(3, "Keshavan", 23);
        Stream<Person> stream8 = Stream.of(shahbaz, madhavan, keshav);
        Map<Integer, String> idToString = stream8.collect(Collectors.toMap(
            Person::getId, 
            Person::getName
        ));
        System.out.println(idToString);

        // Converting a stream into a map and storing the whole object
        System.out.println("\nConverting a stream into a map and keeping the whole object as a value.");
        Stream<Person> stream9 = Stream.of(shahbaz, madhavan, keshav);
        Map<Integer, Person> idToPerson = stream9.collect(Collectors.toMap(
            Person::getId,
            Function.identity()
        ));
        System.out.println(idToPerson);

        // handling duplicate keys 
        System.out.println("\nHandling duplicate keys by discarding the value of old key");
        Stream<Person> stream10 = Stream.of(shahbaz, madhavan, keshav, shahbaz);
        Map<Integer, String> idToString2 = new HashMap<>();
        idToString2 = stream10.collect(Collectors.toMap(
            Person::getId,
            Person::getName,
            (oldName, newName) -> { return newName; }

        ));
        System.out.println(idToString2);

        // collecting stream into map handling duplicate keys
        System.out.println("\n Handling duplicate keys by merging the values.");
        Person anup = new Person(04, "Anup", 21);
        Person venketesh = new Person(05, "Venketesh", 21 );
        Stream<Person> stream11 = Stream.of(shahbaz, anup, venketesh, madhavan, keshav);
        Map<Integer, String> ageToPerson = new HashMap<>();
        ageToPerson = stream11.collect(Collectors.toMap(
            Person::getAge,
            Person::getName, 
            (oldName, newName) -> oldName + "; " + newName 
        ));
        System.out.println(ageToPerson);

        // Grouping values of a stream using Collectors.groupingBy()
        System.out.println("\nGrouping values using Collectors.groupingBy() ");
        Stream<Person> stream12 = Stream.of(shahbaz, anup, madhavan, venketesh, keshav);
        Map<Integer, List<Person>> groupByAge = stream12.collect(Collectors.groupingBy(
            Person::getAge
        ));
        System.out.println(groupByAge);

        // Partitioning values using Collectors.partioningBy()
        // partitionBy returns a Map<Boolean, List>
        System.out.println("\nPartitioning values using Collectors.partioningBy()");
        Stream<Person> stream13 = Stream.of(shahbaz, anup, venketesh, madhavan, keshav);
        Map<Boolean, List<Person>> agePartition = new HashMap<Boolean,List<Person>>();
            agePartition = stream13.collect(Collectors.partitioningBy( p -> p.getAge() > 25
        ));
        System.out.println("People with age > 25 :");
        for (Person p : agePartition.get(true)) {
            System.out.println(p);
        }
        System.out.println("People with age < 25 :");
        for (Person p : agePartition.get(false)) {
            System.out.println(p);
        }
    }
}
