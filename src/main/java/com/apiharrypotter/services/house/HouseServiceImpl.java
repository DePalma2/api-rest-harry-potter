package com.apiharrypotter.services.house;

import com.apiharrypotter.entities.House;
import com.apiharrypotter.repositories.house.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseServiceImpl implements HouseService{

    private final HouseRepository houseRepository;

    public HouseServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }


    @Override
    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }

    @Override
    public Optional<House> getById(Long id) {
        return houseRepository.findById(id);
    }

    @Override
    public House addHouse(House house) {
        houseRepository.save(house);
        return house;
    }

    @Override
    public House updateHouse(Long id, House house) {
        if(houseRepository.findById(id).isPresent()) {
            House houseExists = houseRepository.findById(id).get();
            houseExists.setName(house.getName());
            houseRepository.save(houseExists);
            return houseExists;
        }else {
            return null;
        }
    }

    @Override
    public boolean deleteHouse(House house) {
        try {
            houseRepository.delete(house);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
