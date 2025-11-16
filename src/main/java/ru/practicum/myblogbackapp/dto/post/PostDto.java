package ru.practicum.myblogbackapp.dto.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.myblogbackapp.dto.post.view.PostPreview;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PostDto {
    private Long id;
    private String title;
    private String text;
    private List<String> tags;
    @Builder.Default
    private Integer likesCount = 0;
    @Builder.Default
    private Integer commentsCount = 0;

    @JsonView(PostPreview.class)
    @JsonProperty("text")
    public String getPreview() {
        if (text == null) return "";
        int maxLength = 128;
        return text.length() <= maxLength ? text : text.substring(0, maxLength) + "…";
    }
}