package ru.practicum.myblogbackapp.repository.post;

import org.springframework.data.repository.CrudRepository;
import ru.practicum.myblogbackapp.model.post.PostImage;

import java.util.Optional;

public interface PostImageRepository extends CrudRepository<PostImage, Long> {
    Optional<PostImage> findByPostId(Long postId);
}