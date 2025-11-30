package ru.practicum.myblogbackapp.config.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.practicum.myblogbackapp.mapper.comment.CommentMapper;
import ru.practicum.myblogbackapp.service.comment.CommentService;

@Configuration
@ComponentScan(basePackageClasses = {CommentService.class, CommentMapper.class})
public class CommentServiceConfig {
}