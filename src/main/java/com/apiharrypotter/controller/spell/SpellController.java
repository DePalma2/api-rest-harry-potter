package com.apiharrypotter.controller.spell;

import com.apiharrypotter.entities.Spell;
import com.apiharrypotter.services.spell.SpellServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "Spells", value = "Spell", description = "Information about the spells")
public class SpellController {

    @Autowired
    private SpellServiceImpl spellService;

    @GetMapping("/spells")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "List all spells")
    public List<Spell> getAllSpells() {
        return spellService.getAllSpells();
    }

    @GetMapping("/spells/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Returns a spell with a specific id", notes = "Spell must exist")
    public Optional<Spell> getSpellsById(@PathVariable(name = "id") Long id) {
        return spellService.getById(id);
    }

    @PostMapping("/add/spells")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a spell")
    public Spell addSpell(@RequestBody Spell spell) {
        spellService.addSpell(spell);
        return spell;
    }

    @DeleteMapping("/delete/spells/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a spell", notes = "Spell must exist")
    public String deleteSpell(@PathVariable(name = "id") Spell id) {
        boolean ok = spellService.deleteSpell(id);
        if(ok){
            return "Spell remove with id:  " + id;
        }else{
            return "Error try remove spell with id: " + id;
        }
    }


}
