package jp.co.pluswing.mysqlsample.sample.input

import jp.co.pluswing.mysqlsample.sample.model.Post
import jp.co.pluswing.mysqlsample.sample.model.Comment

data class NewComment(val postId: Long, val name: String, val content: String) {
    fun toEntity(post: Post?): Comment {
        val c = Comment(post)
        c.name = name
        c.content = content
        return c
    }
}