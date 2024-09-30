package kz.practice.taskTracker.entity;

import kz.practice.taskTracker.Status;

public class SubTask extends Task {
    private final Epic epic;

    public SubTask(int id, String name, String description, Status status, Epic epic) {
        super(id, name, description, status);
        this.epic = epic;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

    //метод, чтобы вытаскивать id эпика
    public Epic getEpic() {
        return epic;
    }
}