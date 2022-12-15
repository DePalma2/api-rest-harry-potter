package com.apiharrypotter.services.places;

import com.apiharrypotter.entities.Places;
import com.apiharrypotter.repositories.places.PlacesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceServiceImpl  implements PlaceService{

    private final PlacesRepository placesRepository;


    public PlaceServiceImpl(PlacesRepository placesRepository) {
        this.placesRepository = placesRepository;
    }

    @Override
    public List<Places> getAllPlaces() {
        return placesRepository.findAll();
    }

    @Override
    public Optional<Places> getById(Long id) {
        return placesRepository.findById(id);
    }

    @Override
    public Places addPlace(Places place) {
        placesRepository.save(place);
        return place;
    }

    @Override
    public Places updatePlace(Long id, Places place) {
        if(placesRepository.findById(id).isPresent()) {
            Places existPlace = placesRepository.findById(id).get();
            existPlace.setName(place.getName());
            placesRepository.save(existPlace);
            return existPlace;
        }else {
            return null;
        }
    }

    @Override
    public boolean deletePlace(Places places) {
        try {
            placesRepository.delete(places);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
