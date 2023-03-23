public class java_typecasting {
    public static void main(String[] args) {
        // Java typecasting: assigning value on one data type to another.
        
        // 1. Widening typecasting (automatically) converting a smaller type to a larger type.
        // byte -> short -> char -> int -> long -> float -> double

        // 2 Narrowing typecasting (manually) converter a smaller (more precise) data type to a larger datatype (less precise)

        int n1 = 9;
        double d1 = n1; // automatically typecasted because converting to a smaller (more precise) datatype
        System.out.println("int to double typecasting" + d1);

        double d2 = 10.5;
        // int n2 = d2; // It'll throw an error because java doesn't automatically typecast a smaller ( more precise ) datatype into a larger datatype.
        int n2 = (int) d2; // Manually typecasting

    }
}
