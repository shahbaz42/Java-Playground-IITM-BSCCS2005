import java.util.*;
//Define DivisionException class here

public class Test {
 
    //Define divide(int a, int b) here

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int x = sc.nextInt();
       int y = sc.nextInt();
       
       //call divide method here
class DivisionException extends Exception {
    @Override
    public String toString() {
        return "Division by 3 is not allowed";
    }
}

public class Test {
    public static int divide(int a, int b) throws DivisionException {
        if (b == 3) {
            throw new DivisionException();
        }
        return a / b;
    }

    public static void main(String[] args) {
        int x = 10;
        int y = 3;
        try {
            int result = divide(x, y);
            System.out.println(result);
        } catch (DivisionException e) {
            System.out.println(e);
        }

        

   }
} 