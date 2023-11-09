package techgrow.wateringSchedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techgrow.plants.Plant;
import techgrow.plants.PlantRepository;

import java.util.List;
@Service
public class WateringScheduleSevice {
    @Autowired
    WateringScheduleRepository wateringScheduleRepository;

    @Autowired
    PlantRepository plantRepository;
    public WateringSchedule addPlantWateringSchedule(WateringSchedule wateringSchedule) {
        return wateringScheduleRepository.save(wateringSchedule);
    }
    public List<WateringSchedule> addListOfPlantsWateringSchedule(List<WateringSchedule> wateringSchedule) {
        return wateringScheduleRepository.saveAll(wateringSchedule);
    }
    public WateringSchedule getPlantWateringSchedule(int id) {
        return wateringScheduleRepository.findById(id).orElse(null);
    }
    public List<WateringSchedule> getListOfPlantsWateringSchedule() {
        return wateringScheduleRepository.findAll();
    }
    public WateringSchedule updatePlantWateringSchedule(WateringSchedule wateringSchedule) {
        WateringSchedule updatedSchedule = wateringScheduleRepository.findById(wateringSchedule.getScheduleId()).orElse(null);
        if(updatedSchedule != null){
            updatedSchedule.setNextSchedule(wateringSchedule.getNextSchedule());
            updatedSchedule.setPeriod(wateringSchedule.getPeriod());
            return wateringScheduleRepository.save(updatedSchedule);
        }
        else return null;
    }
    public String deletedPlantWateringSchedule(int id) {
        if(wateringScheduleRepository.existsById(id)){
            wateringScheduleRepository.deleteById(id);
            return "Schedule deleted";
        }
        else return "not found";
    }

    public WateringSchedule linkPlantSchedule(int scheduleId, int plantId) {
        WateringSchedule wateringScheduleEdit = wateringScheduleRepository.findById(scheduleId).orElse(null);
        Plant plantEdit = plantRepository.findById(plantId).orElse(null);
        if(wateringScheduleEdit != null && plantEdit != null){
            wateringScheduleEdit.addPlant(plantEdit);
            return wateringScheduleRepository.save(wateringScheduleEdit);
        }
        else return null;
    }
}
