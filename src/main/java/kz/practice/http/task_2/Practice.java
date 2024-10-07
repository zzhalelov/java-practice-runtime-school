package kz.practice.http.task_2;

import com.google.gson.Gson;

import java.io.IOException;

public class Practice {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        String lastLikeInfoStr = "{ \"user\": \"Амир\", \"hours\": 12, \"minutes\": 30}";
        LastLikeInfo lastLikeInfo = gson.fromJson(lastLikeInfoStr, LastLikeInfo.class); // код десериализации

        LikesInfo likesInfo = new LikesInfo();
        likesInfo.setRepostsCount(10);
        likesInfo.setHasOwnerLiked(true);
        likesInfo.setLastLikeInfo(lastLikeInfo);
        likesInfo.setLikes(new Like[]{
                new Like("Амир", "http://example.com/avatars/amir.jpg"),
                new Like("Диляра", "http://example.com/avatars/diliara.jpg"),
                new Like("Света", "http://example.com/avatars/sveta.jpg"),
        });
        // код сериализации
        String result = gson.toJson(likesInfo);
        System.out.println(result);
    }
}