package jp.co.pluswing.mysqlsample.sample.input;

import jp.co.pluswing.mysqlsample.sample.model.Post;

public class UpdatePost {
    public UpdatePost(Long id, String author, String category, String title, String content) {
        this.id = id;
        this.author = author;
        this.category = category;
        this.title = title;
        this.content = content;
    }

    public final Long id;
    public final String author;
    public final String category;
    public final String title;
    public final String content;

    public void overwrite(Post post) {
        if (author != null) {
            post.author = author;
        }
        if (category != null) {
            post.category = category;
        }
        if (title != null) {
            post.title = title;
        }
        if (content != null) {
            post.content = content;
        }
    }
}
