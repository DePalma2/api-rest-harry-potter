package com.apiharrypotter.controller.places;

import com.apiharrypotter.entities.Places;
import com.apiharrypotter.services.places.PlaceServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "Places", value = "Place", description = "Information about the places")
public class PlacesController {

    @Autowired
    private PlaceServiceImpl placeService;

    @GetMapping("/places")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "List all places")
    public List<Places> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    @GetMapping("/places{id}")
    @ApiOperation(value = "Returns a place with a specific id", notes = "Place must exist")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Places> getPlacesById(@PathVariable(name = "id") Long id) {
        return placeService.getById(id);
    }

    @PostMapping("/add/places")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a place", hidden = true)
    public Places addPlaces(@RequestBody Places places) {
        placeService.addPlace(places);
        return places;
    }

    @DeleteMapping("/delete/places/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a place", notes = "Place must exist", hidden = true)
    public String deletePlaceById(@PathVariable(name = "id") Places id) {
        boolean ok = placeService.deletePlace(id);
        if(ok){
            return "Place remove with id:  " + id;
        }else{
            return "Error try remove place with id: " + id;
        }
    }

}
