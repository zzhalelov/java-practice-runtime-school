package kz.practice.http.part_1.task_6;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private int id;
    private String text;
    private final List<Comment> commentaries = new ArrayList<>();

    public Post() {
    }

    public Post(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public void addComment(Comment comment) {
        commentaries.add(comment);
    }

    public int getId() {
        return id;
    }

    public List<Comment> getCommentaries() {
        return commentaries;
    }
}