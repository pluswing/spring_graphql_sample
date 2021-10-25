package jp.co.pluswing.mysqlsample.sample.repository

import jp.co.pluswing.mysqlsample.sample.model.Post
import org.springframework.data.repository.CrudRepository

interface PostRepository : CrudRepository<Post, Long> {
    // where author = ?
    fun findByAuthor(author: String): List<Post>

    // where category = ?
    fun findByCategory(category: String): List<Post>
}