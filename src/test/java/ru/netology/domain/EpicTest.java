package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EpicTest {
    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    @Test
    public void shouldMatchBetweenEnds() {
        Assertions.assertEquals(true, epic.matches("Яйца"));
    }
    @Test
    public void shouldMatchLast() {
        Assertions.assertEquals(true, epic.matches("Хлеб"));
    }
    @Test
    public void shouldMatchFirst() {
        Assertions.assertEquals(true, epic.matches("Молоко"));
    }
}
