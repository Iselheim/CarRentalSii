package pl.sii.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private City city;

    @OneToMany(mappedBy = "mainBranch", cascade = CascadeType.ALL)
    private List<Car> mainCars = new ArrayList<>();

    @OneToMany(mappedBy = "currentBranch", cascade = CascadeType.ALL)
    private List<Car> availableCars = new ArrayList<>();
}
