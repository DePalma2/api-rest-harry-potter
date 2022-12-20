package com.apiharrypotter.controller.potion;

import com.apiharrypotter.entities.Potion;
import com.apiharrypotter.services.potion.PotionServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "Potions", value = "Potion", description = "Information about the potions")
public class PotionController {

    @Autowired
    private PotionServiceImpl potionService;

    @GetMapping("/potions")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "List all potions")
    public List<Potion> getAllPotions() {
        return potionService.getAllPotions();
    }

    @GetMapping("/potions/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Returns a potion with a specific id", notes = "Potion must exist")
    public Optional<Potion> getPotionsById(@PathVariable(name = "id") Long id) {
        return potionService.getById(id);
    }

    @PostMapping("/add/potions")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a potion", hidden = true)
    public Potion addPotions(@RequestBody  Potion potion) {
        potionService.addPotion(potion);
        return potion;
    }

    @DeleteMapping("/delete/potions/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a potion", notes = "Potion must exist", hidden = true)
    public String deletePotions(@PathVariable(name = "id") Potion id) {
        boolean ok = potionService.deletePotion(id);
        if(ok){
            return "Potion remove with id:  " + id;
        }else{
            return "Error try remove potion with id: " + id;
        }
    }


}
