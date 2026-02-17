import java.io.*;
import java.util.*;
import java.math.*;

public class BigNumbers {

    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            BigInteger i1 = new BigInteger(bufferedReader.readLine());
            BigInteger i2 = new BigInteger(bufferedReader.readLine());
            
            System.out.println(i1.add(i2));
            System.out.println(i1.multiply(i2));
        }
        catch (IOException ex){
            System.out.println(ex);
        }
    }
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger i1 = sc.nextBigInteger();
        BigInteger i2 = sc.nextBigInteger();
        
        System.out.println(i1.add(i2));
        System.out.println(i1.multiply(i2));

        sc.close();
    }