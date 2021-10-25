package jp.co.pluswing.mysqlsample.sample.model

import jp.co.pluswing.mysqlsample.sample.model.Post
import jp.co.pluswing.mysqlsample.sample.payload.AddPostPayload
import jp.co.pluswing.mysqlsample.sample.payload.AddCommentPayload
import jp.co.pluswing.mysqlsample.sample.payload.DeletePostPayload
import jp.co.pluswing.mysqlsample.sample.payload.UpdatePostPayload
import jp.co.pluswing.mysqlsample.sample.payload.DeleteCommentPayload
import org.springframework.beans.factory.annotation.Autowired
import jp.co.pluswing.mysqlsample.sample.repository.PostRepository
import jp.co.pluswing.mysqlsample.sample.repository.CommentRepository
import jp.co.pluswing.mysqlsample.sample.input.NewPost
import kotlin.Throws
import jp.co.pluswing.mysqlsample.sample.input.UpdatePost
import jp.co.pluswing.mysqlsample.sample.input.NewComment
import jp.co.pluswing.mysqlsample.sample.service.BlogService
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.data.repository.CrudRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.jvm.JvmStatic
import org.springframework.boot.SpringApplication
import javax.persistence.*

@Entity
@Table(name = "posts")
class Post {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(nullable = false)
    var author: String? = null

    @Column(nullable = false)
    var category: String? = null

    @Column(nullable = false)
    var title: String? = null

    @Lob
    @Column(nullable = false, length = 65535)
    var content: String? = null

    @OneToMany
    @JoinColumn(name = "post_id", nullable = false, insertable = false, updatable = false)
    var comments: List<Comment>? = null
}