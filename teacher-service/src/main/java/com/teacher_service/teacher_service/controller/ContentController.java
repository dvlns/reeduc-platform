package com.teacher_service.teacher_service.controller;

import com.teacher_service.teacher_service.controller.request.ContentRequest;
import com.teacher_service.teacher_service.controller.response.ContentResponse;
import com.teacher_service.teacher_service.mapper.ContentMapper;
import com.teacher_service.teacher_service.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contents")
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @GetMapping
    public ResponseEntity<List<ContentResponse>> getAllContents() {
        return ResponseEntity.ok(contentService.getAllContent()
                .stream()
                .map(ContentMapper::toResponse)
                .toList());
    }

    @PostMapping
    public ResponseEntity<ContentResponse> saveContent(@RequestBody ContentRequest request) {
        var content = ContentMapper.toEntity(request);
        var savedContent = contentService.create(content);
        return ResponseEntity.status(HttpStatus.CREATED).body(ContentMapper.toResponse(savedContent));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContentResponse> getContentById(@PathVariable Long id) {
        var content = contentService.getContentById(id);
        if (content == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ContentMapper.toResponse(content));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContentResponse> updateContent(@PathVariable Long id, @RequestBody ContentRequest request) {
        var existingContent = contentService.getContentById(id);
        if (existingContent == null) {
            return ResponseEntity.notFound().build();
        }

        existingContent.setTitle(request.title());
        existingContent.setDescription(request.description());
        existingContent.setEmbedLink(request.embedLink());

        var updatedContent = contentService.create(existingContent);
        return ResponseEntity.ok(ContentMapper.toResponse(updatedContent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContentById(@PathVariable Long id) {
        contentService.deleteContent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
