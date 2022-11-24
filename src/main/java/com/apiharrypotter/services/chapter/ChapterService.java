package com.apiharrypotter.services.chapter;

import com.apiharrypotter.entities.Chapter;

import java.util.List;
import java.util.Optional;

public interface ChapterService {

    public abstract List<Chapter> getAllChapter();
    public abstract Optional<Chapter> getChapterById(Long id);
    public abstract Chapter addChapter(Chapter chapter);
    public abstract Chapter updateChapter(Long id, Chapter chapter);
    public abstract boolean removeChapter(Chapter chapter);

}
