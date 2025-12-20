package ru.practicum.myblogbackapp.config.service;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import ru.practicum.myblogbackapp.mapper.comment.CommentMapper;
import ru.practicum.myblogbackapp.service.comment.CommentService;

@TestConfiguration
@ComponentScan(basePackageClasses = {CommentService.class, CommentMapper.class})
public class CommentServiceConfig {
}