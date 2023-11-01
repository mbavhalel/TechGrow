package techgrow.wateringNeeds;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="WETERING_NEEDS")
    public class WateringNeeds {
    @Id
    public int weteringId;
    private String plantType;
    private int howOften;
    private int howDeep;
}
