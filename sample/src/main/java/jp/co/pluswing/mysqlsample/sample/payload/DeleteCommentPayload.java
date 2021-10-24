package jp.co.pluswing.mysqlsample.sample.payload;

public class DeleteCommentPayload {
    private DeleteCommentPayload(Boolean success) {
        this.success = success;
    }

    public final Boolean success;

    public static DeleteCommentPayload fail() {
        return new DeleteCommentPayload(false);
    }

    public static DeleteCommentPayload success() {
        return new DeleteCommentPayload(true);
    }
}
