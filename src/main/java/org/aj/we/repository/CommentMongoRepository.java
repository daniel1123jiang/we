package org.aj.we.repository;

import org.aj.we.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentMongoRepository extends MongoRepository<Comment, String> {
    Comment findAllById(String id);
    List<Comment> findAllByBlogId(String blogId);
    long countByBlogId(String blogId);
}
