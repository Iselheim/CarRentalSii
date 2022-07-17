package pl.sii.services;

import java.time.Instant;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sii.api.RentController;
import pl.sii.model.Car;
import pl.sii.model.Rent;
import pl.sii.repository.BranchRepository;
import pl.sii.repository.CarRepository;
import pl.sii.repository.ClientRepository;
import pl.sii.repository.RentRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class RentService {

    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final RentRepository rentRepository;

    public Long rent(RentController.RentRequest rentRequest) {
        return clientRepository.getClientByName(rentRequest.getClientName())
            .map(client -> {
                List<Car> cars = carRepository.findAllByIdIn(rentRequest.getCarIds());
                Rent rent = Rent.builder()
                    .rentedCars(cars)
                    .type(rentRequest.getType())
                    .startDate(Instant.now())
                    .rentDays(rentRequest.getDays())
                    .cLient(client)
                    .build();
                cars.forEach(car -> car.setCurrentBranch(null));
                return rentRepository.save(rent).getId();
            })
            .orElseThrow(() -> new RuntimeException("Can't create reservation"));
    }

}
