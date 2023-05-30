import java.util.*;

public class concrete_collections_hashset_treeset {
    public static void main(String[] args) {
        // 1. Create an empty set
        Set<String> set1 = new HashSet<String>(); 
        // 2. Create a set from an existing collection
        Set<String> set2 = new HashSet<String>(set1);
        // 3. Create a set from an array
        String[] arr = {"a", "b", "c"};
        Set<String> set3 = new HashSet<String>(Arrays.asList(arr));
        // 4. Create a set from a varargs
        Set<String> set4 = new HashSet<String>(Arrays.asList("a", "b", "c"));
        
        // nested set
        Set<Set<Integer>> set5 = new HashSet<>();
        set5.add(new HashSet<>(Arrays.asList(1,2,3)));
        set5.add(new HashSet<>(Arrays.asList(4,5,6)));
        set5.add(new HashSet<>(Arrays.asList(4,5,6)));
        
        System.out.println(set5);

        Set<Integer> set6 = new TreeSet<>();
        for(int i=0 ; i<100000000 ; i++){
            set6.add(i);
        }

        System.out.println(set6.contains(999));

    }
}
