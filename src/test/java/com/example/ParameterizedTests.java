package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ParameterizedTests {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    void testGetKittensWithDifferentCounts(int count) {
        Feline feline = new Feline();
        assertEquals(count, feline.getKittens(count));
    }

    @ParameterizedTest
    @CsvSource({"Самец, true", "Самка, false"})
    void testLionHasManeBySex(String sex, boolean expectedHasMane) throws Exception {
        FelineBehavior felineMock = Mockito.mock(FelineBehavior.class);
        Lion lion = new Lion(sex, felineMock);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}
