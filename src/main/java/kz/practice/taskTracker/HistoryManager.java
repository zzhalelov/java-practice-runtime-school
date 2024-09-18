package kz.practice.taskTracker;

import kz.practice.taskTracker.entity.Task;
import kz.practice.taskTracker.entity.Task;

import java.util.List;

public interface HistoryManager {
    void add(Task task);

    void remove(int id);

    List<Task> getHistory();
}