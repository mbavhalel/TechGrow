package techgrow.wateringSchedule;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import techgrow.plants.Plant;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WateringSchedule {
    @Id
    @GeneratedValue
    private int scheduleId;
    private String nextSchedule; //localDate
    private String period; //Period

    @ManyToOne
    @JoinColumn(name = "fk_plant_id", referencedColumnName = "plantId")
    private Plant plant;
    public Plant getPlant() {
        return plant;
    }

    public void addPlant(Plant plantEdit) {
        this.plant = plantEdit;
    }
}
