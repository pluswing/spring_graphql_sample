package jp.co.pluswing.mysqlsample.sample.input

import jp.co.pluswing.mysqlsample.sample.model.Post

data class NewPost(val author: String, val category: String, val title: String, val content: String) {
    fun toEntity(): Post {
        val it = this
        return Post().apply {
            author = it.author
            category = it.category
            title = it.title
            content = it.content
        }
    }
}