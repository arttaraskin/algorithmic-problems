import java.io.*;
import java.util.*;
import java.util.stream.*;

public class OperationsOnList {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            Integer n = Integer.parseInt(scanner.nextLine());
            String[] lineArray = scanner.nextLine().trim().split(" ");
            List<Integer> list = Stream.of(lineArray)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

            Integer q = Integer.parseInt(scanner.nextLine());
            while(q > 0){
                String operation = scanner.nextLine();
                if ("Insert".equals(operation)) {
                    String[] line = scanner.nextLine().split(" ");
                    int index = Integer.parseInt(line[0]);
                    Integer element = Integer.valueOf(line[1]);
                    list.add(index, element);
                } else if ("Delete".equals(operation)) {
                    String line = scanner.nextLine();
                    int index = Integer.parseInt(line);
                    list.remove(index);
                } else {
                    throw new RuntimeException("Wrong operation");
                }
                q--;
            }
            String result = list.stream().map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(result);
        }
    }
}
