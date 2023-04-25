interface Inter{
    public abstract void greet();
}
class Greetings{
    private String country;
    public void setCountry(String s){
          this.country = s;
    }
    public String getCountry(){
         return country;
    }
    public Inter checkCountry(){
        if(getCountry() == "India"){
              return new IndiaGreetings();
        }
        return new WorldGreetings();
    }
    private class IndiaGreetings implements Inter{
         public void greet(){
               System.out.println("Hello"+ " "+"India");
         }
   }
   private class WorldGreetings implements Inter{
         public void greet(){
                System.out.println("Hello"+ " "+"World");
         }
    }
}
public class GA4_5 {
     public static void main(String[] args) {
          Greetings g = new Greetings();
          g.setCountry("India");
          g.checkCountry().greet();
     }
}