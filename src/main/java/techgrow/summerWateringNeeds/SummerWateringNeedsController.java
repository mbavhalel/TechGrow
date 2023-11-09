package techgrow.summerWateringNeeds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("SummerWateringNeeds/")
public class SummerWateringNeedsController {

    @Autowired
    SummerWateringNeedsSevice summerWateringNeedsSevice;

    @PostMapping("/addPlantWateringNeed")
    public SummerWateringNeeds postPlantWateringNeed(@RequestBody SummerWateringNeeds summerWateringNeeds){
        return summerWateringNeedsSevice.addPlantWateringNeed(summerWateringNeeds);
    }
    @PostMapping("/addListOfPlantsWateringNeed")
    public List<SummerWateringNeeds> postListOfPlants(@RequestBody List<SummerWateringNeeds> summerWateringNeeds){
        return summerWateringNeedsSevice.addListOfPlantsWateringNeed(summerWateringNeeds);
    }
    @GetMapping("/viewPlantWateringNeed/{id}")
    public SummerWateringNeeds getPlantWateringNeed(@PathVariable int id){
        return summerWateringNeedsSevice.getPlantWateringNeed(id);
    }
    @GetMapping("/viewListOfPlantsWateringNeed")
    public List<SummerWateringNeeds> getPlantWateringNeed(){
        return summerWateringNeedsSevice.getListOfPlantsWateringNeed();
    }
    @PutMapping("/updatePlantWateringNeed")
    public SummerWateringNeeds putPlant(@RequestBody SummerWateringNeeds summerWateringNeeds){
        return summerWateringNeedsSevice.updatePlantWateringNeed(summerWateringNeeds);
    }
    @DeleteMapping("/deletePlant/{id}")
    public String deletePlantWateringNeed(@PathVariable int id){
        return summerWateringNeedsSevice.deletedPlantWateringNeed(id);
    }

    @PutMapping("/{needId}/Plant/{plantId}")
    SummerWateringNeeds plantSchedule(
            @PathVariable int needId,
            @PathVariable int plantId
    ){
        return summerWateringNeedsSevice.linkPlantNeed(needId, plantId);
    }
}
