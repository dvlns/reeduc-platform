package com.teacher_service.teacher_service.mapper;

import com.teacher_service.teacher_service.controller.request.ContentRequest;
import com.teacher_service.teacher_service.controller.response.ContentResponse;
import com.teacher_service.teacher_service.model.Content;

public class ContentMapper {

    public static Content toEntity(ContentRequest request) {
        return Content.builder()
                .title(request.title())
                .description(request.description())
                .embedLink(request.embedLink())
                .build();
    }

    public static ContentResponse toResponse(Content content) {
        return ContentResponse.builder()
                .id(content.getId())
                .title(content.getTitle())
                .description(content.getDescription())
                .embedLink(content.getEmbedLink())
                .build();
    }
}
