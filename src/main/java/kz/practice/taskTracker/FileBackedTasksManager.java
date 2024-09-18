package kz.practice.taskTracker;

import kz.practice.taskTracker.entity.Epic;
import kz.practice.taskTracker.entity.SubTask;
import kz.practice.taskTracker.entity.Task;
import kz.practice.taskTracker.entity.TaskType;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileBackedTasksManager extends InMemoryTaskManager {
    private final File file;

    public FileBackedTasksManager(File file) {
        super(Managers.getDefaultHistory());
        this.file = file;
    }

    @Override
    public void createTask(Task task) {
        super.createTask(task);
        save();
    }

    @Override
    public void createEpic(Epic epic) {
        super.createEpic(epic);
        save();
    }

    @Override
    public void createSubTask(SubTask subTask) {
        super.createSubTask(subTask);
        save();
    }

    @Override
    public void updateTask(long id, Task updatedTask) {
        super.updateTask(id, updatedTask);
        save();
    }

    @Override
    public void updatedSubTask(long id, SubTask updatedSubTask) {
        super.updatedSubTask(id, updatedSubTask);
        save();
    }

    @Override
    public void updateEpic(long id, Epic updatedEpic) {
        super.updateEpic(id, updatedEpic);
        save();
    }

    @Override
    public void removeTask(long id) {
        super.removeTask(id);
        save();
    }

    @Override
    public void removeEpic(long id) {
        super.removeEpic(id);
        save();
    }

    @Override
    public void removeSubTask(long id) {
        super.removeSubTask(id);
        save();
    }

    private void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            //сохранем список всех задач, эпиков и подзадач
            for (Task task : getTasks()) {
                writer.write(toString(task));
                writer.newLine();
            }
            for (Epic epic : getEpics()) {
                writer.write(toString(epic));
                writer.newLine();
            }
            for (SubTask subTask : getSubTasks()) {
                writer.write(toString(subTask));
                writer.newLine();
            }
            writer.newLine();
            writer.write(historyToString(historyManager));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //вытаскиваем задачи историю просмотра из файла
    public static FileBackedTasksManager loadFromFile(File file) {
        FileBackedTasksManager manager = new FileBackedTasksManager(file);
        List<String> lines = new ArrayList<>();
        boolean isHistory = false;
        for (String line : lines) {
            if (line.isEmpty()) {
                isHistory = true;
                continue;
            }
        }
        return manager;
    }

    //Преобразует обзект Task в строку CSV
    private String toString(Task task) {
        StringBuilder sb = new StringBuilder();
        sb.append(task.getId()).append(",")
                .append(task.getName()).append(",")
                .append(task.getStatus()).append(",")
                .append(task.getDescription()).append(",");
        if (task instanceof SubTask) {
            sb.append(((SubTask) task).getEpic().getId());
        }
        return sb.toString();
    }

    //преобразует фпйл CSV в объект Task
    private static Task fromString(String task) {
        String[] fields = task.split(",");
        int id = Integer.parseInt(fields[0]);
        TaskType type = TaskType.valueOf(fields[1]);
        String name = fields[2];
        Status status = Status.valueOf(fields[3]);
        String description = fields[4];

        switch (type) {
            case TASK -> {
                return new Task(name, description);
            }
            case EPIC -> {
                return new Epic(name, description);
            }
            case SUBTASK -> {
                int epicId = Integer.parseInt(fields[5]);
                return new SubTask(name, description, new Epic(name, description));
            }
            default -> throw new RuntimeException("Invalid task type");
        }

    }

    // Сохранение истории просмотра
    private static String historyToString(HistoryManager manager) {
        StringBuilder sb = new StringBuilder();
        for (Task task : manager.getHistory()) {
            sb.append(task.getId()).append(",");
        }
        // Удаляем последнюю запятую в CSV
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    // Восстановление истории просмотра
    private static List<Integer> historyFromString(String value) {
        List<Integer> history = new ArrayList<>();
        if (!value.isEmpty()) {
            String[] ids = value.split(",");
            for (String id : ids) {
                history.add(Integer.parseInt(id));
            }
        }
        return history;
    }
}