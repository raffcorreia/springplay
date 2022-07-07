package com.example.springplay.validation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/*
Results of isPrime_test for historic purposes

Validated -1 as prime is false in 2millis
Validated 0 as prime is false in 8000nanos
Validated 10 as prime is false in 34000nanos
Validated 2 as prime is true in 8000nanos
Validated 3 as prime is true in 9000nanos
Validated 5 as prime is true in 49000nanos
Validated 97 as prime is true in 44000nanos
Validated 8589935681 as prime is true in 9millis
          99990001
          715827883
          200560490131
          999999000001
          304250263527209 -> C++ 16s
          792606555396977 -> C++ 27s
          1746860020068409 -> C++ 39s
          9999999900000001 -> C++ 40s
Validated 32361122672259149 as prime is true in 3seconds -> C++ 3min
Validated 59604644783353249 as prime is true in 4seconds
Validated 1111111111111111111 as prime is true in 16seconds
Validated 2305843009213693951 as prime is true in 24seconds
Validated 11111111111111111111111 as prime is true in 84minutes
          18446744073709550592
          11111111111111111111
          1111111111111111111
          446744073709551615
          18446744073709551615
 */
public class PrimeNumberUtilTest {

    private static PrimeNumberUtil primeNumberUtil;

    @BeforeAll
    static void setupAll() {
        primeNumberUtil = new PrimeNumberUtil();
    }

    @ParameterizedTest
    @MethodSource("provideBigIntValues")
    public void isPrime_test(boolean expectedResult, BigInteger number) {

        Duration duration = IsPrimeDuration(false, expectedResult, number);
        String strDuration = toStrDuration(duration);

        System.out.printf("Validated %d as prime is %b in %s \n", number, expectedResult, strDuration);
    }

    @ParameterizedTest
    @MethodSource("dontYouDareTheseBigIntValues")
    public void isPrimeQuickCheck_test(boolean expectedResult, BigInteger number) {

        Duration duration = IsPrimeDuration(true, expectedResult, number);
        String strDuration = toStrDuration(duration);

        System.out.printf("Validated %d as prime is %b in %s \n", number, expectedResult, strDuration);
    }

    private static Stream<Arguments> provideBigIntValues() {
        return Stream.of(
                Arguments.of(false, BigInteger.valueOf(-1)),
                Arguments.of(false, BigInteger.ZERO),
                Arguments.of(false, BigInteger.TEN),
                Arguments.of(true, BigInteger.TWO),
                Arguments.of(true, BigInteger.valueOf(3)),
                Arguments.of(true, BigInteger.valueOf(5)),
                Arguments.of(true, BigInteger.valueOf(97)),
                Arguments.of(true, new BigInteger("8589935681"))
        );
    }

    private static Stream<Arguments> dontYouDareTheseBigIntValues() {
        return Stream.of(
                Arguments.of(true, new BigInteger("32361122672259149")),
                Arguments.of(true, new BigInteger("59604644783353249")),
                Arguments.of(true, new BigInteger("1111111111111111111")),
                Arguments.of(true, new BigInteger("2305843009213693951")),
                Arguments.of(true, new BigInteger("11111111111111111111111")),
                Arguments.of(true, new BigInteger("523347633027360537213687137")),
                Arguments.of(true, new BigInteger("43143988327398957279342419750374600193"))
        );
    }

    public Duration IsPrimeDuration(boolean quickCheck, boolean expectedResult, BigInteger number) {
        Instant starts = Instant.now();

        if(quickCheck) {
            assertEquals(expectedResult, primeNumberUtil.isPrimeQuickCheck(number));
        } else {
            assertEquals(expectedResult, primeNumberUtil.isPrime(number));
        }

        Instant ends = Instant.now();
        return Duration.between(starts, ends);
    }

    private String toStrDuration(Duration duration) {
        if(duration.toMinutes() > 0) {
            return duration.toMinutes() + "minutes";
        }

        if(duration.getSeconds() > 0) {
            return duration.toSeconds() + "seconds";
        }

        if(duration.toMillis() > 0) {
            return duration.toMillis() + "millis";
        }

        return duration.toNanos() + "nanos";
    }
}
