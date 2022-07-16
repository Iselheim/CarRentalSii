package pl.sii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sii.model.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
