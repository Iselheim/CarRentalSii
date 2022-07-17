package pl.sii.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.sii.model.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {

    Optional<Branch> findByCity_Name(String name);

}
