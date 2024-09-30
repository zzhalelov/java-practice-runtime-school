package kz.practice.taskTracker.entity;

import kz.practice.taskTracker.Status;

//базовый класс, от которого будут унаследованы классы SubTask и Epic
public class Task {
    protected long id;
    protected String name;
    protected String description;
    protected Status status;

    //конструктор
    public Task(int id, String name, String description, Status status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = Status.NEW; //по умолчанию статус должен быть NEW
    }

    //настроить геттеры и сеттеры для полей
    public long getId() {
        return (int) id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    //метод toString
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}