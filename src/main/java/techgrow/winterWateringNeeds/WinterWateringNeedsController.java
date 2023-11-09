package techgrow.winterWateringNeeds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("WinterWateringNeeds/")
public class WinterWateringNeedsController {

    @Autowired
    WinterWateringNeedsSevice winterWateringNeedsSevice;

    @PostMapping("/addPlantWateringNeed")
    public WinterWateringNeeds postPlantWateringNeed(@RequestBody WinterWateringNeeds winterWateringNeeds){
        return winterWateringNeedsSevice.addPlantWateringNeed(winterWateringNeeds);
    }
    @PostMapping("/addListOfPlantsWateringNeed")
    public List<WinterWateringNeeds> postListOfPlants(@RequestBody List<WinterWateringNeeds> winterWateringNeeds){
        return winterWateringNeedsSevice.addListOfPlantsWateringNeed(winterWateringNeeds);
    }
    @GetMapping("/viewPlantWateringNeed/{id}")
    public WinterWateringNeeds getPlantWateringNeed(@PathVariable int id){
        return winterWateringNeedsSevice.getPlantWateringNeed(id);
    }
    @GetMapping("/viewListOfPlantsWateringNeed")
    public List<WinterWateringNeeds> getPlantWateringNeed(){
        return winterWateringNeedsSevice.getListOfPlantsWateringNeed();
    }
    @PutMapping("/updatePlantWateringNeed")
    public WinterWateringNeeds putPlant(@RequestBody WinterWateringNeeds winterWateringNeeds){
        return winterWateringNeedsSevice.updatePlantWateringNeed(winterWateringNeeds);
    }
    @DeleteMapping("/deletePlant/{id}")
    public String deletePlantWateringNeed(@PathVariable int id){
        return winterWateringNeedsSevice.deletedPlantWateringNeed(id);
    }
    @PutMapping("/{needId}/Plant/{plantId}")
    WinterWateringNeeds plantSchedule(
            @PathVariable int needId,
            @PathVariable int plantId
    ){
        return winterWateringNeedsSevice.linkPlantNeed(needId, plantId);
    }
}

