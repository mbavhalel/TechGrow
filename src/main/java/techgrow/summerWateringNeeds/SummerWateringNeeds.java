package techgrow.summerWateringNeeds;

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
    public class SummerWateringNeeds {
    @Id
    @GeneratedValue
    private int weteringId;
    private int howOften;
    private int howDeep;

    @OneToOne
    @JoinColumn(name = "fk_plant_id")
    private Plant plant;
    public void addNeed(Plant plantEdit) {
        this.plant = plantEdit;
    }
}
