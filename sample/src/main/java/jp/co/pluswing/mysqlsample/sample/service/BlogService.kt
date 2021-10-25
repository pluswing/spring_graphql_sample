package jp.co.pluswing.mysqlsample.sample.service

import graphql.com.google.common.collect.Lists
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
import org.springframework.stereotype.Component
import java.lang.Exception

@Component
class BlogService {
    @Autowired
    private lateinit var postRepository: PostRepository

    @Autowired
    private lateinit var commentRepository: CommentRepository

    constructor() {}
    constructor(postRepository: PostRepository, commentRepository: CommentRepository) {
        this.postRepository = postRepository
        this.commentRepository = commentRepository
    }

    fun addPost(post: NewPost): Post {
        return postRepository.save(post.toEntity())
    }

    @Throws(Exception::class)
    fun updatePost(post: UpdatePost): Post {
        val p = postRepository.findById(post.id).orElse(null) ?: throw Exception("post not found.")
        post.overwrite(p)
        return postRepository.save(p)
    }

    fun deletePost(id: Long) {
        postRepository.deleteById(id)
    }

    @Throws(Exception::class)
    fun addComment(comment: NewComment): Comment {
        val post = postRepository.findById(comment.postId).orElse(null) ?: throw Exception("post not found.")
        val c = comment.toEntity(post)
        return commentRepository.save(c)
    }

    fun deleteComment(id: Long) {
        commentRepository.deleteById(id)
    }

    fun getPostById(id: Long): Post? {
        return postRepository.findById(id).orElse(null)
    }

    fun allPost(): List<Post> {
        return Lists.newArrayList(postRepository.findAll())
    }

    fun findPostByAuthor(author: String): List<Post> {
        return postRepository.findByAuthor(author)
    }

    fun findPostByCategory(category: String): List<Post> {
        return postRepository.findByCategory(category)
    }

    fun allComment(): List<Comment> {
        return Lists.newArrayList(commentRepository.findAll())
    }
}