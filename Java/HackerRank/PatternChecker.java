import java.io.*;
import java.util.*;
import java.util.regex.*;

public class PatternChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(in.readLine());
        while (testCases > 0) {
            String pattern = in.readLine();

            try {
                Pattern.compile(pattern);
                System.out.println("Valid");
            } catch (PatternSyntaxException e) {
                System.out.println("Invalid");
            }
            testCases--;
        }
    }
}
