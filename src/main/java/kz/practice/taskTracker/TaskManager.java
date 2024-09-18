package kz.practice.taskTracker;

import kz.practice.taskTracker.entity.Epic;
import kz.practice.taskTracker.entity.Task;
import kz.practice.taskTracker.entity.Epic;
import kz.practice.taskTracker.entity.Task;
import kz.practice.taskTracker.entity.SubTask;

import java.util.List;

public interface TaskManager {

    List<Task> getTasks();

    List<SubTask> getSubTasks();

    List<Epic> getEpics();

    Task getTaskById(long id);

    SubTask getSubTaskById(long id);

    Epic getEpicById(long id);

    void createTask(Task task);

    void createSubTask(SubTask subTask);

    void createEpic(Epic epic);

    void updateTask(long id, Task updatedTask);

    void updatedSubTask(long id, SubTask updatedSubTask);

    void updateEpic(long id, Epic updatedEpic);

    void removeTask(long id);

    void removeSubTask(long id);

    void removeEpic(long id);

    long getUniqueId();
}