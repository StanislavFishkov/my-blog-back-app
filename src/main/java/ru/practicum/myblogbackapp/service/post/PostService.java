package ru.practicum.myblogbackapp.service.post;

import org.springframework.web.multipart.MultipartFile;
import ru.practicum.myblogbackapp.dto.post.NewPostDto;
import ru.practicum.myblogbackapp.dto.post.PostDto;
import ru.practicum.myblogbackapp.dto.post.PostsDto;
import ru.practicum.myblogbackapp.dto.post.UpdatePostDto;

public interface PostService {
    PostDto createPost(NewPostDto newPostDto);

    PostDto getPostById(Long postId);

    PostsDto findPosts(String search, Integer pageNumber, Integer pageSize);

    PostDto updatePost(Long postId, UpdatePostDto updatePostDto);

    void deletePostById(Long postId);

    Integer likePost(Long postId);

    void updatePostImage(Long postId, MultipartFile imageFile);

    byte[] getPostImage(Long postId);
}