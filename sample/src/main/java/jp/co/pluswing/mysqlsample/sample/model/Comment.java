package jp.co.pluswing.mysqlsample.sample.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comment {

    public Comment() {
    }

    public Comment(Post post) {
        createdAt = new Date();
        this.post = post;
    }

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    public String name;

    @Lob
    @Column(nullable = false, length = 65535)
    public String content;

    @Column(name = "created_at", nullable = false)
    public Date createdAt;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    public Post post;
}
