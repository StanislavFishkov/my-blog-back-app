package ru.practicum.myblogbackapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(
        // Cоздаёт mock-версию веб-слоя, без запуска реального сервера
        webEnvironment = SpringBootTest.WebEnvironment.MOCK
)
// Включим автоконфигурирование MockMvc
@AutoConfigureMockMvc
class PostControllerTest {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        // Очистим БД
        jdbc.update("DELETE FROM \"posts\"", Collections.emptyMap());
        jdbc.update("DELETE FROM \"tags\"", Collections.emptyMap());
    }

    @Test
    void shouldCreateAndSavePost_whenDtoValid() throws Exception {
        // Given
        String title = "Название поста 3";
        String text = "Текст поста в формате Markdown...";
        List<String> tags = List.of("tag_1", "tag_2");

        String json = """
                    {
                    "title": "%s",
                    "text": "%s",
                    "tags": %s
                    }
                """.formatted(title,  text, objectMapper.writeValueAsString(tags));

        // When + Then
        mockMvc.perform(
                        post("/api/posts")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value(title))
                .andExpect(jsonPath("$.text").value(text))
                .andExpect(jsonPath("$.tags", hasSize(2)))
                .andExpect(jsonPath("$.tags", containsInAnyOrder(tags.toArray())))
                .andExpect(jsonPath("$.likesCount").value(0))
                .andExpect(jsonPath("$.commentsCount").value(0));
    }
}