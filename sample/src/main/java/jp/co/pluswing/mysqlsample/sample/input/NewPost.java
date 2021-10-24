package jp.co.pluswing.mysqlsample.sample.input;

import jp.co.pluswing.mysqlsample.sample.model.Post;

public class NewPost {
    public NewPost(String author, String category, String title, String content) {
        this.author = author;
        this.category = category;
        this.title = title;
        this.content = content;
    }

    public final String author;
    public final String category;
    public final String title;
    public final String content;

    public Post toEntity() {
        Post p = new Post();
        p.author = author;
        p.category = category;
        p.title = title;
        p.content = content;
        return p;
    }
}
