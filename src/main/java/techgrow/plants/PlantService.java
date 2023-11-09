package techgrow.plants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techgrow.wateringSchedule.WateringSchedule;
import techgrow.wateringSchedule.WateringScheduleRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PlantService {
    @Autowired
    PlantRepository plantRepository;
    WateringScheduleRepository wateringScheduleRepository;
    private Set<WateringSchedule> wateringScheduleList = new HashSet<>();
    public Plant addPlant(Plant plant) {
        return plantRepository.save(plant);
    }
    public List<Plant> addListOfPlants(List<Plant> plant) {
        return plantRepository.saveAll(plant);
    }
    public Plant getPlant(int id) {
        return plantRepository.findById(id).orElse(null);
    }
    public List<Plant> getListOfPlants() {
        return plantRepository.findAll();
    }
    public Plant updatePlant(Plant plant) {
        Plant updatedPlant = plantRepository.findById(plant.getPlantId()).orElse(null);
            if(updatedPlant != null){
                updatedPlant.setSpecies(plant.getSpecies());
                plantRepository.save(updatedPlant);
                return updatedPlant;
            }
            else return null;
    }
    public String deletedPlant(int id) {
        if(plantRepository.existsById(id)){
            plantRepository.deleteById(id);
            return "Plant deleted";
        }
        else return "Plant not available";
    }
    public Plant mapPlantSchedule(int plantId, int scheduleId) {
        Plant plant = plantRepository.findById(plantId).get();
        WateringSchedule wateringSchedule = wateringScheduleRepository.findById(scheduleId).get();
        wateringScheduleList.add(wateringSchedule);
        return plantRepository.save(plant);
    }
}

