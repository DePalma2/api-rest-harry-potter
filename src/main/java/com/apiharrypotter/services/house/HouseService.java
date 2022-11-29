package com.apiharrypotter.services.house;

import com.apiharrypotter.entities.House;

import java.util.List;

public interface HouseService {

    public List<House> getAllHouses();
    public House getById(Long id);
    public House addHouse(House house);
    public House updateHouse(Long id,House house);
    public boolean deleteHouse(House house);

}
