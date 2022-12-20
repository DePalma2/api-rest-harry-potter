package com.apiharrypotter.controller.character;

import com.apiharrypotter.entities.Characters;
import com.apiharrypotter.repositories.character.CharacterRepository;
import com.apiharrypotter.services.character.CharacterServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "Characters", value = "Character", description = "Information about the characters")
public class CharacterController {

    @Autowired
    private CharacterServiceImpl characterService;

    @GetMapping("/characters")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "List all characters")
    public List<Characters> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @GetMapping("/characters/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Returns a character with a specific id", notes = "Character must exist")
    public Optional<Characters> getChapterById(@PathVariable(name = "id")  Long id){
        return characterService.getById(id);
    }

    @PostMapping("/add/characters")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a character", hidden = true)
    public Characters addCharacter(@RequestBody Characters characters) {
        characterService.addCharacters(characters);
        return characters;
    }

    @DeleteMapping("/delete/characters/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a character", hidden = true)
    public String deleteCharacter(@PathVariable(name = "id") Characters id){
        boolean ok = characterService.deleteCharacters(id);
        if(ok){
            return "Character remove with id:  " + id;
        }else{
            return "Error try remove character with id: " + id;
        }
    }

}
