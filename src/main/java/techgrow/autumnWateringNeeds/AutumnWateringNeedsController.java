package techgrow.autumnWateringNeeds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("AutumnWateringNeeds/")
public class AutumnWateringNeedsController {

        @Autowired
        AutumnWateringNeedsSevice autumnWateringNeedsSevice;

        @PostMapping("/addPlantWateringNeed")
        public AutumnWateringNeeds postPlantWateringNeed(@RequestBody AutumnWateringNeeds autumnWateringNeeds){
            return autumnWateringNeedsSevice.addPlantWateringNeed(autumnWateringNeeds);
        }
        @PostMapping("/addListOfPlantsWateringNeed")
        public List<AutumnWateringNeeds> postListOfPlants(@RequestBody List<AutumnWateringNeeds > autumnWateringNeeds){
            return autumnWateringNeedsSevice.addListOfPlantsWateringNeed(autumnWateringNeeds);
        }
        @GetMapping("/viewPlantWateringNeed/{id}")
        public AutumnWateringNeeds getPlantWateringNeed(@PathVariable int id){
            return autumnWateringNeedsSevice.getPlantWateringNeed(id);
        }
        @GetMapping("/viewListOfPlantsWateringNeed")
        public List<AutumnWateringNeeds> getPlantWateringNeed(){
            return autumnWateringNeedsSevice.getListOfPlantsWateringNeed();
        }
        @PutMapping("/updatePlantWateringNeed")
        public AutumnWateringNeeds putPlant(@RequestBody AutumnWateringNeeds autumnWateringNeeds){
            return autumnWateringNeedsSevice.updatePlantWateringNeed(autumnWateringNeeds);
        }
        @DeleteMapping("/deletePlant/{id}")
        public String deletePlantWateringNeed(@PathVariable int id){
            return autumnWateringNeedsSevice.deletedPlantWateringNeed(id);
        }

        @PutMapping("/{needId}/Plant/{plantId}")
        AutumnWateringNeeds plantSchedule(
                @PathVariable int needId,
                @PathVariable int plantId
        ){
            return autumnWateringNeedsSevice.linkPlantNeed(needId, plantId);
        }
    }

