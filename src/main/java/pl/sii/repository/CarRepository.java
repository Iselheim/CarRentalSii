package pl.sii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sii.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
