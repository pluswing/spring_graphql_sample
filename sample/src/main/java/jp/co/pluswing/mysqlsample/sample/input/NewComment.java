package jp.co.pluswing.mysqlsample.sample.input;

import jp.co.pluswing.mysqlsample.sample.model.Comment;
import jp.co.pluswing.mysqlsample.sample.model.Post;

import java.util.Date;

public class NewComment {
    public NewComment(Long postId, String name, String content) {
        this.postId = postId;
        this.name = name;
        this.content = content;
    }

    public final Long postId;
    public final String name;
    public final String content;

    public Comment toEntity(Post post) {
        Comment c = new Comment(post);
        c.name = name;
        c.content = content;
        return c;
    }
}
