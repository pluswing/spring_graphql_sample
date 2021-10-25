package jp.co.pluswing.mysqlsample.sample.model

import javax.persistence.*

@Entity
@Table(name = "posts")
class Post {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(nullable = false)
    var author: String = ""

    @Column(nullable = false)
    var category: String = ""

    @Column(nullable = false)
    var title: String = ""

    @Lob
    @Column(nullable = false, length = 65535)
    var content: String = ""

    @OneToMany
    @JoinColumn(name = "post_id", nullable = false, insertable = false, updatable = false)
    var comments: List<Comment> = arrayListOf()
}