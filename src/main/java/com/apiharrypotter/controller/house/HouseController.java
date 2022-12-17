package com.apiharrypotter.controller.house;

import com.apiharrypotter.entities.House;
import com.apiharrypotter.services.house.HouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class HouseController {

    @Autowired
    private HouseServiceImpl houseService;

    @GetMapping("/houses")
    public List<House>  getAllHouses(){
        return houseService.getAllHouses();
    }

    @GetMapping("/houses/{id}")
    public Optional<House> getHouseById(@PathVariable(name = "id") Long id){
        return houseService.getById(id);
    }

    @PostMapping("/houses/add")
    public House addHouse(@RequestBody  House house){
        houseService.addHouse(house);
        return house;
    }

    @DeleteMapping("/houses/{id}/delete")
    public String deleteHouse(@PathVariable(name = "id") House id){
        boolean ok = houseService.deleteHouse(id);
        if(ok){
            return "House remove with id:  " + id;
        }else{
            return "Error try remove house with id: " + id;
        }
    }

}
