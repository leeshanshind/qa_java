package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AlexTest {

    @Mock
    private FelineBehavior felineMock;

    private Alex alex;

    @BeforeEach
    void setUp() throws Exception {
        alex = new Alex(felineMock);
    }

    @Test
    void testGetFriends() {
        assertEquals(List.of("Марти", "Глория", "Мелман"), alex.getFriends());
    }

    @Test
    void testGetPlaceOfLiving() {
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    void testGetKittensIsZero() {
        assertEquals(0, alex.getKittens());
    }

    @Test
    void testAlexIsMale() {
        assertTrue(alex.doesHaveMane());
    }
}
