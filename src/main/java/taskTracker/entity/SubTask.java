package taskTracker.entity;

public class SubTask extends Task {
    private final Epic epic;

    public SubTask(String name, String description, Epic epic) {
        super(name, description);
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