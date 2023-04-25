interface Animal{
    void sound();
    default void eat(String animal){
          System.out.println(animal+" eats every day");
     }
}
class Cat implements Animal{
    public void sound(){
         System.out.println("Cat meows");
    }
}
class Dog implements Animal{
     public void sound(){
          System.out.println("Dog barks");
      }
}

public class GA4_7{
    public static void main(String[] args){
        Animal oa1=new Cat();
        oa1.sound();
        oa1.eat("Cat");
        Animal oa2=new Dog();
        oa2.sound();
        oa2.eat("Dog");
    }
}
