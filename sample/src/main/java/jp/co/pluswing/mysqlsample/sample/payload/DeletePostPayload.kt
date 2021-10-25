package jp.co.pluswing.mysqlsample.sample.payload

data class DeletePostPayload private constructor(val success: Boolean) {
    companion object {
        fun fail(): DeletePostPayload {
            return DeletePostPayload(false)
        }

        fun success(): DeletePostPayload {
            return DeletePostPayload(true)
        }
    }
}