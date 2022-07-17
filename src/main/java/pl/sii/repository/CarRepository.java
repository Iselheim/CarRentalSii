package pl.sii.repository;

import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sii.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByIdIn(List<Long> ids);

    List<Car> findAll(Specification<Car> specification);

}
