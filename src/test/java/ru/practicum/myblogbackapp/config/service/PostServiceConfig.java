package ru.practicum.myblogbackapp.config.service;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import ru.practicum.myblogbackapp.mapper.post.PostMapper;
import ru.practicum.myblogbackapp.service.post.PostService;

@TestConfiguration
@ComponentScan(basePackageClasses = {PostService.class, PostMapper.class})
public class PostServiceConfig {
}