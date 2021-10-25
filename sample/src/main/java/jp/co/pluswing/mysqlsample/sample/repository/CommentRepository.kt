package jp.co.pluswing.mysqlsample.sample.repository

import jp.co.pluswing.mysqlsample.sample.model.Comment
import org.springframework.data.repository.CrudRepository

interface CommentRepository : CrudRepository<Comment, Long>
