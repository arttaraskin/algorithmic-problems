import java.io.*;
import java.util.*;

public class Anagram {

    static boolean isAnagram(String a, String b) {
        return countMap(a).equals(countMap(b));
    }
    
    private static Map<Character, Integer> countMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.toUpperCase().charAt(i), 1, Integer::sum);
        }
        return map;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
