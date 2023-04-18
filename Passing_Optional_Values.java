import java.util.Optional;

public class Passing_Optional_Values {
    public static void main(String[] args) {
        // System.out.println(safeInverse(0));
        // System.out.println(safeInverse(2));
        // System.out.println(safeInverse(0).orElse(0.0));

        // We want to calculate the squareroot of inverse of 0.25

        Double x = 0.0;
        // Optional<Double> inv = safeInverse(x);
        // if (inv.isPresent()){
        //     Optional<Double> sqrt = squareRoot(inv.get());
        //     if (sqrt.isPresent()){
        //         System.out.println(sqrt);
        //     } 
        // }

        // Optional<Double> result = safeInverse(x).map(Passing_Optional_Values::squareRoot); 
        // Above line is wrong because map() will not work when the value is not present

        Optional<Double> result = safeInverse(x).flatMap(Passing_Optional_Values::squareRoot);
        System.out.println(result);

    }

    public static Optional<Double> safeInverse(double x){
        if(x==0)
            return Optional.empty();
        else 
            return Optional.of(1/x);
    }

    public static Optional<Double> squareRoot(double x){
        if (x < 0)
            return Optional.empty();
        else 
            return Optional.of(Math.sqrt(x));
    }
}
