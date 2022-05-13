package com.example.springplay.validation;

import java.math.BigInteger;

public class PrimeNumberUtil {

    public final BigInteger BIG_INT_ZERO = BigInteger.ZERO;
    public final BigInteger BIG_INT_ONE = BigInteger.ONE;
    public final BigInteger BIG_INT_TWO = BigInteger.TWO;
    public final BigInteger BIG_INT_THREE = BigInteger.valueOf(3);
    public final BigInteger BIG_INT_FIVE = BigInteger.valueOf(5);
    public final BigInteger BIG_INT_SIX = BigInteger.valueOf(6);

    public boolean isPrime(BigInteger n) {
        if (BIG_INT_TWO.equals(n) || BIG_INT_THREE.equals(n)) {
            return true;
        }

        if (BIG_INT_ONE.compareTo(n) > 0 || n.remainder(BIG_INT_TWO).equals(BIG_INT_ZERO) || n.remainder(BIG_INT_THREE).equals(BIG_INT_ZERO)) {
            return false;
        }

        final BigInteger sqrtOfN = n.sqrt();

        for (BigInteger i = BIG_INT_FIVE; i.compareTo(sqrtOfN) < 1; i = i.add(BIG_INT_SIX)) {
            if (n.remainder(i).equals(BIG_INT_ZERO) || n.remainder(i.add(BIG_INT_TWO)).equals(BIG_INT_ZERO)) {
                return false;
            }
        }

        return true;
    }

    public boolean isPrimeQuickCheck(BigInteger n) {
        return n.isProbablePrime(1);
    }
}
