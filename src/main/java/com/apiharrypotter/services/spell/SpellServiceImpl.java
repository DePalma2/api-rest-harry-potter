package com.apiharrypotter.services.spell;

import com.apiharrypotter.entities.Spell;
import com.apiharrypotter.repositories.spell.SpellRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpellServiceImpl implements SpellService{

    private final SpellRepository spellRepository;

    public SpellServiceImpl(SpellRepository spellRepository) {
        this.spellRepository = spellRepository;
    }

    @Override
    public List<Spell> getAllSpells() {
        return spellRepository.findAll();
    }

    @Override
    public Optional<Spell> getById(Long id) {
        return spellRepository.findById(id);
    }

    @Override
    public Spell addSpell(Spell spell) {
        spellRepository.save(spell);
        return spell;
    }

    @Override
    public Spell updateSpell(Long id, Spell spell) {
        if(spellRepository.findById(id).isPresent()) {
            Spell existSpell = spellRepository.findById(id).get();
            existSpell.setName(spell.getName());
            spellRepository.save(existSpell);
            return existSpell;
        }else {
            return null;
        }
    }

    @Override
    public boolean deleteSpell(Spell spell) {
        try {
            spellRepository.delete(spell);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
