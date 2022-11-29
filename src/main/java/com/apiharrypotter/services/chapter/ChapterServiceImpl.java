package com.apiharrypotter.services.chapter;

import com.apiharrypotter.entities.Chapter;
import com.apiharrypotter.repositories.chapter.ChapterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChapterServiceImpl implements ChapterService {

    private final ChapterRepository chapterRepository;

    public ChapterServiceImpl(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    @Override
    public List<Chapter> getAllChapter() {
        return chapterRepository.findAll();
    }

    @Override
    public Optional<Chapter> getChapterById(Long id) {
        return chapterRepository.findById(id);
    }

    @Override
    public Chapter addChapter(Chapter chapter) {
        chapterRepository.save(chapter);
        return chapter;
    }

    @Override
    public Chapter updateChapter(Long id, Chapter chapter) {
        if(chapterRepository.findById(id).isPresent()) {
            Chapter existChapter = chapterRepository.findById(id).get();
            existChapter.setName(chapter.getName());
            chapterRepository.save(existChapter);
            return existChapter;
        }else {
            return null;
        }
    }

    @Override
    public boolean removeChapter(Chapter chapter) {
        try {
            chapterRepository.delete(chapter);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
