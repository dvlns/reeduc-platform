package com.teacher_service.teacher_service.controller.request;

import lombok.Builder;

@Builder
public record ContentRequest(
        String title,
        String description,
        String embedLink
) {}
