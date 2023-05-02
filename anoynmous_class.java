interface Polygon{
    public void display();
}

class Animal{
    public void eat(){
        System.out.println("Animal eats");
    }
}

class OuterClass1{
    public void call(){
        // Creating an anoynmous class from an interface
        Polygon p1 = new Polygon(){
            public void display(){
                System.out.println("Polygon");
            }
        };

        // Creating an anoynmous class from a class
        Animal a1 = new Animal(){ // This anoynmous class extends Animal
            public void eat(){ // This method overrides eat() in Animal 
                System.out.println("Animal eats grass");
            }; // semicolon is required here   
        };

        System.out.println(p1.getClass().getName()); // prints OuterClass1$1 i.e. first anoynmous class in OuterClass1
        p1.display();

        System.out.println(a1.getClass().getName()); // prints OuterClass1$2
        a1.eat();
    }
}

public class anoynmous_class {
    public static void main(String[] args) {
        OuterClass1 o1 = new OuterClass1();
        o1.call();
    }
}