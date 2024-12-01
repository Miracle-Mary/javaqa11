package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MeetingTest {

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void shouldMatchProject() {
        Assertions.assertEquals(true, meeting.matches("Приложение НетоБанка"));
    }

    @Test
    public void shouldMatchTopic() {
        Assertions.assertEquals(true, meeting.matches("Выкатка 3й версии приложения"));
    }
}
