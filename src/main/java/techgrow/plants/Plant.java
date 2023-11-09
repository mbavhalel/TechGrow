package techgrow.plants;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import techgrow.summerWateringNeeds.SummerWateringNeeds;
import techgrow.wateringSchedule.WateringSchedule;
import java.util.List;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Plant {
    @Id
    @GeneratedValue
    private int plantId;
    private String species;

    @JsonIgnore
    @OneToMany(mappedBy = "plant")
    private List<WateringSchedule> wateringSchedule;
    public List<WateringSchedule> getWateringSchedule() {
        return wateringSchedule;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "plant1")
    private SummerWateringNeeds summerWateringNeeds;
}
