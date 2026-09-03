package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Feline felineMock;

    @Test
    void testInvalidSexThrowsException() {
        assertThrows(Exception.class, () -> new Lion("Неизвестно", felineMock));
    }

    @Test
    void testGetKittens() throws Exception {
        when(felineMock.getKittens()).thenReturn(2);
        Lion lion = new Lion("Самец", felineMock);

        assertEquals(2, lion.getKittens());
        verify(felineMock).getKittens();
    }

    @Test
    void testGetFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expected);
        Lion lion = new Lion("Самец", felineMock);

        List<String> actual = lion.getFood();

        assertEquals(expected, actual);
        verify(felineMock).getFood("Хищник");
    }
}
