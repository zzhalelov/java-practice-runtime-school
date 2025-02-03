package kz.practice.http.part_1.task_5;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private int id;
    private String text;
    private List<Comment> comments = new ArrayList<>();

    public Post() {
    }

    public Post(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public int getId() {
        return id;
    }
}