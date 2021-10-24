package jp.co.pluswing.mysqlsample.sample.repository;

import jp.co.pluswing.mysqlsample.sample.model.Comment;
import jp.co.pluswing.mysqlsample.sample.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
