package pl.sii.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pl.sii.dto.CarDto;
import pl.sii.dto.CarMapper;
import pl.sii.model.Car;
import pl.sii.repository.CarRepository;

@Service
@AllArgsConstructor
public class SearchService {

    private final CarRepository carRepository;

    public List<CarDto> search(String branchName
//                               String category, //TYPE
//                               String mark,
//                               String equipmentType,
//                               BigDecimal priceFrom,
//                               BigDecimal priceTo
    ) {
        Specification<Car> specification = (root, criteriaQuery, criteriaBuilder) -> {

            List<Predicate> predicateList = new ArrayList<>();

            if (StringUtils.hasText(branchName)) {
                predicateList.add(criteriaBuilder.and(criteriaBuilder.like(root.get("mainBranch").get("city").get("name"), branchName)));
            }

            return criteriaBuilder.and(predicateList.toArray(Predicate[]::new));

        };

        return carRepository.findAll(specification).stream()
            .map(CarMapper::toDto)
            .collect(Collectors.toList());
    }

}
