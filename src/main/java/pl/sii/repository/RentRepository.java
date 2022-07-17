package pl.sii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sii.model.Rent;

public interface RentRepository extends JpaRepository<Rent, Long> {
}
