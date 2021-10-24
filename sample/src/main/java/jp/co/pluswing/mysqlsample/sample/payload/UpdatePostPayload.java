package jp.co.pluswing.mysqlsample.sample.payload;

import jp.co.pluswing.mysqlsample.sample.model.Post;

public class UpdatePostPayload {
    private UpdatePostPayload(Boolean success, Post post) {
        this.success = success;
        this.post = post;
    }

    public final Boolean success;
    public final Post post;

    public static UpdatePostPayload fail() {
        return new UpdatePostPayload(false, null);
    }

    public static UpdatePostPayload success(Post post) {
        return new UpdatePostPayload(true, post);
    }
}
