package jp.co.pluswing.mysqlsample.sample.payload;

import jp.co.pluswing.mysqlsample.sample.model.Post;

public class AddPostPayload {
    private AddPostPayload(Boolean success, Post post) {
        this.success = success;
        this.post = post;
    }

    public final Boolean success;
    public final Post post;

    public static AddPostPayload fail() {
        return new AddPostPayload(false, null);
    }
    public static AddPostPayload success(Post post) {
        return new AddPostPayload(true, post);
    }
}
