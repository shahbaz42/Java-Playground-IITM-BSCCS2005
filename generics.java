import java.util.*;

class Fruit{
    private String name;
    private int price;

    public Fruit(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String toString(){
        return "Fruit { name : " + name + ", price : " + price + " }";
    }
}

class Person{
    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}

// Generic types
class Basket{
    private Fruit fruit;

    public Basket(Fruit fruit){
        this.fruit = fruit;
    }

    public void set(Fruit fruit){
        this.fruit = fruit;
    }

    public Fruit get(){
        return fruit;
    }
}

class GenericBasket<T>{
    private T item;

    public GenericBasket(T item){
        this.item = item;
    }

    public void set(T item){
        this.item = item;
    }

    public T get(){
        return item;
    }
}

// Multiple Type parameters
interface Pair<K,V>{
    public K getKey();
    public V getValue();
}

class OrderedPair<A,B> implements Pair<A,B>{
    A key;
    B value;

    public OrderedPair(A k, B v){ 
        this.key = k;
        this.value = v;
    }

    public A getKey(){
        return key;
    }

    public B getValue(){
        return value;
    }
}

// Generic Methods
class Util{
    public static <K,V> boolean comapare(Pair<K,V> p1, Pair<K,V> p2){
        return p1.getKey() == p2.getKey() && p1.getValue() == p2.getValue();
    }
}

// Bounded Type parameters
class NaturalNumber<T extends Integer>{
    private T n;
    
    public NaturalNumber(T n){
        this.n = n;
    }

    public boolean isEven(){
        if (n.intValue() % 2 == 0){
            return true;
        }
        return false;
    }
}

// generic methods and bounded type parameters
interface Comparable<T>{
    public boolean compareTo(T o);
}

class ArrayUtils{
    public static <T extends Comparable<T>> int countGreaterThan(T[] arr, T elem){
        int count = 0;
        for( T e : arr)
            if(e.compareTo(elem))
                count++;
        return count;
    }
}

class Car implements Comparable<Car>{
    String name;
    int maxSpeed;

    public Car(String name, int maxSpeed){
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public boolean compareTo(Car o){
        if(this.maxSpeed > o.maxSpeed)
            return true;
        return false;
    }
}



public class generics {
    public static void main(String[] args){
        System.out.println("Java Generics");
        // Java generics is used to create classes and methods that can work with any type.
        // Generics enables stronger checks at the compile time thus prevents a lot of bugs.
        // It allows the compiler to know that you are using the same type in all places.
        // A generic type is a generic class or an interface that is paramererized over types.

        List l1 = new ArrayList();
        l1.add("Hello");
        String s = (String) l1.get(0); // Need to cast string
        System.out.println("l1.get(0) : " + s);

        // Using generics above code can be written as :

        List<String> l2 = new ArrayList<String>(); // error is because T is not defined
        l2.add("Hello");
        String s2 = l2.get(0); // No need to cast string
        System.out.println("l2.get(0) : " + s2);

        Fruit f1 = new Fruit("Apple", 10);
        Person p1 = new Person("Shahbaz", 22);

        Basket b1 = new Basket(f1);
        // Basket b2 = new Basket(p1); // Error because Basket is not generic
        GenericBasket<Person> b2 = new GenericBasket<Person>(p1); // No Error
        GenericBasket<Fruit> b3 = new GenericBasket<>(f1); // No Error // Diamond operator // Type inference

        // Generic ordered Pair 
        OrderedPair<Integer, Integer> op1 = new OrderedPair<>(2,4); 
        System.out.println("op1.getKey() : " + op1.getKey());
        System.out.println("op1.getValue() : " + op1.getValue());

        OrderedPair<String, Integer> op2 = new OrderedPair<>("Shahbaz", 22);
        System.out.println("op2.getKey() : " + op2.getKey());
        System.out.println("op2.getValue() : " + op2.getValue());

        // Can also put parameterized Types as type parameters.
        OrderedPair<String, GenericBasket<Integer>> op3 = new OrderedPair("Shahbaz", new GenericBasket<Integer>(22));
        System.out.println("op3.getKey() : " + op3.getKey());

        // It is ok to assign a parameterized type to a raw type.
        OrderedPair<String, String> op4 = new OrderedPair<>("key", "value");
        OrderedPair op5 = op4; // it is ok but not recommended
        System.out.println(op5.getKey() + " : " + op5.getValue());

        // Generic methods
        OrderedPair<String, Integer> op6 = new OrderedPair<>("Shahbaz", 22);
        OrderedPair<String, Integer> op7 = new OrderedPair<>("Shahbaz", 22);
        boolean isEqual = Util.<String, Integer>comapare(op6, op7);
        System.out.println("isEqual : " + isEqual);

        // Bounded Type Parameters
        var n1 = new NaturalNumber<Integer>(12); // var keyword automatically detects the datatype.
        System.out.println("Is n1 even ? : " + n1.isEven());

        // generic methods and bounded type parameters
        var c1 = new Car("Tesla model 3", 300);
        var c2 = new Car("Tata Nano", 120);
        var c3 = new Car("McLaren Senna", 380);
        var c4 = new Car("Mahindra Scorpio", 160);

        Car[] cars = {c1, c2, c3, c4};
        System.out.println("Number of cars with max speed greater than c4 : " + ArrayUtils.countGreaterThan(cars, c4));







        


        







        
    }
}
