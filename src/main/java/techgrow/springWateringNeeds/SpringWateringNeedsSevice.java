package techgrow.springWateringNeeds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techgrow.plants.Plant;
import techgrow.plants.PlantRepository;
import java.util.List;
@Service
public class SpringWateringNeedsSevice {

        @Autowired
        SpringWateringNeedsRepository springWateringNeedsRepository;

        @Autowired
        PlantRepository plantRepository;

        public SpringWateringNeeds addPlantWateringNeed(SpringWateringNeeds springWateringNeeds) {
            return springWateringNeedsRepository.save(springWateringNeeds);
        }
        public List<SpringWateringNeeds> addListOfPlantsWateringNeed(List<SpringWateringNeeds> springWateringNeeds) {
            return springWateringNeedsRepository.saveAll(springWateringNeeds);
        }
        public SpringWateringNeeds getPlantWateringNeed(int id) {
            return springWateringNeedsRepository.findById(id).orElse(null);
        }
        public List<SpringWateringNeeds> getListOfPlantsWateringNeed() {
            return springWateringNeedsRepository.findAll();
        }
        public SpringWateringNeeds updatePlantWateringNeed(SpringWateringNeeds springWateringNeeds) {
            SpringWateringNeeds updatedwateringNeeds = springWateringNeedsRepository.findById(springWateringNeeds.getWeteringId()).orElse(null);
            if (updatedwateringNeeds != null) {
                updatedwateringNeeds.setHowOften(springWateringNeeds.getHowOften());
                updatedwateringNeeds.setHowDeep(springWateringNeeds.getHowDeep());
                return springWateringNeedsRepository.save(updatedwateringNeeds);
            } else return null;
        }
        public String deletedPlantWateringNeed(int id) {
            if (springWateringNeedsRepository.existsById(id)) {
                springWateringNeedsRepository.deleteById(id);
                return "Plant deleted";
            } else return "Plant not available";
        }

        public SpringWateringNeeds linkPlantNeed(int needId, int plantId) {
            SpringWateringNeeds wateringNeedsLink = springWateringNeedsRepository.findById(needId).orElse(null);
            Plant plantEdit = plantRepository.findById(plantId).orElse(null);
            if (wateringNeedsLink != null && plantEdit != null) {
                wateringNeedsLink.addNeed(plantEdit);
                return springWateringNeedsRepository.save(wateringNeedsLink);
            } else return null;
        }
    }

