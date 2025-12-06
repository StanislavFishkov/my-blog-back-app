package ru.practicum.myblogbackapp.service.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.practicum.myblogbackapp.config.repository.RepositoryMockConfig;
import ru.practicum.myblogbackapp.config.service.PostServiceConfig;
import ru.practicum.myblogbackapp.dto.post.NewPostDto;
import ru.practicum.myblogbackapp.dto.post.PostDto;
import ru.practicum.myblogbackapp.mapper.post.PostMapper;
import ru.practicum.myblogbackapp.model.post.Post;
import ru.practicum.myblogbackapp.repository.comment.CommentRepository;
import ru.practicum.myblogbackapp.repository.post.PostImageRepository;
import ru.practicum.myblogbackapp.repository.post.PostRepository;
import ru.practicum.myblogbackapp.repository.tag.TagRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextHierarchy({
        @ContextConfiguration(name = "repo-mock", classes = RepositoryMockConfig.class),
        @ContextConfiguration(name = "post-service",  classes = PostServiceConfig.class)
})
class PostServiceImplTest {
    @Autowired
    private PostServiceImpl postService;

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostImageRepository postImageRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private TagRepository tagRepository;

    @BeforeEach
    void setUp() {
        reset(postRepository, postImageRepository,  commentRepository, tagRepository);
    }

    @Test
    void shouldCreateAndSavePost_whenDtoValid() {
        // Given
        Long postId = 123L;
        String title = "Test title";
        String text = "Test text";
        List<String> tags = List.of("tag1", "tag2");

        Post post = Post.builder().id(postId).title(title).text(text).build();
        when(postRepository.save(any())).thenReturn(post);

        NewPostDto newPostDto = NewPostDto.builder().title(title).text(text).tags(tags).build();

        // When
        PostDto postDto = postService.createPost(newPostDto);

        // Then
        assertEquals(postId, postDto.getId());
        assertEquals(newPostDto.getTitle(), postDto.getTitle());
        assertEquals(newPostDto.getText(), postDto.getText());
        assertEquals(newPostDto.getTags(), postDto.getTags());

        verify(postRepository, times(1)).save(argThat(p -> p.getTitle().equals(title)));
        verify(tagRepository, times(1)).upsertTagsAndAssignToPost(eq(postId),
                argThat(t -> t.equals(tags)));
    }
}