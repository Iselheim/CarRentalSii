package pl.sii.dto;

import pl.sii.model.Car;

public class CarMapper {

    public static CarDto toDto(Car car){
        return CarDto.builder()
            .currentBranchName(car.getCurrentBranch().getCity().getName())
            .id(car.getId())
            .mark(car.getMark())
            .type(car.getType())
            .equipmentType(car.getEquipmentType())
            .price(car.getPrice())
            .build();
    }

}
