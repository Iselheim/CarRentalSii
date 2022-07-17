package pl.sii.services;

import java.time.Instant;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;
import pl.sii.api.RentController;
import pl.sii.repository.BranchRepository;
import pl.sii.repository.RentRepository;

@Service
@RequiredArgsConstructor
public class ReturnService {

    private final RentRepository rentRepository;
    private final BranchRepository branchRepository;

    public boolean returnCars(RentController.ReturnRequest returnRequest) {
        return rentRepository.findById(returnRequest.getRentId())
            .flatMap(rent -> branchRepository.findByCity_Name(returnRequest.getBranchName())
                .map(branch -> {
                    rent.setEndDate(Instant.now());
                    rent.getRentedCars().forEach(car -> car.setCurrentBranch(branch));
                    rentRepository.save(rent);
                    return true;
                })).orElseThrow(() -> new RuntimeException("Can't return cars"));
    }

}
