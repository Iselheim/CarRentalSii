package pl.sii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sii.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
