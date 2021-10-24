package jp.co.pluswing.mysqlsample.sample.payload;

public class DeletePostPayload {
    private DeletePostPayload(Boolean success) {
        this.success = success;
    }

    public final Boolean success;

    public static DeletePostPayload fail() {
        return new DeletePostPayload(false);
    }
    public static DeletePostPayload success() {
        return new DeletePostPayload(true);
    }
}
