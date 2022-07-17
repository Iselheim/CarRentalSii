package pl.sii.api;

import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sii.model.Rent;
import pl.sii.services.RentService;
import pl.sii.services.ReturnService;

@RestController
@Slf4j
@RequiredArgsConstructor
public class RentController {

    private final RentService rentService;
    private final ReturnService returnService;

    @PostMapping("/rent")
    public Long rent(@RequestBody RentRequest rentRequest) {
        return rentService.rent(rentRequest);
    }

    @PostMapping("/return")
    public Boolean returnCars(@RequestBody ReturnRequest returnRequest) {
        return returnService.returnCars(returnRequest);
    }

    @Value
    @ToString
    public static class RentRequest {
        String clientName;
        List<Long> carIds;
        LocalDate startDate;
        Rent.Type type;
        Integer days;
    }

    @Value
    public static class ReturnRequest {
        Long rentId;
        String branchName;
    }

}
