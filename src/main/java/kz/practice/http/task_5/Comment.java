package kz.practice.http.task_5;

public class Comment {
    private String user;
    private String text;

    public Comment() {
    }

    public Comment(String user, String text) {
        this.user = user;
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public String getText() {
        return text;
    }
}