package ru.practicum.myblogbackapp.repository.comment;

import ru.practicum.myblogbackapp.model.comment.Comment;

import java.util.List;
import java.util.Map;

public interface CommentRepositoryCustom {
    Map<Long, Long> countGroupedByPostId(List<Long> postIds);

    Map<Long, List<Comment>> findGroupedByPostId(List<Long> postIds);
}
