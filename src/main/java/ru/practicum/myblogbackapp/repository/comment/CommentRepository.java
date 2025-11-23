package ru.practicum.myblogbackapp.repository.comment;

import org.springframework.data.repository.CrudRepository;
import ru.practicum.myblogbackapp.model.comment.Comment;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long>, CommentRepositoryCustom {
    long countByPostId(Long postId);

    List<Comment> findAllByPostId(Long postId);
}