package techgrow.wateringNeeds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class WateringNeedsController {

    @Autowired
    WateringNeedsSevice wateringNeedsSevice;

    @PostMapping("/addPlantWateringNeed")
    public WateringNeeds postPlantWateringNeed(@RequestBody WateringNeeds wateringNeeds){
        return wateringNeedsSevice.addPlantWateringNeed(wateringNeeds);
    }
    @PostMapping("/addListOfPlantsWateringNeed")
    public List<WateringNeeds> postListOfPlants(@RequestBody List<WateringNeeds> wateringNeeds){
        return wateringNeedsSevice.addListOfPlantsWateringNeed(wateringNeeds);
    }
    @GetMapping("/viewPlantWateringNeed/{id}")
    public WateringNeeds getPlantWateringNeed(@PathVariable int id){
        return wateringNeedsSevice.getPlantWateringNeed(id);
    }
    @GetMapping("/viewListOfPlantsWateringNeed")
    public List<WateringNeeds> getPlantWateringNeed(){
        return wateringNeedsSevice.getListOfPlantsWateringNeed();
    }
    @PutMapping("/updatePlantWateringNeed")
    public WateringNeeds putPlant(@RequestBody WateringNeeds wateringNeeds){
        return wateringNeedsSevice.updatePlantWateringNeed(wateringNeeds);
    }
    @DeleteMapping("/deletePlant/{id}")
    public String deletePlantWateringNeed(@PathVariable int id){
        return wateringNeedsSevice.deletedPlantWateringNeed(id);
    }
}
