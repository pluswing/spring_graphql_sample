package jp.co.pluswing.mysqlsample.sample.input

import jp.co.pluswing.mysqlsample.sample.model.Post

data class UpdatePost(val id: Long, var author: String?, val category: String?, val title: String?, val content: String?) {

    fun overwrite(post: Post) {
        author?.let { post.author = it }
        category?.let { post.category = it }
        title?.let { post.title = it }
        content?.let { post.content = it }
    }

}