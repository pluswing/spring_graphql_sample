package jp.co.pluswing.mysqlsample.sample.payload;

import jp.co.pluswing.mysqlsample.sample.model.Comment;

public class AddCommentPayload {
    private AddCommentPayload(Boolean success, Comment comment) {
        this.success = success;
        this.comment = comment;
    }

    public final Boolean success;
    public final Comment comment;

    public static AddCommentPayload fail() {
        return new AddCommentPayload(false, null);
    }

    public static AddCommentPayload success(Comment comment) {
        return new AddCommentPayload(true, comment);
    }
}
