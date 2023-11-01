package techgrow.wateringSchedule;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.time.Period;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="WETERING_SCHEDULE")
public class WateringSchedule {
    @Id
    private int scheduleId;
    private LocalDateTime nextSchedule;
    private Period period;

}
