package techgrow.plants;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
@Table(name = "TABLE")
public class Plant {
    @Id
    @GeneratedValue
    private int plantId;
    private String species;
    private String location;
    private int wateringNeedsID;
}
