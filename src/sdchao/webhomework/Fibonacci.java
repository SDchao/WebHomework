package sdchao.webhomework;

import java.math.BigInteger;

public class Fibonacci {
    public static BigInteger fo(int count) {
        if (count < 0)
            return new BigInteger("-1");
        else if (count == 0)
            return new BigInteger("0");
        else if (count == 1 || count == 2)
            return new BigInteger("1");
        else {
            BigInteger c = new BigInteger("0");
            BigInteger a = new BigInteger("1");
            BigInteger b = new BigInteger("1");

            for(int i = 3; i <= count; i++) {
                c = a.add(b);
                a = b;
                b = c;
            }

            return c;
        }
    }

    public static void main(String[] args) {
        for(int i = 1; i <= 200; i++) {
            System.out.println(fo(i));
        }
    }
}

