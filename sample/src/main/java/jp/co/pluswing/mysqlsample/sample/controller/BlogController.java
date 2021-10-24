package jp.co.pluswing.mysqlsample.sample.controller;

import graphql.com.google.common.collect.Lists;
import jp.co.pluswing.mysqlsample.sample.input.NewComment;
import jp.co.pluswing.mysqlsample.sample.input.NewPost;
import jp.co.pluswing.mysqlsample.sample.input.UpdatePost;
import jp.co.pluswing.mysqlsample.sample.model.Comment;
import jp.co.pluswing.mysqlsample.sample.model.Post;
import jp.co.pluswing.mysqlsample.sample.payload.*;
import jp.co.pluswing.mysqlsample.sample.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogService service;

    @QueryMapping
    public Post post(@Argument Long id) {
        return service.getPostById(id);
    }

    @QueryMapping
    public List<Post> posts() {
        return service.allPost();
    }

    @QueryMapping
    public List<Post> postsByAuthor(@Argument String author) {
        return service.findPostByAuthor(author);
    }

    @QueryMapping
    public List<Post> postsByCategory(@Argument String category) {
        return service.findPostByCategory(category);
    }

    @QueryMapping
    public List<Comment> comments() {
        return service.allComment();
    }

    @MutationMapping
    public AddPostPayload addPost(@Argument NewPost post) {
        try {
            Post p = service.addPost(post);
            return AddPostPayload.success(p);
        } catch (Exception e) {
            return AddPostPayload.fail();
        }
    }

    @MutationMapping
    public DeletePostPayload deletePost(@Argument Long id) {
        try {
            service.deletePost(id);
            return DeletePostPayload.success();
        } catch (Exception e) {
            return DeletePostPayload.fail();
        }
    }

    @MutationMapping
    public UpdatePostPayload updatePost(@Argument UpdatePost post) {
        try {
            Post p = service.updatePost(post);
            return UpdatePostPayload.success(p);
        } catch (Exception e) {
            return UpdatePostPayload.fail();
        }
    }

    @MutationMapping
    public AddCommentPayload addComment(@Argument NewComment comment) {
        try {
            Comment c = service.addComment(comment);
            return AddCommentPayload.success(c);
        } catch (Exception e) {
            return AddCommentPayload.fail();
        }
    }

    @MutationMapping
    public DeleteCommentPayload deleteComment(@Argument Long id) {
        try {
            service.deleteComment(id);
            return DeleteCommentPayload.success();
        } catch (Exception e) {
            return DeleteCommentPayload.fail();
        }
    }
}
