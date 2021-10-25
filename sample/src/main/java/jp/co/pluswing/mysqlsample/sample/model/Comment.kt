package jp.co.pluswing.mysqlsample.sample.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "comments")
class Comment {
    constructor() {}
    constructor(post: Post) {
        createdAt = Date()
        this.post = post
    }

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(nullable = false)
    var name: String = ""

    @Lob
    @Column(nullable = false, length = 65535)
    var content: String = ""

    @Column(name = "created_at", nullable = false)
    var createdAt: Date = Date()

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    var post: Post = Post()
}