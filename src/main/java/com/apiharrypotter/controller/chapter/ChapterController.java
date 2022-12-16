package com.apiharrypotter.controller.chapter;

import com.apiharrypotter.entities.Chapter;
import com.apiharrypotter.services.chapter.ChapterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ChapterController {

    @Autowired
    private ChapterServiceImpl chapterService;

    @GetMapping("/chapters")
    public List<Chapter> getAllChapter(){
        return chapterService.getAllChapter();
    }

    @GetMapping( "/chapters/{id}")
    public Optional<Chapter> getChapterById(@PathVariable(name = "id") Long id) {
        return chapterService.getChapterById(id);
    }

    @PostMapping("/chapters/add")
    public Chapter addChapter(@RequestBody Chapter chapter) {
        chapterService.addChapter(chapter);
        return chapter;
    }

    @DeleteMapping("/chapters/{id}/delete")
    public String deleteChapter(@PathVariable(name = "id") Chapter id) {
        boolean ok = chapterService.removeChapter(id);
        if(ok){
            return "Chapter remove with id:  " + id;
        }else{
            return "Error try remove chapter with id: " + id;
        }
    }

}
