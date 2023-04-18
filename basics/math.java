import java.util.*;

class math {
    public static void main(String[] args) {

        int n = 10;

        // Math.max(), Math.min()
        System.out.println(Math.max(1,2));
        System.out.println(Math.min(1,2));
        // system.out.println(Math.min(1,2,3)) // It'll give an error

        // minimum value of an array
        int[] arr = {5,4,7,9};
        // using inbuilt sort
        Arrays.sort(arr);
        System.out.println("Smallest elemnt of an array using java soprt : " + arr[0]);
        
        // using for loop
        int min = arr[0];
        for (int x : arr ) // if there is only one element in for loop than block is not needed
            if(x<min) min = x; // if there is only one element in if else then block is not needed
        System.out.println(min);

        // Math.abs()
        n = -10;
        System.out.println("Absolute value of -10 is : " + Math.abs(n));
        
        // Math.sqrt()
        n = 25;
        System.out.println("Square root of 25 is : " + Math.sqrt(n));

        // Math.pow()
        System.out.println("2^3 is : " + Math.pow(2,3));

        // Math.random()
        System.out.println("Random number between 0 and 1 : " + Math.random());

        // Random number bertween 1 100 inclusive
        System.out.println("Random number between 1 and 100 : " + (int)(Math.random()*100+1));
        
    }
}