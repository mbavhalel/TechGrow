package techgrow.summerWateringNeeds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techgrow.plants.Plant;
import techgrow.plants.PlantRepository;
import java.util.List;
@Service
public class SummerWateringNeedsSevice {

    @Autowired
    SummerWateringNeedsRepository summerWateringNeedsRepository;

    @Autowired
    PlantRepository plantRepository;

    public SummerWateringNeeds addPlantWateringNeed(SummerWateringNeeds summerWateringNeeds) {
        return summerWateringNeedsRepository.save(summerWateringNeeds);
    }
    public List<SummerWateringNeeds> addListOfPlantsWateringNeed(List<SummerWateringNeeds> summerWateringNeeds) {
        return summerWateringNeedsRepository.saveAll(summerWateringNeeds);
    }
    public SummerWateringNeeds getPlantWateringNeed(int id) {
        return summerWateringNeedsRepository.findById(id).orElse(null);
    }
    public List<SummerWateringNeeds> getListOfPlantsWateringNeed() {
        return  summerWateringNeedsRepository.findAll();
    }
    public SummerWateringNeeds updatePlantWateringNeed(SummerWateringNeeds summerWateringNeeds) {
         SummerWateringNeeds updatedwateringNeedsSummer = summerWateringNeedsRepository.findById(summerWateringNeeds.getWeteringId()).orElse(null);
         if(updatedwateringNeedsSummer != null){
             updatedwateringNeedsSummer.setHowOften(summerWateringNeeds.getHowOften());
             updatedwateringNeedsSummer.setHowDeep(summerWateringNeeds.getHowDeep());
             return summerWateringNeedsRepository.save(updatedwateringNeedsSummer);
         }
         else return null;
    }
    public String deletedPlantWateringNeed(int id) {
        if(summerWateringNeedsRepository.existsById(id)){
            summerWateringNeedsRepository.deleteById(id);
            return "Plant deleted";
        }
        else return "Plant not available";
    }
    public SummerWateringNeeds linkPlantNeed(int needId, int plantId) {
        SummerWateringNeeds summerWateringNeedsLink = summerWateringNeedsRepository.findById(needId).orElse(null);
        Plant plantEdit = plantRepository.findById(plantId).orElse(null);
        if(summerWateringNeedsLink != null && plantEdit != null){
            summerWateringNeedsLink.addNeed(plantEdit);
            return summerWateringNeedsRepository.save(summerWateringNeedsLink);
        }
        else return null;
    }
}
