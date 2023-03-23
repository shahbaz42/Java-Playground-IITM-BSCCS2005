public class strings {
    public static void main(String[] args) {
        // String can be defined in two ways (both are same)
        // 1. String literal
        // 2. String object

        // String literal
        String s1 = "Hello";
        System.out.println(s1);

        // String oblject
        String s2 = new String(" World!");
        System.out.println(s2);

        // String.length()
        System.out.println("Length of string s1 : " + s1.length());

        // string character access using square brackets is not allowed in java because
        // String are objects in java; actual string is a variable inside the object 
        // System.out.println(s1[0]); // throw an error

        // String.charAt() -> returns the character at given index position.
        System.out.println("char at index : " + s1.charAt(0));

        s1 = "ABCDE"; // replacing string by assinging a new string to variable is possible

        // Substring
        System.out.println("substring(0,1)" + s1.substring(0, 1)); // end index is escaped
        System.out.println("substring(0,2)" + s1.substring(0, 2)); // end index is escaped
        System.out.println("substring with one argument : " + s1.substring(2)); // end index is escaped
        
        // Last character of string
        System.out.println("Last character of string s1 : " + s1.charAt(s1.length()-1));

        // last n characters of a string
        System.out.println("Last 2 characters of string s1 : " + s1.substring(s1.length()-2));

        // s1[0] = 'a'; // but replacing a character is not possible
        // replacing a character in a string
        // 1. using substring
        s1 = "ABCZE";
        System.out.println("Replacing a character in a string using substring : " + s1.substring(0, 3) + "D" + s1.substring(4));

        // 2. using StringBuilder (String builder is not safe and it should not be used in multi threaded environment)
        StringBuilder sb = new StringBuilder(s1);
        sb.setCharAt(3, 'D');
        s1 = sb.toString();
        System.out.println("Replacing a character in a string using StringBuilder : " + s1);

        // String concatenation
        s1 = "Hello";
        System.out.println("String concatenation : " + s1 + s2);

        // String.compareTo() -> compares two strings lexicographically
        System.out.println("String s1 compareTo s2 : " + s1.compareTo(s2));

        // checking if a substring is present inside a string
        s1 = "Hello World!";
        s2 = "World";
        System.out.println("Is s2 present in s1 : " + s1.contains(s2));

        // String.indexOf() -> returns the index of first occurence of a substring
        System.out.println("Index of s2 in s1 : " + s1.indexOf(s2));

        // String.mathces() -> checks if a string matches a given regular expression
        System.out.println("Does s1 matches regex : " + s1.matches("Hello.*"));

        // String.split() -> splits a string into substrings based on a given regex
        s1 = "Monkey cat bat dog elephant";
        System.out.println("Splitting string (delimeter space)" + s1 + " into words : ");
        String[] words = s1.split(" ");
        for (String word : words) {
            System.out.println(word);
        }

        s1 = "Monkey-dog-cat-elephant";
        System.out.println("Splitting string (delimeter - ) " + s1 + " into words : ");
        words = s1.split("-");
        for (String word : words) {
            System.out.println(word);
        }

        // trim() trims string from both ends (leading and trailing spaces)
        s1 = "   Hello World!   ";
        System.out.println("Trimming string : " + s1.trim());

        // toCharArray() -> converts a string into a character array
        s1 = "Hello World!";
        char[] charArray = s1.toCharArray();
        System.out.println("Converting string " + s1 + " into character array : ");
        for (char c : charArray){
            System.out.println(c);
        }

        // toLowereCase() -> converts a string into lowercase
        s1 = "HELLO WORLD!";
        System.out.println("Converting string " + s1 + " into lowercase : " + s1.toLowerCase());

        // toUpperCase() -> converts a string into uppercase
        s1 = "hello world!";
        System.out.println("Converting string " + s1 + " into uppercase : " + s1.toUpperCase());

        // concatenate two strings
        s1 = s1 + " " + s2;
        System.out.println("Concatenating two strings : " + s1);

        // equalsIgnoreCase() -> compares two strings ignoring case
        s1 = "Hello World!";
        s2 = "hello world!";
        System.out.println("Comparing two strings ignoring case : " + s1.equalsIgnoreCase(s2));

        // String.replace() ->  replaces all occurance of a character 
        s1 = "Hewwo World!";
        System.out.println("Replacing all occurences of w with l : " + s1.replace('w', 'l'));

        // Java string escape sequence
        System.out.println("He said \"Hello world\" to the compiler");
        System.out.println("escaping a backward slash \\ ");

    }
}
