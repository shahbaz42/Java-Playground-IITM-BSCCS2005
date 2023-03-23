public class operators {
    public static void main(String[] args) {
        int n1 = 100;
        int n2 = 3;
        System.out.println("Result of 100/10 : " + 100/10);
        System.out.println("Result of 100/3 : " + 100/3);
        System.out.println("Result of 100/3 : " + 100d/3d);

        // decimal point division in java
        double d1 = 100;
        double d2 = 3;
        System.out.println("floor division in java : " + d1/d2);
        System.out.println("Division of a double by an int : " + d1/n2);
        System.out.println("Division of a int by a double : " + n1/d2);

        System.out.println(d1*n1); // automatically typecasts into double.
        System.out.println(n1*d1); // order doesnt matters
        // if both are integers then the result is also integer
        System.out.println(n1*n2);
        // if any one variable is double the result is double
        // all other variables are converted to double
        System.out.println(d1*n2);
        



        

        // 

    }
    
}
