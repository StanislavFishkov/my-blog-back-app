package ru.practicum.myblogbackapp.config.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.practicum.myblogbackapp.mapper.post.PostMapper;
import ru.practicum.myblogbackapp.service.post.PostService;

@Configuration
@ComponentScan(basePackageClasses = {PostService.class, PostMapper.class})
public class PostServiceConfig {
}