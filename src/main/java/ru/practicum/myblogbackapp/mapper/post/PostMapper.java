package ru.practicum.myblogbackapp.mapper.post;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.myblogbackapp.dto.post.NewPostDto;
import ru.practicum.myblogbackapp.dto.post.PostDto;
import ru.practicum.myblogbackapp.model.post.Post;

import java.util.List;

@Mapper
public interface PostMapper {
    PostDto toDto(Post post);

    List<PostDto> toDto(List<Post> posts);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "likesCount", ignore = true)
    Post toEntity(NewPostDto newPostDto);
}
