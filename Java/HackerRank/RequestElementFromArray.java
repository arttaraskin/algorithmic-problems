import java.io.*;
import java.util.*;

public class RequestElementFromArray {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            List<List<Integer>> arrays = read(scanner);
            List<List<Integer>> requests = read(scanner);
            for (List<Integer> request : requests) {
                try {
                    System.out.println(arrays.get(request.get(0) - 1).get(request.get(1)));
                } catch(IndexOutOfBoundsException e) {
                    System.out.println("ERROR!");
                }
            }
        }
    }
    
    private static List<List<Integer>> read(Scanner scanner) {
        Integer n = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            String line = scanner.nextLine();
            try(Scanner lineScanner = new Scanner(line)) {
                while (lineScanner.hasNext()) {
                    row.add(lineScanner.nextInt());
                }
            }
            list.add(row);
        }
        return list;      
    }
}

Sample Input

5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5

Sample Output

74
52
37
ERROR!
ERROR!