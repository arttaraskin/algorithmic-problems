import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class LongestSubarray {

    /*
     * Complete the 'longestSubarray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int longestSubarray(List<Integer> arr) {
        int max = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.size() - 1; i++) {
            set.clear();
            set.add(arr.get(i));
 
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) - arr.get(j) == 0) {
                    max = Math.max(max, j - i + 1);
                } else if (Math.abs(arr.get(i) - arr.get(j)) == 1) {
                    set.add(arr.get(j));
                    if (set.size() > 2) {
                        break;
                    } else {
                        max = Math.max(max, j - i + 1);
                    }
                } else {
                    break;
                }      
            }
        }
        return max;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.longestSubarray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
