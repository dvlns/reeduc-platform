package com.teacher_service.teacher_service.controller.response;

import lombok.Builder;

@Builder
public record ContentResponse(
        Long id,
        String title,
        String description,
        String embedLink
) {}