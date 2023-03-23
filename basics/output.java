public class output {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.print("Hello World!");
        System.out.print(" and Hello Universe!");
        System.out.println(42);
        System.out.print("Hello" + " World!");

        int a = 42;
        System.out.println(a);

        String name = "John";
        System.out.println(name);
        // strings can be concatenated like this.
        System.out.println("Hello " + name);
        
        int age = 42;
        System.out.println("Hello " + name + " you are " + age + " years old");

        // print first char of a string
        String s = "Hello";
        System.out.println(s.charAt(0));

        // print ing using printf
        String student_name = "Shahbaz";
        int student_age = 18;
        float balance = 2000.00000f;
        System.out.printf("Name is %s and age is %d and balance is %.2f.", student_name, student_age, balance);
    }
}
