package ru.practicum.myblogbackapp.service.comment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.practicum.myblogbackapp.config.repository.RepositoryMockConfig;
import ru.practicum.myblogbackapp.config.service.CommentServiceConfig;
import ru.practicum.myblogbackapp.dto.comment.CommentDto;
import ru.practicum.myblogbackapp.dto.comment.NewCommentDto;
import ru.practicum.myblogbackapp.mapper.comment.CommentMapper;
import ru.practicum.myblogbackapp.model.comment.Comment;
import ru.practicum.myblogbackapp.repository.comment.CommentRepository;
import ru.practicum.myblogbackapp.repository.post.PostRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextHierarchy({
        @ContextConfiguration(name = "repo-mock", classes = RepositoryMockConfig.class),
        @ContextConfiguration(name = "comment-service",  classes = CommentServiceConfig.class)
})
class CommentServiceImplTest {
    @Autowired
    private CommentServiceImpl commentService;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    void setUp() {
        reset(commentRepository, postRepository);
    }

    @Test
    void shouldCreateAndSaveComment_whenPostExistsAndDtoValid() {
        // Given
        Long postId = 123L;
        when(postRepository.existsById(postId)).thenReturn(true);

        Comment comment = Comment.builder().postId(postId).text("Test text").build();
        when(commentRepository.save(any())).thenReturn(comment);

        NewCommentDto newCommentDto = NewCommentDto.builder().postId(postId).text(comment.getText()).build();

        // When
        CommentDto commentDto = commentService.createComment(postId, newCommentDto);

        // Then
        assertEquals(newCommentDto.getPostId(), commentDto.getPostId());
        assertEquals(newCommentDto.getText(), commentDto.getText());

        verify(commentRepository, times(1)).save(argThat(c -> c.getPostId().equals(postId)));
    }
}