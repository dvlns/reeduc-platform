package com.teacher_service.teacher_service.repository;

import com.teacher_service.teacher_service.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}
