import java.util.*;

public class Optional_Type {
    public static void main(String[] args) {
        // Here we are creating an Optional object
        Optional<String> hobby = Optional.of("Programming");
        System.out.println(hobby.get()); // It will return the value of the Optional object
        System.out.println(hobby.isPresent()); // boolean value is returned
        System.out.println(hobby.orElse("No value present")); // default value is returned
        System.out.println(hobby.orElseGet(() -> "Default value")); // default is returned using lambda expression
        System.out.println(hobby.map(String::toUpperCase).get()); // It will return the value in uppercase

        // Creating another Optional object with null value
        // Optional.ofNullable() method is used to create an Optional object with null value
        Optional<String> hobby2 = Optional.ofNullable(null); 
        //System.out.println(hobby2.get()); // It will throw an exception
        System.out.println(hobby2.isPresent()); // boolean value is returned
        System.out.println(hobby2.orElse("No value present")); // default value is returned
        System.out.println(hobby2.orElseGet(() -> "Default value")); // default is returned using lambda expression

        // ifPresentOrElse() method
        Optional<String> hobby3 = Optional.ofNullable(null); 
        hobby3.ifPresentOrElse(System.out::println, () -> System.out.println("No value present"));
    }
}
