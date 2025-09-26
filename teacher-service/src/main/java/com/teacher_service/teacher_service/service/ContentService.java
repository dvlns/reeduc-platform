package com.teacher_service.teacher_service.service;

import com.teacher_service.teacher_service.model.Content;
import com.teacher_service.teacher_service.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository contentRepository;

    public List<Content> getAllContent(){
        return contentRepository.findAll();
    }

    public Content getContentById(Long id){
        return contentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Content not found with id " + id));
    }

    public Content create(Content content){
        return contentRepository.save(content);
    }

    public Content updateContent(Long id, Content contentDetails){
        Content content = getContentById(id);
        content.setTitle(contentDetails.getTitle());
        content.setDescription(contentDetails.getDescription());
        content.setEmbedLink(contentDetails.getEmbedLink());
        return contentRepository.save(content);
    }

    public void deleteContent(Long id){
        contentRepository.deleteById(id);
    }
}
