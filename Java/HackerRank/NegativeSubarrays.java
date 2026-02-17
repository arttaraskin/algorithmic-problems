import java.io.*;
import java.util.*;
import java.util.stream.*;

public class NegativeSubarrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer n = Integer.parseInt(in.nextLine());
        ;
        List<Integer> list = Arrays.stream(in.nextLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n - i; j++) {
                sum += list.get(i + j);
                if (sum < 0) {
                    count++;
                }
            }
        }
        System.out.println(count);

        scanner.close();
    }
}

//    int arr[]= new int[n];
//    for(int i=0; i<n; i++){
//        arr[i] = scanner.nextInt();
//    }
