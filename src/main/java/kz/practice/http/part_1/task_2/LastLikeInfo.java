package kz.practice.http.part_1.task_2;

public class LastLikeInfo {
    private String name;
    private String avatarUrl;

    public LastLikeInfo() {
    }

    public LastLikeInfo(String name, String avatarUrl) {
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}