package com.apiharrypotter.services.spell;

import com.apiharrypotter.entities.Spell;

import java.util.List;
import java.util.Optional;

public interface SpellService {

    public List<Spell> getAllSpells();
    public Optional<Spell> getById(Long id);
    public Spell addSpell(Spell spell);
    public Spell updateSpell(Long id,Spell spell);
    public boolean deleteSpell(Spell spell);

}
