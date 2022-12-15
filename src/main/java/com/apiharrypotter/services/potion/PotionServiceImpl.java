package com.apiharrypotter.services.potion;


import com.apiharrypotter.entities.Potion;
import com.apiharrypotter.repositories.potion.PotionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PotionServiceImpl implements PotionService{

    private final PotionRepository potionRepository;

    public PotionServiceImpl(PotionRepository potionRepository) {
        this.potionRepository = potionRepository;
    }


    @Override
    public List<Potion> getAllPotions(Potion potion) {
        return potionRepository.findAll();
    }

    @Override
    public Optional<Potion> getById(Long id) {
        return potionRepository.findById(id);
    }

    @Override
    public Potion addPotion(Potion potion) {
        potionRepository.save(potion);
        return potion;
    }

    @Override
    public Potion updatePotion(Long id, Potion potion) {
        if(potionRepository.findById(id).isPresent()) {
            Potion existPotion = potionRepository.findById(id).get();
            existPotion.setName(potion.getName());
            potionRepository.save(existPotion);
            return existPotion;
        }else {
            return null;
        }
    }

    @Override
    public boolean deletePotion(Potion potion) {
        try {
            potionRepository.delete(potion);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
