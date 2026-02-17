import java.util.*;
import java.io.*;

class MapPhones {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Map<String, Integer> map = new HashMap<>();
        while (n > 0) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine();

            map.put(name, phone);
            n--;
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            if (map.containsKey(s)) {
                System.out.println(s + "=" + map.get(s));
            } else {
                System.out.println("Not found");
            }
        }
    }
}
