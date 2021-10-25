package jp.co.pluswing.mysqlsample.sample.payload

data class DeleteCommentPayload private constructor(val success: Boolean) {
    companion object {
        fun fail(): DeleteCommentPayload {
            return DeleteCommentPayload(false)
        }

        fun success(): DeleteCommentPayload {
            return DeleteCommentPayload(true)
        }
    }
}