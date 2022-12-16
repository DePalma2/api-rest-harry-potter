package com.apiharrypotter.services.potion;

import com.apiharrypotter.entities.Potion;

import java.util.List;
import java.util.Optional;

public interface PotionService {

    public List<Potion> getAllPotions();
    public Optional<Potion> getById(Long id);
    public Potion addPotion(Potion potion);
    public Potion updatePotion(Long id, Potion potion);
    public boolean deletePotion(Potion potion);
}
