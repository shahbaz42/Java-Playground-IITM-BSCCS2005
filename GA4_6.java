class Language{
    public void show(){
          System.out.println("In Language class");
    }
    public class Programming{
          public void show(){
                System.out.println("In Programming class");
          }
    }
}

// public class GA4_6 {
//      public static void main(String[] args) {
//         Language l = new Language();
//         Language.Programming p = l.new Programming();
//         p.show();
//     }
// }

public class GA4_6 {
    public static void main(String[] args) {
       new Language().new Programming().show();
   }
}