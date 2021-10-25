package jp.co.pluswing.mysqlsample.sample.input

import jp.co.pluswing.mysqlsample.sample.model.Post

data class NewPost(val author: String, val category: String, val title: String, val content: String) {
    fun toEntity(): Post {
        return Post().apply {
            this.author = author
            this.category = category
            this.title = title
            this.content = content
        }
    }
}