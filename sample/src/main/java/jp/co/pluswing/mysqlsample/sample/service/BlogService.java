package jp.co.pluswing.mysqlsample.sample.service;

import graphql.com.google.common.collect.Lists;
import jp.co.pluswing.mysqlsample.sample.input.NewComment;
import jp.co.pluswing.mysqlsample.sample.input.NewPost;
import jp.co.pluswing.mysqlsample.sample.input.UpdatePost;
import jp.co.pluswing.mysqlsample.sample.model.Comment;
import jp.co.pluswing.mysqlsample.sample.model.Post;
import jp.co.pluswing.mysqlsample.sample.payload.AddCommentPayload;
import jp.co.pluswing.mysqlsample.sample.payload.UpdatePostPayload;
import jp.co.pluswing.mysqlsample.sample.repository.CommentRepository;
import jp.co.pluswing.mysqlsample.sample.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    public BlogService() {
    }

    public BlogService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public Post addPost(NewPost post) {
        return postRepository.save(post.toEntity());
    }

    public Post updatePost(UpdatePost post) throws Exception {
        Post p = postRepository.findById(post.id).orElse(null);
        if (p == null) {
            throw new Exception("post not found.");
        }
        post.overwrite(p);
        return postRepository.save(p);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public Comment addComment(NewComment comment) throws Exception {
        Post post = postRepository.findById(comment.postId).orElse(null);
        if (post == null) {
            throw new Exception("post not found.");
        }
        Comment c = comment.toEntity(post);
        return commentRepository.save(c);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> allPost() {
        return Lists.newArrayList(postRepository.findAll());
    }

    public List<Post> findPostByAuthor(String author) {
        return postRepository.findByAuthor(author);
    }

    public List<Post> findPostByCategory(String category) {
        return postRepository.findByCategory(category);
    }

    public List<Comment> allComment() {
        return Lists.newArrayList(commentRepository.findAll());
    }
}
