package ru.practicum.myblogbackapp.repository.post;

import org.springframework.data.repository.CrudRepository;
import ru.practicum.myblogbackapp.model.post.Post;

public interface PostRepository extends CrudRepository<Post, Long>, PostRepositoryCustom {
}