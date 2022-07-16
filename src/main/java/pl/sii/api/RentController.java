package pl.sii.api;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sii.model.Rent;
import pl.sii.services.RentService;

@RestController
@Slf4j
@RequiredArgsConstructor
public class RentController {

    private final RentService rentService;

    @PostMapping("/rent")
    public void rent(@RequestBody RentRequest rentRequest) {
        log.error(rentRequest.toString());
        rentService.rent(rentRequest);
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

}
