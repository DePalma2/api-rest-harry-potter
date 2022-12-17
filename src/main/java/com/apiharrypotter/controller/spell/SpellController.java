package com.apiharrypotter.controller.spell;

import com.apiharrypotter.entities.Spell;
import com.apiharrypotter.services.spell.SpellServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class SpellController {

    @Autowired
    private SpellServiceImpl spellService;

    @GetMapping("/spells")
    public List<Spell> getAllSpells() {
        return spellService.getAllSpells();
    }

    @GetMapping("/spells/{id}")
    public Optional<Spell> getSpellsById(@PathVariable(name = "id") Long id) {
        return spellService.getById(id);
    }

    @PostMapping("/spells/add")
    public Spell addSpell(@RequestBody Spell spell) {
        spellService.addSpell(spell);
        return spell;
    }

    @DeleteMapping("/spells/{id}/delete")
    public String deleteSpell(@PathVariable(name = "id") Spell id) {
        boolean ok = spellService.deleteSpell(id);
        if(ok){
            return "Spell remove with id:  " + id;
        }else{
            return "Error try remove spell with id: " + id;
        }
    }


}
