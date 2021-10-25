package jp.co.pluswing.mysqlsample.sample.payload

import jp.co.pluswing.mysqlsample.sample.model.Post

data class UpdatePostPayload private constructor(val success: Boolean, val post: Post?) {
    companion object {
        fun fail(): UpdatePostPayload {
            return UpdatePostPayload(false, null)
        }

        fun success(post: Post): UpdatePostPayload {
            return UpdatePostPayload(true, post)
        }
    }
}