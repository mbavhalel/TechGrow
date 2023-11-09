package techgrow.winterWateringNeeds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techgrow.plants.Plant;
import techgrow.plants.PlantRepository;
import java.util.List;
@Service
public class WinterWateringNeedsSevice {

    @Autowired
    WinterWateringNeedsRepository winterWateringNeedsRepository;

    @Autowired
    PlantRepository plantRepository;

    public WinterWateringNeeds addPlantWateringNeed(WinterWateringNeeds winterWateringNeeds) {
        return winterWateringNeedsRepository.save(winterWateringNeeds);
    }
    public List<WinterWateringNeeds> addListOfPlantsWateringNeed(List<WinterWateringNeeds> winterWateringNeeds) {
        return winterWateringNeedsRepository.saveAll(winterWateringNeeds);
    }
    public WinterWateringNeeds getPlantWateringNeed(int id) {
        return winterWateringNeedsRepository.findById(id).orElse(null);
    }
    public List<WinterWateringNeeds> getListOfPlantsWateringNeed() {
        return winterWateringNeedsRepository.findAll();
    }
    public WinterWateringNeeds updatePlantWateringNeed(WinterWateringNeeds winterWateringNeeds) {
        WinterWateringNeeds updatedwateringNeeds = winterWateringNeedsRepository.findById(winterWateringNeeds.getWeteringId()).orElse(null);
        if (updatedwateringNeeds != null) {
            updatedwateringNeeds.setHowOften(winterWateringNeeds.getHowOften());
            updatedwateringNeeds.setHowDeep(winterWateringNeeds.getHowDeep());
            return winterWateringNeedsRepository.save(updatedwateringNeeds);
        } else return null;
    }
    public String deletedPlantWateringNeed(int id) {
        if (winterWateringNeedsRepository.existsById(id)) {
            winterWateringNeedsRepository.deleteById(id);
            return "Plant deleted";
        } else return "Plant not available";
    }
    public WinterWateringNeeds linkPlantNeed(int needId, int plantId) {
        WinterWateringNeeds wateringNeedsLink = winterWateringNeedsRepository.findById(needId).orElse(null);
        Plant plantEdit = plantRepository.findById(plantId).orElse(null);
        if (wateringNeedsLink != null && plantEdit != null) {
            wateringNeedsLink.addNeed(plantEdit);
            return winterWateringNeedsRepository.save(wateringNeedsLink);
        } else return null;
    }
}

