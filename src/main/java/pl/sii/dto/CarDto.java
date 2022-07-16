package pl.sii.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Value;
import pl.sii.model.Car;

@Value
@Builder
public class CarDto {
    Long id;
    String currentBranchName;
    Car.Type type;
    String mark;
    BigDecimal price;
    Car.EquipmentType equipmentType;
}
