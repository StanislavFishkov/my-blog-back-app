package ru.practicum.myblogbackapp.controller;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.practicum.myblogbackapp.dto.post.NewPostDto;
import ru.practicum.myblogbackapp.dto.post.PostDto;
import ru.practicum.myblogbackapp.dto.post.view.PostPreview;
import ru.practicum.myblogbackapp.dto.post.PostsDto;
import ru.practicum.myblogbackapp.dto.post.UpdatePostDto;

@Slf4j
@RestController
@RequestMapping("/api/posts")
public class PostController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto createPost(@Valid @RequestBody NewPostDto newPostDto) {
        log.info("POST /api/posts with params(newPostDto {})", newPostDto);
        return null;
    }

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable("id") Long postId) {
        log.info("GET /api/posts/{id} with params(id {})", postId);
        return null;
    }

    @GetMapping
    @JsonView(PostPreview.class)
    public PostsDto findPosts(@RequestParam("search") String search,
                              @RequestParam("pageNumber") String pageNumber,
                              @RequestParam("pageSize") String pageSize) {
        log.info("GET /api/posts with params(search {}, pageNumber {}, pageSize {})", search, pageNumber, pageSize);
        return null;
    }

    @PutMapping("/{id}")
    public PostDto updatePost(@PathVariable("id") Long postId, @Valid @RequestBody UpdatePostDto updatePostDto) {
        log.info("PUT /api/posts/{id} with params(id {}, newPostDto {})", postId, updatePostDto);
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Long postId) {
        log.info("DELETE /api/posts/{id} with params(id {})", postId);
    }

    @PostMapping("/{id}/likes")
    public Integer likePost(@PathVariable("id") Long postId) {
        log.info("POST /api/posts/{id}/likes with params(id {})", postId);
        return null;
    }

    @PutMapping("/{id}/image")
    public void updatePostImage(@PathVariable("id") Long postId, @RequestParam("image") MultipartFile imageFile) {
        log.info("PUT /api/posts/{id}/image with params(id {})", postId);
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getPostImage(@PathVariable("id") Long postId) {
        log.info("GET /api/posts/{id}/image with params(id {})", postId);

        byte[] imageData = null;

        if (imageData == null || imageData.length == 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .contentLength(imageData.length)
                .body(imageData);
    }
}