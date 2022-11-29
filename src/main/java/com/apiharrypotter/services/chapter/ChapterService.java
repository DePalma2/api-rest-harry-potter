package com.apiharrypotter.services.chapter;

import com.apiharrypotter.entities.Chapter;

import java.util.List;
import java.util.Optional;

public interface ChapterService {

    public  List<Chapter> getAllChapter();
    public  Optional<Chapter> getChapterById(Long id);
    public  Chapter addChapter(Chapter chapter);
    public  Chapter updateChapter(Long id, Chapter chapter);
    public  boolean removeChapter(Chapter chapter);

}
