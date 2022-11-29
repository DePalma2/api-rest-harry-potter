package com.apiharrypotter.services.character;

import com.apiharrypotter.entities.Characters;

import java.util.List;
import java.util.Optional;

public interface CharactersService {

    public List<Characters> getAllCharacters();
    public Optional<Characters> getById(Long id);
    public Characters addCharacters(Characters characters);
    public Characters updateCharacters(Long id,Characters characters);
    public boolean deleteCharacters(Characters characters);

}
