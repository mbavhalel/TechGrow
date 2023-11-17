package techgrow.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import techgrow.wateringSchedule.WateringSchedule;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private int userId;
    private String username;
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<WateringSchedule> wateringSchedule;
}
