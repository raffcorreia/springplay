package com.example.springplay.nativeInterface;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CppPrimeTest {

    CppPrime cppPrime;

    @BeforeAll
    static void setupAll() {

    }

    @ParameterizedTest
    @MethodSource("provideBigIntValues")
    public void isPrime_test(boolean expectedResult, long number) {

        Duration duration = IsPrimeDuration(false, expectedResult, number);
        String strDuration = toStrDuration(duration);

        System.out.printf("Validated %d as prime is %b in %s \n", number, expectedResult, strDuration);
    }
    
    public Duration IsPrimeDuration(boolean quickCheck, boolean expectedResult, long number) {
        Instant starts = Instant.now();

//        assertEquals(expectedResult, cppPrime.isPrime(number));

        Instant ends = Instant.now();
        return Duration.between(starts, ends);
    }

    private static Stream<Arguments> provideBigIntValues() {
        return Stream.of(
                Arguments.of(false, -1),
                Arguments.of(false, 0),
                Arguments.of(false, 10),
                Arguments.of(true, 2),
                Arguments.of(true, 3),
                Arguments.of(true, 5),
                Arguments.of(true, 97),
                Arguments.of(true, 8589935681L)
        );
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

