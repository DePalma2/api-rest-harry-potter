package com.apiharrypotter.services.character;

import com.apiharrypotter.entities.Characters;
import com.apiharrypotter.repositories.character.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements  CharactersService{

    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<Characters> getAllCharacters() {
        return characterRepository.findAll();
    }

    @Override
    public Optional<Characters> getById(Long id) {
        return characterRepository.findById(id);
    }

    @Override
    public Characters addCharacters(Characters characters) {
        characterRepository.save(characters);
        return characters;
    }

    @Override
    public Characters updateCharacters(Long id, Characters characters) {
        if(characterRepository.findById(id).isPresent()) {
            Characters ch = characterRepository.findById(id).get();
            ch.setName(characters.getName());
            characterRepository.save(ch);
            return ch;
        }else {
            return null;
        }
    }

    @Override
    public boolean deleteCharacters(Characters characters) {
        try {
            characterRepository.delete(characters);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
