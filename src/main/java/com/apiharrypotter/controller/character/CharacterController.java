package com.apiharrypotter.controller.character;

import com.apiharrypotter.entities.Characters;
import com.apiharrypotter.repositories.character.CharacterRepository;
import com.apiharrypotter.services.character.CharacterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CharacterController {

    @Autowired
    private CharacterServiceImpl characterService;

    @GetMapping("/characters")
    public List<Characters> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @GetMapping("/characters/{id}")
    public Optional<Characters> getChapterById(@PathVariable(name = "id")  Long id){
        return characterService.getById(id);
    }

    @PostMapping("/characters/add")
    public Characters addCharacter(@RequestBody Characters characters) {
        characterService.addCharacters(characters);
        return characters;
    }

    @DeleteMapping("/characters/{id}/delete")
    public String deleteCharacter(@PathVariable(name = "id") Characters id){
        boolean ok = characterService.deleteCharacters(id);
        if(ok){
            return "Character remove with id:  " + id;
        }else{
            return "Error try remove character with id: " + id;
        }
    }

}
