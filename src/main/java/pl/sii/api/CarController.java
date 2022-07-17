package pl.sii.api;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sii.dto.CarDto;
import pl.sii.dto.CarMapper;
import pl.sii.repository.CarRepository;
import pl.sii.services.SearchService;

@RestController
@RequiredArgsConstructor
class CarController {

    private final CarRepository carRepository;
    private final SearchService searchService;

    @GetMapping("/cars")
    public List<CarDto> getCars() {
        return carRepository.findAll().stream()
            .map(CarMapper::toDto)
            .collect(Collectors.toList());
    }

    @GetMapping("/cars/by")
    public List<CarDto> getCarsByCriteria(@RequestParam(required = false) String branchName) {
        return searchService.search(branchName);
    }

}
