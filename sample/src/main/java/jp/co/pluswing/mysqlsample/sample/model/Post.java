package jp.co.pluswing.mysqlsample.sample.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    public String author;

    @Column(nullable = false)
    public String category;

    @Column(nullable = false)
    public String title;

    @Lob
    @Column(nullable = false, length = 65535)
    public String content;

    @OneToMany()
    @JoinColumn(name = "post_id", nullable = false, insertable = false, updatable = false)
    public List<Comment> comments;
}
