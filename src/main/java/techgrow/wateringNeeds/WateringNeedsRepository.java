package techgrow.wateringNeeds;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WateringNeedsRepository extends JpaRepository<WateringNeeds, Integer> {
}
