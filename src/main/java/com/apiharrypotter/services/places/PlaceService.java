package com.apiharrypotter.services.places;

import com.apiharrypotter.entities.Places;

import java.util.List;
import java.util.Optional;

public interface PlaceService {

    public List<Places> getAllPlaces();
    public Optional<Places> getById(Long id);
    public Places addPlace(Places place);
    public Places updatePlace(Long id,Places place);
    public boolean deletePlace(Places places);

}
