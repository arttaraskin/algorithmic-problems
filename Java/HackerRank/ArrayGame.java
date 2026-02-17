import java.util.*;

public class ArrayGame {

    public static boolean canWin(int current, int leap, int[] game) {
        if (current < 0 || game[current] != 0) {
            return false;
        }
        if (current + 1 >= game.length || current + leap >= game.length) {
            return true;
        }
        game[current] = 1;

        return canWin(current + leap, leap, game) ||
               canWin(current + 1, leap, game) ||
               canWin(current - 1, leap, game);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(0, leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
