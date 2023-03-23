import java.math.BigInteger;
import java.math.BigDecimal;

public class data_types {
    public static void main(String[] args) {
        // java data types are divided into two main types 
        // 1. premitive data types
        // byte, short, int, long, float, double, boolean and char
        // 2. Non premitive data types like 
        // String, Arays, and Classes

        // example of byte datatype
        // byte datatype is an 8bit signed two's complement integer
        // byte can be used to save memory space while using array etc.

        byte myByte = 20;
        System.out.println(myByte);
        
        // range of byte : [-128, 128]
        // byte myByte2 = 130; // it'll throw an error

        myByte++;
        System.out.println(myByte);

        byte newbyte = (byte) (myByte*2) ; // we need to cast because 2 is and integer
        System.out.println(newbyte);

        byte overflowedByte = (byte)(myByte*8); // Due to overflow value stored will be different.
        System.out.println(overflowedByte);

        // short datatype
        short abc = 54;
        short newabc = (short)(abc*2);
        System.out.println(newabc);

        // int datatype
        int number = 42;
        int new_number = number*2;
        System.out.println(new_number);

        // float datatype
        float fnumber = 100f;
        System.out.println(fnumber);

        //scientific number
        // A floating point number can also be a scientific number
        // with an "e" to indicate the power of 10
        float k = 10e3f;
        System.out.println("Scientific number k : " + k);

        //long datatype
        long ln = 500;
        long ln2 = ln*2;
        System.out.println(ln2);

        // booleans
        boolean day = false;
        boolean night = true;
        System.out.println("Is day equal to night: " + (day==night));

        // char
        char ch1=65, ch2=66, ch3=67;
        System.out.println("Character concatenation : " + ch1 + ch2 + ch3);

        // Non-Premitive data types
        // Non premitive data types are called reference types because they refer to objects;

        // String
        String s1 = new String("S1");
        System.out.println(s1);

        // shorthand way of declaring strings.
        String s2 = "S2";
        System.out.println(s2);

        // Using java.math.BigInteger to store and manipulate large numbers
        BigInteger bigNumber = new BigInteger("12312312312341234234123421341234123412341234123412341234123412341234");
        System.out.println(bigNumber);

        BigInteger anotherBigNumber = new BigInteger("100000000000");
        anotherBigNumber = bigNumber.multiply(anotherBigNumber);
        System.out.println(anotherBigNumber);

        // declare an empty bigDecimal by assigning the value null
        BigDecimal bigDecimalNumber = null;
        // or we can initialize BigDecimal with default value such as ZERO;
        BigDecimal bigDecimalnum = BigDecimal.ZERO;
        
        // Changing type of a BigInteger from a BigDecimal and vice versa.
        BigInteger n1 = new BigInteger("100");
        BigDecimal nd2 = new BigDecimal(n1);
        // nd2 = nd2*2; // It'll throw an error
        nd2 = nd2.multiply(nd2);
        System.out.println(nd2);

        // because multiply method takes a BigDecimal a new BigDecimal can be created instantly.
        nd2 = nd2.multiply(new BigDecimal(2));
        System.out.println(nd2);

    }
}
