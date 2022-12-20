package com.apiharrypotter.controller.house;

import com.apiharrypotter.entities.House;
import com.apiharrypotter.services.house.HouseServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "Houses", value = "House", description = "Information about the houses")
public class HouseController {

    @Autowired
    private HouseServiceImpl houseService;

    @GetMapping("/houses")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "List all houses")
    public List<House>  getAllHouses(){
        return houseService.getAllHouses();
    }

    @GetMapping("/houses/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Returns a house with a specific id", notes = "House must exist")
    public Optional<House> getHouseById(@PathVariable(name = "id") Long id){
        return houseService.getById(id);
    }

    @PostMapping("/add/houses")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a house")
    public House addHouse(@RequestBody  House house){
        houseService.addHouse(house);
        return house;
    }

    @DeleteMapping("/delete/houses/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a house")
    public String deleteHouse(@PathVariable(name = "id") House id){
        boolean ok = houseService.deleteHouse(id);
        if(ok){
            return "House remove with id:  " + id;
        }else{
            return "Error try remove house with id: " + id;
        }
    }

}
