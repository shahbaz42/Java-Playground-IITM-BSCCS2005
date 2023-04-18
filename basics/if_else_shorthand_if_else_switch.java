public class if_else_shorthand_if_else_switch {
    public static void main(String[] args) {
        int a = 10;
        if ( a == 10 ){
            System.out.println("Condition is true");
            a = 15;
        }
        else if ( a == 15 ) {
            System.out.println("else if block executed ");
        }
        else {
            System.out.println("else block executed");
        }

        // shorthand syntax (ternary if else)
        a = 5;
        String s  = ( a == 5 ) ? "True" : "False" ;
        System.out.println(s);   
        
        int day = 6;
        switch (day) {
            case 1:
                System.out.println("monday");
                break;
            case 6 :
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Na");
                break;
        }
    }
}
