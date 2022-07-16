package pl.sii.model;


import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Branch currentBranch;

    @ManyToOne
    private Branch mainBranch;

    @Enumerated(EnumType.STRING)
    private Type type;

    private String mark;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private EquipmentType equipmentType;

    public enum Type {
        A,
        B,
        C,
        D,
        PREMIUM
    }

    public enum EquipmentType {
        LOW,
        MEDIUM,
        HIGH
    }
}
