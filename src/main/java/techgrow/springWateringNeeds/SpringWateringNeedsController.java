package techgrow.springWateringNeeds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("SpringWateringNeeds/")
public class SpringWateringNeedsController {

    @Autowired
    SpringWateringNeedsSevice springWateringNeedsSevice;
    @PostMapping("/addPlantWateringNeed")
    public SpringWateringNeeds postPlantWateringNeed(@RequestBody SpringWateringNeeds springWateringNeeds){
        return springWateringNeedsSevice.addPlantWateringNeed(springWateringNeeds);
    }
    @PostMapping("/addListOfPlantsWateringNeed")
    public List<SpringWateringNeeds> postListOfPlants(@RequestBody List<SpringWateringNeeds> springWateringNeeds){
        return springWateringNeedsSevice.addListOfPlantsWateringNeed(springWateringNeeds);
    }
    @GetMapping("/viewPlantWateringNeed/{id}")
    public SpringWateringNeeds getPlantWateringNeed(@PathVariable int id){
        return springWateringNeedsSevice.getPlantWateringNeed(id);
    }
    @GetMapping("/viewListOfPlantsWateringNeed")
    public List<SpringWateringNeeds> getPlantWateringNeed(){
        return springWateringNeedsSevice.getListOfPlantsWateringNeed();
    }
    @PutMapping("/updatePlantWateringNeed")
    public SpringWateringNeeds putPlant(@RequestBody SpringWateringNeeds springWateringNeeds){
        return springWateringNeedsSevice.updatePlantWateringNeed(springWateringNeeds);
    }
    @DeleteMapping("/deletePlant/{id}")
    public String deletePlantWateringNeed(@PathVariable int id){
        return springWateringNeedsSevice.deletedPlantWateringNeed(id);
    }

    @PutMapping("/{needId}/Plant/{plantId}")
    SpringWateringNeeds plantSchedule(
            @PathVariable int needId,
            @PathVariable int plantId
    ){
        return springWateringNeedsSevice.linkPlantNeed(needId, plantId);
    }
}



