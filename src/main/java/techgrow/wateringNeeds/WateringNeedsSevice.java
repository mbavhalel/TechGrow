package techgrow.wateringNeeds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WateringNeedsSevice {

    @Autowired
    WateringNeedsRepository wateringNeedsRepository;
    public WateringNeeds addPlantWateringNeed(WateringNeeds wateringNeeds) {
        return wateringNeedsRepository.save(wateringNeeds);
    }
    public List<WateringNeeds> addListOfPlantsWateringNeed(List<WateringNeeds> wateringNeeds) {
        return wateringNeedsRepository.saveAll(wateringNeeds);
    }
    public WateringNeeds getPlantWateringNeed(int id) {
        return wateringNeedsRepository.findById(id).orElse(null);
    }
    public List<WateringNeeds> getListOfPlantsWateringNeed() {
        return  wateringNeedsRepository.findAll();
    }
    public WateringNeeds updatePlantWateringNeed(WateringNeeds wateringNeeds) {
         WateringNeeds updatedwateringNeeds = wateringNeedsRepository.findById(wateringNeeds.getWeteringId()).orElse(null);
         if(updatedwateringNeeds != null){
             updatedwateringNeeds.setPlantType(wateringNeeds.getPlantType());
             updatedwateringNeeds.setHowOften(wateringNeeds.getHowOften());
             updatedwateringNeeds.setHowDeep(wateringNeeds.getHowDeep());
             return wateringNeedsRepository.save(updatedwateringNeeds);
         }
         else return null;
    }
    public String deletedPlantWateringNeed(int id) {
        if(wateringNeedsRepository.existsById(id)){
            wateringNeedsRepository.deleteById(id);
            return "Plant deleted";
        }
        else return "Plant not available";
    }
}
