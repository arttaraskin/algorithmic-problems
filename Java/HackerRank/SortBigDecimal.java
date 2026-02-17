import java.math.BigDecimal;
import java.util.*;

class SortBigDecimal {
    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        //Arrays.sort(s, Comparator.comparing(BigDecimal::new, Comparator.reverseOrder()));
        Arrays.sort(s, Comparator.comparing((String str) -> new BigDecimal(str)).reversed());

        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}
