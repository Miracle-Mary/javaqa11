package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleTaskTest {
    @Test
    public void shouldMatchTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Assertions.assertEquals(true, simpleTask.matches("Позвонить родителям"));
    }
}
