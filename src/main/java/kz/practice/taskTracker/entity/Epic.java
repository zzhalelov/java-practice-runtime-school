package kz.practice.taskTracker.entity;

import kz.practice.taskTracker.Status;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private final List<SubTask> subTasks;

    public Epic(String name, String description) {
        super(name, description);
        subTasks = new ArrayList<>();
    }

    //добавление задачи в эпик
    public void addSubTask(SubTask subTask) {
        subTasks.add(subTask);
    }

    //получить список подзадач в эпике
    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    //удаление подзадачи из эпика
    public void removeSubtask(long id) {
        for (int i = 0; i < subTasks.size(); i++) {
            if (subTasks.get(i).getId() == id) {
                subTasks.remove(i);
                break;
            }
        }
    }

    //обновление статуса
    public void updateStatus() {
        int counterDone = 0;
        int counterNew = 0;

        for (SubTask subTask : subTasks) {
            if (subTask.getStatus().equals(Status.DONE)) {
                counterDone++;
            }
        }
        if (counterDone == subTasks.size()) {
            setStatus(Status.DONE);
        }

        for (SubTask subTask : subTasks) {
            if (subTask.getStatus().equals(Status.NEW)) {
                counterNew++;
            }
        }
        if (counterNew == subTasks.size()) {
            setStatus(Status.NEW);
        }
        if (counterNew != subTasks.size() && counterDone != subTasks.size()) {
            setStatus(Status.IN_PROGRESS);
        }
    }

    @Override
    public String toString() {
        return "Epic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}