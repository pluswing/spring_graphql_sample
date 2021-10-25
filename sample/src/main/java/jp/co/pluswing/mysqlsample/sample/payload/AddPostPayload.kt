package jp.co.pluswing.mysqlsample.sample.payload

import jp.co.pluswing.mysqlsample.sample.model.Post

data class AddPostPayload private constructor(val success: Boolean, val post: Post?) {
    companion object {
        fun fail(): AddPostPayload {
            return AddPostPayload(false, null)
        }

        fun success(post: Post): AddPostPayload {
            return AddPostPayload(true, post)
        }
    }
}