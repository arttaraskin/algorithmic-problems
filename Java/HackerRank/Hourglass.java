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


public class Hourglass {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            List<List<Integer>> arr = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            }

            int max = Integer.MIN_VALUE;
            for (int i = 0; i <= 3; i++) {
                for (int j = 0; j <= 3; j++) {
                    List<Integer> row1 = arr.get(i);
                    List<Integer> row2 = arr.get(i + 1);
                    List<Integer> row3 = arr.get(i + 2);
                    Integer sum = row1.get(j) + row1.get(j + 1) + row1.get(j + 2) +
                        row2.get(j + 1) +
                        row3.get(j) + row3.get(j + 1) + row3.get(j + 2);
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
            System.out.println(max);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
