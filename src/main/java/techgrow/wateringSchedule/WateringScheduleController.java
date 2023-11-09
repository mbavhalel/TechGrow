package techgrow.wateringSchedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("wateringSchedule/")
public class WateringScheduleController {

    @Autowired
    WateringScheduleSevice wateringScheduleSevice;
    @PostMapping("/addPlantWateringSchedule")
    public WateringSchedule postPlantWateringNeed(@RequestBody WateringSchedule wateringSchedule){
        return wateringScheduleSevice.addPlantWateringSchedule(wateringSchedule);
    }
    @PostMapping("/addListOfPlantsWateringSchedule")
    public List<WateringSchedule> postListOfPlants(@RequestBody List<WateringSchedule> wateringSchedule){
        return wateringScheduleSevice.addListOfPlantsWateringSchedule(wateringSchedule);
    }
    @GetMapping("/viewPlantWateringSchedule/{id}")
    public WateringSchedule getPlantWateringNeed(@PathVariable int id){
        return wateringScheduleSevice.getPlantWateringSchedule(id);
    }
    @GetMapping("/viewListOfPlantsWateringSchedule")
    public List<WateringSchedule> getPlantWateringNeed(){
        return wateringScheduleSevice.getListOfPlantsWateringSchedule();
    }
    @PutMapping("/updatePlantWateringSchedule")
    public WateringSchedule putPlant(@RequestBody WateringSchedule wateringSchedule){
        return wateringScheduleSevice.updatePlantWateringSchedule(wateringSchedule);
    }
    @DeleteMapping("/deletePlantWateringSchedule/{id}")
    public String deletePlantWateringNeed(@PathVariable int id){
        return wateringScheduleSevice.deletedPlantWateringSchedule(id);
    }

    @PutMapping("/{scheduleId}/Plant/{plantId}")
    WateringSchedule plantSchedule(
        @PathVariable int scheduleId,
        @PathVariable int plantId
    ){
        return wateringScheduleSevice.linkPlantSchedule(scheduleId, plantId);
    }
}
