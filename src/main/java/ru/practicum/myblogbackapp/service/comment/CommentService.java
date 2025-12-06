package ru.practicum.myblogbackapp.service.comment;

import ru.practicum.myblogbackapp.dto.comment.CommentDto;
import ru.practicum.myblogbackapp.dto.comment.NewCommentDto;
import ru.practicum.myblogbackapp.dto.comment.UpdateCommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(Long postId, NewCommentDto newCommentDto);

    CommentDto getCommentById(Long postId, Long commentId);

    List<CommentDto> findComments(Long postId);

    CommentDto updateComment(Long postId, Long commentId, UpdateCommentDto updateCommentDto);

    void deleteCommentById(Long postId, Long commentId);
}