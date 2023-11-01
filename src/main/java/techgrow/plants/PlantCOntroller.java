package techgrow.plants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("Plant/")
public class PlantCOntroller {

    @Autowired
    PlantService plantService;

    @PostMapping("/addPlant")
    public Plant postPlant(@RequestBody Plant plant){
        return plantService.addPlant(plant);
    }
    @PostMapping("/addListOfPlants")
    public List<Plant> postListOfPlants(@RequestBody List<Plant> plant){
        return plantService.addListOfPlants(plant);
    }
    @GetMapping("/viewPlant/{id}")
    public Plant getPlant(@PathVariable int id){
        return plantService.getPlant(id);
    }
    @GetMapping("/viewListOfPlants")
    public List<Plant> getPlant(){
        return plantService.getListOfPlants();
    }
    @PutMapping("/updatePlant")
    public Plant putPlant(@RequestBody Plant plant){
        return plantService.updatePlant(plant);
    }
    @DeleteMapping("/deletePlant/{id}")
    public String deletePlant(@PathVariable int id){
        return plantService.deletedPlant(id);
    }
}
