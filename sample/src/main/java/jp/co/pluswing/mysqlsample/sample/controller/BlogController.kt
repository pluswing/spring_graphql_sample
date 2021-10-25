package jp.co.pluswing.mysqlsample.sample.controller

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
import jp.co.pluswing.mysqlsample.sample.model.Comment
import jp.co.pluswing.mysqlsample.sample.service.BlogService
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.data.repository.CrudRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.jvm.JvmStatic
import org.springframework.boot.SpringApplication
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.stereotype.Controller
import java.lang.Exception

@Controller
class BlogController {
    @Autowired
    private val service: BlogService? = null

    @QueryMapping
    fun post(@Argument id: Long): Post {
        return service!!.getPostById(id)
    }

    @QueryMapping
    fun posts(): List<Post> {
        return service!!.allPost()
    }

    @QueryMapping
    fun postsByAuthor(@Argument author: String): List<Post> {
        return service!!.findPostByAuthor(author)
    }

    @QueryMapping
    fun postsByCategory(@Argument category: String): List<Post> {
        return service!!.findPostByCategory(category)
    }

    @QueryMapping
    fun comments(): List<Comment> {
        return service!!.allComment()
    }

    @MutationMapping
    fun addPost(@Argument post: NewPost): AddPostPayload {
        return try {
            val p = service!!.addPost(post)
            AddPostPayload.success(p)
        } catch (e: Exception) {
            AddPostPayload.fail()
        }
    }

    @MutationMapping
    fun deletePost(@Argument id: Long): DeletePostPayload {
        return try {
            service!!.deletePost(id)
            DeletePostPayload.success()
        } catch (e: Exception) {
            DeletePostPayload.fail()
        }
    }

    @MutationMapping
    fun updatePost(@Argument post: UpdatePost): UpdatePostPayload {
        return try {
            val p = service!!.updatePost(post)
            UpdatePostPayload.success(p)
        } catch (e: Exception) {
            UpdatePostPayload.fail()
        }
    }

    @MutationMapping
    fun addComment(@Argument comment: NewComment): AddCommentPayload {
        return try {
            val c = service!!.addComment(comment)
            AddCommentPayload.success(c)
        } catch (e: Exception) {
            AddCommentPayload.fail()
        }
    }

    @MutationMapping
    fun deleteComment(@Argument id: Long): DeleteCommentPayload {
        return try {
            service!!.deleteComment(id)
            DeleteCommentPayload.success()
        } catch (e: Exception) {
            DeleteCommentPayload.fail()
        }
    }
}