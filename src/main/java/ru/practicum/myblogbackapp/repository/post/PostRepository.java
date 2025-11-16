package ru.practicum.myblogbackapp.repository.post;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.practicum.myblogbackapp.model.post.Post;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    @Query("""
        SELECT * FROM "posts"
        ORDER BY id
        LIMIT :limit OFFSET :offset
    """)
    List<Post> findPosts(@Param("limit") int limit, @Param("offset") int offset);

    @Query("""
        SELECT * FROM "posts"
        WHERE LOWER(title) LIKE LOWER(CONCAT('%', :search, '%'))
        ORDER BY id
        LIMIT :limit OFFSET :offset
    """)
    List<Post> findPosts(@Param("search") String search, @Param("limit") int limit, @Param("offset") int offset);

    @Query("""
        SELECT COUNT(*) FROM "posts"
        WHERE LOWER(title) LIKE LOWER(CONCAT('%', :search, '%'))
    """)
    long countPosts(@Param("search") String search);
}
