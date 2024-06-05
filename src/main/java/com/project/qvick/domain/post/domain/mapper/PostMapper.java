package com.project.qvick.domain.post.domain.mapper;

import com.project.qvick.domain.post.client.dto.Post;
import com.project.qvick.domain.post.client.dto.request.PostRegisterRequest;
import com.project.qvick.domain.post.domain.PostEntity;
import com.project.qvick.global.annotation.Mapper;

@Mapper
public class PostMapper {

    public PostEntity toEntity(PostRegisterRequest request, String author) {
        return PostEntity.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(author)
                .build();
    }

    public Post toPost(PostEntity postEntity) {
        return Post.builder()
                .id(postEntity.getId())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .author(postEntity.getAuthor())
                .build();
    }

}
