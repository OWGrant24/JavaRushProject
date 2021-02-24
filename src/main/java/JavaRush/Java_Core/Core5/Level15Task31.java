package JavaRush.Java_Core.Core5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Level15Task31 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        if(n<0){
            return "0";
        }
        if (n==0){
            return "1";
        }
        BigInteger f = BigInteger.valueOf(1);
        for(int i = 1; i <=n ; i++) {
                f = f.multiply(BigInteger.valueOf(i));
        }
        return f.toString();
    }
}
