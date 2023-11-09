package techgrow.summerWateringNeeds;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SummerWateringNeedsRepository extends JpaRepository<SummerWateringNeeds, Integer> {
}
