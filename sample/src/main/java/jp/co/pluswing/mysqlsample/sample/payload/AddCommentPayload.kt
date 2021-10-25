package jp.co.pluswing.mysqlsample.sample.payload

import jp.co.pluswing.mysqlsample.sample.model.Comment

data class AddCommentPayload private constructor(val success: Boolean, val comment: Comment?) {
    companion object {
        fun fail(): AddCommentPayload {
            return AddCommentPayload(false, null)
        }

        fun success(comment: Comment): AddCommentPayload {
            return AddCommentPayload(true, comment)
        }
    }
}