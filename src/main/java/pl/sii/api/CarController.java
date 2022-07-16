package pl.sii.api;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sii.dto.CarDto;
import pl.sii.dto.CarMapper;
import pl.sii.repository.CarRepository;

@RestController
@RequiredArgsConstructor
class CarController {

    private final CarRepository carRepository;

    @GetMapping("/cars")
    public List<CarDto> getCars() {
        return carRepository.findAll().stream()
            .map(CarMapper::toDto)
            .collect(Collectors.toList());
    }

}
