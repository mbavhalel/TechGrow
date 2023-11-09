package techgrow.plants;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import techgrow.autumnWateringNeeds.AutumnWateringNeeds;
import techgrow.springWateringNeeds.SpringWateringNeeds;
import techgrow.summerWateringNeeds.SummerWateringNeeds;
import techgrow.wateringSchedule.WateringSchedule;
import techgrow.winterWateringNeeds.WinterWateringNeeds;

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

    @JsonIgnore
    @OneToOne(mappedBy = "plant")
    private SummerWateringNeeds summerWateringNeeds;

    @JsonIgnore
    @OneToOne(mappedBy = "plant")
    private AutumnWateringNeeds autumnWateringNeeds;

    @JsonIgnore
    @OneToOne(mappedBy = "plant")
    private SpringWateringNeeds springWateringNeeds;

    @JsonIgnore
    @OneToOne(mappedBy = "plant")
    private WinterWateringNeeds winterWateringNeeds;
}
