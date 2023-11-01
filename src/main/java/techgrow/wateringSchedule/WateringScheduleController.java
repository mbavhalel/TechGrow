package techgrow.wateringSchedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("wateringSchedule/")
public class WateringScheduleController {

    @Autowired
    WateringScheduleSevice wateringScheduleSevice;
    @PostMapping("/addPlantWateringNeed")
    public WateringSchedule postPlantWateringNeed(@RequestBody WateringSchedule wateringSchedule){
        return wateringScheduleSevice.addPlantWateringSchedule(wateringSchedule);
    }
    @PostMapping("/addListOfPlantsWateringNeed")
    public List<WateringSchedule> postListOfPlants(@RequestBody List<WateringSchedule> wateringSchedule){
        return wateringScheduleSevice.addListOfPlantsWateringSchedule(wateringSchedule);
    }
    @GetMapping("/viewPlantWateringNeed/{id}")
    public WateringSchedule getPlantWateringNeed(@PathVariable int id){
        return wateringScheduleSevice.getPlantWateringSchedule(id);
    }
    @GetMapping("/viewListOfPlantsWateringNeed")
    public List<WateringSchedule> getPlantWateringNeed(){
        return wateringScheduleSevice.getListOfPlantsWateringSchedule();
    }
    @PutMapping("/updatePlantWateringNeed")
    public WateringSchedule putPlant(@RequestBody WateringSchedule wateringSchedule){
        return wateringScheduleSevice.updatePlantWateringSchedule(wateringSchedule);
    }
    @DeleteMapping("/deletePlant/{id}")
    public String deletePlantWateringNeed(@PathVariable int id){
        return wateringScheduleSevice.deletedPlantWateringSchedule(id);
    }
}
