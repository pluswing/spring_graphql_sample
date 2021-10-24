package jp.co.pluswing.mysqlsample.sample.repository;

import jp.co.pluswing.mysqlsample.sample.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    // where author = ?
    public List<Post> findByAuthor(String author);

    // where category = ?
    public List<Post> findByCategory(String category);
}
