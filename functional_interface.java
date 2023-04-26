import java.util.function.*;

@FunctionalInterface
interface Three_Parameter_Function<A, B, C, R>{
    public R apply(A a, B b, C c);
}

class AddThree implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer a){
        return a + 3;
    }
}

class SimpleInterest implements Three_Parameter_Function<Double, Double, Double, Double>{
    @Override
    public Double apply(Double p, Double t, Double r){
        return p*t*r;
    }
}

// public interface Predicate<T> {
//     boolean test(T t);
// }

class CheckEven implements Predicate<Integer>{
    @Override
    public boolean test(Integer a){
        return a%2 == 0;
    }
}

public class functional_interface {
    public static void main(String[] args) {
        // 1. Function
        System.out.println("\n Function  : ");

        Function <Integer, Integer> add_three = new AddThree();
        System.out.println("add_three.apply using functional interface : " + add_three.apply(1));

        Three_Parameter_Function<Double, Double, Double, Double> calculate_interest = new SimpleInterest(); 
        System.out.println("calculate_interest.apply() using Three_Parameter_Function functional interface : " + calculate_interest.apply(1.2, 1.0, 1.0));

        Three_Parameter_Function<Double, Double, Double, Double> calculate_sum =  (a, b, c) -> {
            return a+b+c;
        };
        System.out.println("calculate_sum.apply() using Three_Parameter_Function functional interface : " + calculate_sum.apply(1.0, 2.0, 3.0));

        // 2. Predicate : Takes a single value and returns true or false.
        System.out.println("\n2. Predicate");
        CheckEven checkEven = new CheckEven();
        System.out.println("checkEven.test(4) : " + checkEven.test(4));

        // Predicate can also be using a lambda Expression
        Predicate<Integer> isOdd = n -> n%2 == 1;
        System.out.println("Predicate isOdd.test(5) : " + isOdd.test(5));

        // 3. Unary Operator : Takes a single operator and returns a parameter of same type.
        System.out.println("\n3. UnaryOperator");
        UnaryOperator<Integer> increment = n -> n+1;
        System.out.println("increment.apply(5) : " + increment.apply(5));

        // 4. BinaryOperator : It takes two parameters and returns a single parameter of same type.
        System.out.println("\n4. BinaryOperator : ");
        BinaryOperator<Integer> addAB = (a,b) -> a+b ;
        System.out.println("addAB.apply(1,2) : " + addAB.apply(1,2));

        // 5. Supplier : Java Supplier interface is a functional interface that represents a function that supplies values of some sort.
        System.out.println("\n5. Supplier : ");
        Supplier<Integer> generateRandomInteger = () -> (int)(Math.random()*10);
        System.out.println("genereateRandomInteger.get() : " + generateRandomInteger.get());

        // 6. Consumer : Java Consumer interface is a functional interface that represents a function that takes a single parameter and returns no result.
        Consumer<Integer> print = n -> System.out.println(n);
        print.accept(5);

        // 7. BiConsumer : Java BiConsumer interface is a functional interface that represents a function that takes two parameters and returns no result.
        BiConsumer<Integer, Integer> printSum = (a,b) -> System.out.println(a+b);
        printSum.accept(5, 6);

        // Java Functional Composition
        System.out.println("\nJava Functional Composition : ");
        Function<Integer, Integer> addFive = n -> n+5;
        Function<Integer, Integer> multiplyByTwo = n -> n*2;
        Function<Integer, Integer> addOne = n -> n+1;
        System.out.println("Function.compose() : ");
        Function<Integer, Integer> addFiveThenMultiplyByTwoThanAddOne = addOne.compose(multiplyByTwo).compose(addFive);
        System.out.println("addFiveThenMultiplyByTwoThanAddOne.apply(0) : " + addFiveThenMultiplyByTwoThanAddOne.apply(0));
        
        // Function.andThen()
        System.out.println("\nFunction.anDThen() : ");
        Function<Integer, Integer> addFiveThenMultiplyByTwoThanAddOne_2 = addFive.andThen(multiplyByTwo).andThen(addOne);
        System.out.println("addFiveThenMultiplyByTwoThanAddOne_2.apply(0) : " + addFiveThenMultiplyByTwoThanAddOne_2.apply(0));
    
    }
}

/* 

Function  :
add_three.apply using functional interface : 4
calculate_interest.apply() using Three_Parameter_Function functional interface : 1.2
calculate_sum.apply() using Three_Parameter_Function functional interface : 6.0

2. Predicate
checkEven.test(4) : true
Predicate isOdd.test(5) : true

3. UnaryOperator
increment.apply(5) : 6

3. UnaryOperator
increment.apply(5) : 6

4. BinaryOperator :
addAB.apply(1,2) : 3

5. Supplier :
genereateRandomInteger.get() : 2
5
11

Java Functional Composition :
Function.compose() :
addFiveThenMultiplyByTwoThanAddOne.apply(0) : 11
Function.anDThen() :
addFiveThenMultiplyByTwoThanAddOne_2.apply(0) : 11

*/
