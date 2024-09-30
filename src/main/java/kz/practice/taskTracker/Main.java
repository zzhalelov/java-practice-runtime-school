package kz.practice.taskTracker;

import kz.practice.taskTracker.entity.Epic;
import kz.practice.taskTracker.entity.Task;
import kz.practice.taskTracker.entity.SubTask;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("tasks.csv");
        FileBackedTasksManager fileBackedTasksManager = new FileBackedTasksManager(file);

        Task task1 = new Task(1, "Созвон", "Созвон с заказчиками в 11:00", Status.NEW);
        Epic epic1 = new Epic(1, "Дела по работе", "Дела по работе", Status.NEW);
        SubTask subTask1 = new SubTask(1, "Демонстрация заказчику", "Продемонстрировать заказчику функционал", Status.NEW, epic1);

        fileBackedTasksManager.createTask(task1);
        fileBackedTasksManager.createEpic(epic1);
        fileBackedTasksManager.createSubTask(subTask1);

        fileBackedTasksManager.getSubTaskById(task1.getId());
        fileBackedTasksManager.getEpicById(epic1.getId());
        fileBackedTasksManager.getSubTaskById(subTask1.getId());

        FileBackedTasksManager loadManager = FileBackedTasksManager.loadFromFile(file);

        System.out.println("Задачи: " + loadManager.getTasks());
        System.out.println("История посмотра: " + loadManager.historyManager.getHistory());

    }
}