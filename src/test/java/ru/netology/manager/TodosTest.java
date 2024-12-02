package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Epic;
import ru.netology.domain.Meeting;
import ru.netology.domain.SimpleTask;
import ru.netology.domain.Task;

public class TodosTest {
    Todos todos = new Todos();

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void shouldAddThreeTasksOfDifferentType() {

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchNoTask() {

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Яблоки");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchOneTask() {

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchThreeTasks() {

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        SimpleTask simpleTask1 = new SimpleTask(8, "Выкатка 3й версии приложения");

        Meeting meeting1 = new Meeting(
                99,
                "Выкатка 3й версии приложения",
                "Приложение ЗимаБанка",
                "Во вторник с утра"
        );

        todos.add(simpleTask1);
        todos.add(meeting1);


        Task[] expected = {meeting, simpleTask1, meeting1};
        Task[] actual = todos.search("Выкатка 3й версии приложения");
        Assertions.assertArrayEquals(expected, actual);
    }



}
