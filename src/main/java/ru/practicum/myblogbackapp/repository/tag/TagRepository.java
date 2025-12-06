package ru.practicum.myblogbackapp.repository.tag;

import org.springframework.data.repository.CrudRepository;
import ru.practicum.myblogbackapp.model.tag.Tag;

public interface TagRepository extends CrudRepository<Tag, Long>, TagRepositoryCustom {
}