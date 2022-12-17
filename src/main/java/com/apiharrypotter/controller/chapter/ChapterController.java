package com.apiharrypotter.controller.chapter;

import com.apiharrypotter.entities.Chapter;
import com.apiharrypotter.services.chapter.ChapterServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "Chapters", value = "Chapter", description = "Information about the chapters")
public class ChapterController {

    @Autowired
    private ChapterServiceImpl chapterService;

    @GetMapping("/chapters")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "List all chapters")
    public List<Chapter> getAllChapter(){
        return chapterService.getAllChapter();
    }

    @GetMapping( "/chapters/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Returns a chapter with a specific id")
    public Optional<Chapter> getChapterById(@PathVariable(name = "id") Long id) {
        return chapterService.getChapterById(id);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a chapter")
    @PostMapping("/chapters/add")
    public Chapter addChapter(@RequestBody Chapter chapter) {
        chapterService.addChapter(chapter);
        return chapter;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a chapter")
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
