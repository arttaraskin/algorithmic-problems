import java.io.*;
import java.util.*;

public class StringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        
        String delimeter = "[\\s!,?._'@]+";
        if (s.trim().length() > 0) {
           String[] tokens = s.trim().split(delimeter);
           System.out.println(tokens.length);
           for (String token : tokens) {
              System.out.println(token);
           }
        } else {
            System.out.println(0);
        }
        
        scan.close();
    }
}

