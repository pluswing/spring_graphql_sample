package jp.co.pluswing.mysqlsample.sample.input

import jp.co.pluswing.mysqlsample.sample.model.Post
import javax.persistence.GeneratedValue
import javax.persistence.Lob
import javax.persistence.JoinColumn
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

class UpdatePost(id: Long?, author: String?, category: String?, title: String?, content: String?) {
    val id: Long
    val author: String?
    val category: String?
    val title: String?
    val content: String?
    fun overwrite(post: Post) {
        if (author != null) {
            post.author = author
        }
        if (category != null) {
            post.category = category
        }
        if (title != null) {
            post.title = title
        }
        if (content != null) {
            post.content = content
        }
    }

    init {
        this.id = id!!
        this.author = author
        this.category = category
        this.title = title
        this.content = content
    }
}