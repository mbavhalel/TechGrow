package techgrow.plants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PlantService {
    @Autowired
    PlantRepository plantRepository;
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
                updatedPlant.setLocation(plant.getLocation());
                updatedPlant.setWateringNeedsId(plant.getWateringNeedsId());
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
}

