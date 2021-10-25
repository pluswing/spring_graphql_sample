package jp.co.pluswing.mysqlsample.sample.repository

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

interface PostRepository : CrudRepository<Post?, Long?> {
    // where author = ?
    fun findByAuthor(author: String?): List<Post?>?

    // where category = ?
    fun findByCategory(category: String?): List<Post?>?
}