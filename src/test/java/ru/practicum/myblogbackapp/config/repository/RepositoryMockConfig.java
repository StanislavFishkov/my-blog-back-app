package ru.practicum.myblogbackapp.config.repository;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ru.practicum.myblogbackapp.repository.comment.CommentRepository;
import ru.practicum.myblogbackapp.repository.post.PostImageRepository;
import ru.practicum.myblogbackapp.repository.post.PostRepository;
import ru.practicum.myblogbackapp.repository.tag.TagRepository;

import static org.mockito.Mockito.mock;

@TestConfiguration
public class RepositoryMockConfig {
    @Bean
    public PostRepository postRepository()
    {
        return mock(PostRepository.class);
    }

    @Bean
    public PostImageRepository postImageRepository()
    {
        return mock(PostImageRepository.class);
    }

    @Bean
    public CommentRepository commentRepository()
    {
        return mock(CommentRepository.class);
    }

    @Bean
    public TagRepository tagRepository()
    {
        return mock(TagRepository.class);
    }
}