package kz.practice.taskTracker;

import kz.practice.taskTracker.entity.Epic;
import kz.practice.taskTracker.entity.Task;
import kz.practice.taskTracker.entity.SubTask;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("tasks.csv");
        FileBackedTasksManager fileBackedTasksManager = new FileBackedTasksManager(file);

        Task task1 = new Task("Созвон", "Созвон с заказчиками в 11:00");
        Epic epic1 = new Epic("Дела по работе", "Дела по работе");
        SubTask subTask1 = new SubTask("Демонстрация заказчику", "Продемонстрировать заказчику функционал", epic1);

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