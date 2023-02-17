public class GA4_2 {
    public static void main(String[] args){

    }
}

interface Shape{
    abstract double area();
    abstract double volume();
}

interface Printable{    
    default void print(){
        System.out.println("Printable");
    }
}