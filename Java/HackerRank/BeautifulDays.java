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

class Result {

    /*
     * Complete the 'beautifulDays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER i
     *  2. INTEGER j
     *  3. INTEGER k
     */

    public static int beautifulDays(int a, int b, int k) {
        int count = 0;
        for(int i = a; i <= b; i++) {
			int reversed = Integer.parseInt(new StringBuilder(String.valueOf(i)).reverse().toString());
            //or int reversed = reverse(i);
            if((i - reversed) % k == 0) {
                count++;
            }
        }
        return count;
    }

    private static int reverse(int n) {
        int result = 0;
        while(n > 0) {
            result = result*10 + n % 10;
            n = n / 10;
        }
        return result;
    }
	
	// or reverse using moving from a char array to another char array
	// or reverse using char array and left and right chars exchange
}

public class BeautifulDays {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
