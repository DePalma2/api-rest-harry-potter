package com.apiharrypotter.controller.potion;

import com.apiharrypotter.entities.Potion;
import com.apiharrypotter.services.potion.PotionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PotionController {

    @Autowired
    private PotionServiceImpl potionService;

    @GetMapping("/potions")
    public List<Potion> getAllPotions() {
        return potionService.getAllPotions();
    }

    @GetMapping("/potions/{id}")
    public Optional<Potion> getPotionsById(@PathVariable(name = "id") Long id) {
        return potionService.getById(id);
    }

    @PostMapping("/potions/add")
    public Potion addPotions(@RequestBody  Potion potion) {
        potionService.addPotion(potion);
        return potion;
    }

    @DeleteMapping("/potions/delete")
    public String deletePotions(@PathVariable(name = "id") Potion id) {
        boolean ok = potionService.deletePotion(id);
        if(ok){
            return "Potion remove with id:  " + id;
        }else{
            return "Error try remove potion with id: " + id;
        }
    }


}
