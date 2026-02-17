import java.io.*;
import java.util.*;

public class BitSet {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            int bits = scanner.nextInt();
            int operations = scanner.nextInt();
            scanner.nextLine();
            
            BitSet b1 = new BitSet(bits);
            BitSet b2 = new BitSet(bits);
            for(int i = 0; i < operations; i++) {
                String operation = scanner.next();
                int op1 = scanner.nextInt();
                int op2 = scanner.nextInt();

                switch(operation) {
                    case "AND":
                        if (op1 == 1) {
                            b1.and(b2);
                        } else {
                            b2.and(b1);
                        }
                        break;
                    case "OR":
                        if (op1 == 1) {
                            b1.or(b2);
                        } else {
                            b2.or(b1);
                        }
                        break;
                    case "XOR":
                        if (op1 == 1) {
                            b1.xor(b2);
                        } else {
                            b2.xor(b1);
                        }
                        break;
                    case "SET":
                        if (op1 == 1) {
                            b1.set(op2);
                        } else {
                            b2.set(op2);
                        }
                        break;
                    case "FLIP":
                        if (op1 == 1) {
                            b1.flip(op2);
                        } else {
                            b2.flip(op2);
                        }
                        break;
                }
                System.out.println(b1.cardinality() + " " + b2.cardinality());
            }
        }
    }
}
