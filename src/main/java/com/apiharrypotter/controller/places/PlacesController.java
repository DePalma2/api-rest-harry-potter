package com.apiharrypotter.controller.places;

import com.apiharrypotter.entities.Places;
import com.apiharrypotter.services.places.PlaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PlacesController {

    @Autowired
    private PlaceServiceImpl placeService;

    @GetMapping("/places")
    public List<Places> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    @GetMapping("/places{id}")
    public Optional<Places> getPlacesById(@PathVariable(name = "id") Long id) {
        return placeService.getById(id);
    }

    @PostMapping("/places/add")
    public Places addPlaces(@RequestBody Places places) {
        placeService.addPlace(places);
        return places;
    }

    @DeleteMapping("/places/{id}/delete")
    public String deletePlaceById(@PathVariable(name = "id") Places id) {
        boolean ok = placeService.deletePlace(id);
        if(ok){
            return "Place remove with id:  " + id;
        }else{
            return "Error try remove place with id: " + id;
        }
    }

}
