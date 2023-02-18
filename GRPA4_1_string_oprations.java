import java.util.*;
abstract class StringOperations{
  public abstract String reverse(String s);
  public abstract int vowelCount(String s);
}
abstract class StringReverse extends StringOperations{
    public String reverse(String s){
        String ns = "";
        char ch;
        for(int i=0; i<s.length(); i++){
            ch=s.charAt(i);
            ns = ch + ns;
        }
        return ns;
    }
    public abstract int vowelCount(String s);
}

class UpdatedStrings extends StringReverse{
    public int vowelCount(String s){
        int vCount=0;
        for(int j=0; j<s.length(); j++){
            char ch = s.charAt(j);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                vCount++;
            }
        }
        return vCount;
    }
}

class GRPA4_1_string_oprations {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
        String s = sc.next();
        UpdatedStrings str = new UpdatedStrings();
        System.out.println("Reverse of "+ s + " is "+ str.reverse(s));
        System.out.println("Vowel count of "+ s + " is "+ str.vowelCount(s));
    }
  }
}