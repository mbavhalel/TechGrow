package techgrow.autumnWateringNeeds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techgrow.plants.Plant;
import techgrow.plants.PlantRepository;
import java.util.List;
@Service
public class AutumnWateringNeedsSevice {

    @Autowired
    AutumnWateringNeedRepository autumnWateringNeedRepository;

    @Autowired
    PlantRepository plantRepository;

    public AutumnWateringNeeds addPlantWateringNeed(AutumnWateringNeeds autumnWateringNeeds) {
        return autumnWateringNeedRepository.save(autumnWateringNeeds);
    }
    public List<AutumnWateringNeeds> addListOfPlantsWateringNeed(List<AutumnWateringNeeds> autumnWateringNeeds) {
        return autumnWateringNeedRepository.saveAll(autumnWateringNeeds);
    }
    public AutumnWateringNeeds getPlantWateringNeed(int id) {
        return autumnWateringNeedRepository.findById(id).orElse(null);
    }
    public List<AutumnWateringNeeds> getListOfPlantsWateringNeed() {
        return autumnWateringNeedRepository.findAll();
    }

    public AutumnWateringNeeds updatePlantWateringNeed(AutumnWateringNeeds autumnWateringNeeds) {
        AutumnWateringNeeds updatedWateringNeeds = autumnWateringNeedRepository.findById(autumnWateringNeeds.getWeteringId()).orElse(null);
        if (updatedWateringNeeds != null) {
            updatedWateringNeeds.setHowOften(autumnWateringNeeds.getHowOften());
            updatedWateringNeeds.setHowDeep(autumnWateringNeeds.getHowDeep());
            return autumnWateringNeedRepository.save(updatedWateringNeeds);
        } else return null;
    }
    public String deletedPlantWateringNeed(int id) {
        if (autumnWateringNeedRepository.existsById(id)) {
            autumnWateringNeedRepository.deleteById(id);
            return "Plant deleted";
        } else return "Plant not available";
    }

    public AutumnWateringNeeds linkPlantNeed(int needId, int plantId) {
        AutumnWateringNeeds summerWateringNeedsLink = autumnWateringNeedRepository.findById(needId).orElse(null);
        Plant plantEdit = plantRepository.findById(plantId).orElse(null);
        if (summerWateringNeedsLink != null && plantEdit != null) {
            summerWateringNeedsLink.addNeed(plantEdit);
            return autumnWateringNeedRepository.save(summerWateringNeedsLink);
        } else return null;
    }
}
