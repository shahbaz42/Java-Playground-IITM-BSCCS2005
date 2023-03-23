public class variable {
    public static void main(String[] args) {
        // basic java variables types
        // int, float, double, char, boolean

        int x = 5;
        int y = 6;
        int z = x + y;
        System.out.println(z);

        int a = 5, b = 6, c = a + b;
        // multiple variables can be declared in one line like this.
        System.out.println(c);

        int d = 5;
        d = d + 1;
        System.out.println(d);

        float e = 5.5f;
        // float variables must have an f at the end of the number
        System.out.println(e);

        double f = 5.5;
        System.out.println(f);

        // differece between float and double is 
        // float is less precise than double
        // double can represent more numbers than float
        // float is 32 bits and double is 64 bits
        float g = 5.5f;
        double h = 5.5;
        System.out.println(g);
        System.out.println(h);

        char i = 'a';
        System.out.println(i);

        char k = 65;
        // Assigning a number to a char variable
        // will assign the character that has the
        // same ASCII value as the number
        System.out.println(k);

        // char m = 120903233; // error
        // System.out.println(m);

        boolean n = true;
        System.out.println(n);

        // printing a float variable upto 2 decimal places
        float o = 5.5555f;
        System.out.printf("%.2f", o);
        // %.2f means print a float variable upto 2 decimal places

    }
}
