package ru.practicum.myblogbackapp.mapper.comment;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.practicum.myblogbackapp.dto.comment.CommentDto;
import ru.practicum.myblogbackapp.dto.comment.NewCommentDto;
import ru.practicum.myblogbackapp.dto.comment.UpdateCommentDto;
import ru.practicum.myblogbackapp.model.comment.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {
    CommentDto toDto(Comment comment);

    List<CommentDto> toDto(List<Comment> comments);

    @Mapping(target = "id", ignore = true)
    Comment update(@MappingTarget Comment comment, UpdateCommentDto updateCommentDto);

    @Mapping(target = "id", ignore = true)
    Comment toEntity(NewCommentDto newCommentDto);
}