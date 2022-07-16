package pl.sii;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
class DatabaseFillService {

//    private final CarRepository carRepository;
//    private final BranchRepository branchRepository;
//    private final ClientRepository clientRepository;
//
//    @PostConstruct
//    public void init(){
//
//        addBranch("Warszawa");
//        addBranch("Kraków");
//        addBranch("Wrocław");
//
//        addClients("Sii");
//
//    }
//
//    private void addClients(String orgName) {
//        Client organization = Client.builder()
//            .type(Client.Type.ORGANIZATION)
//            .name(orgName)
//            .users(new ArrayList<>())
//            .build();
//
//        Client client1 = Client.builder()
//            .type(Client.Type.PERSON)
//            .users(new ArrayList<>())
//            .name("Janek")
//            .organization(organization)
//            .build();
//
//        Client client2 = Client.builder()
//            .type(Client.Type.PERSON)
//            .users(new ArrayList<>())
//            .name("Franek")
//            .organization(organization)
//            .build();
//
//        Client client3 = Client.builder()
//            .type(Client.Type.PERSON)
//            .users(new ArrayList<>())
//            .name("Halina")
//            .organization(organization)
//            .build();
//
//        organization.getUsers().addAll(Arrays.asList(client1, client2, client3));
//
//        clientRepository.save(organization);
//    }
//
//    private void addBranch(String cityName) {
//        Branch branch = Branch.builder()
//            .city(new City(cityName, "dasdas", "123123"))
//            .mainCars(new ArrayList<>())
//            .availableCars(new ArrayList<>())
//            .build();
//
//        Car fiat = Car.builder()
//            .currentBranch(branch)
//            .mainBranch(branch)
//            .equipmentType(Car.EquipmentType.LOW)
//            .mark("FIAT")
//            .price(new BigDecimal(50))
//            .type(Car.Type.A)
//            .build();
//
//        Car fiat2 = Car.builder()
//            .currentBranch(branch)
//            .mainBranch(branch)
//            .equipmentType(Car.EquipmentType.MEDIUM)
//            .mark("FIAT")
//            .price(new BigDecimal(150))
//            .type(Car.Type.C)
//            .build();
//
//        Car bmw = Car.builder()
//            .currentBranch(branch)
//            .mainBranch(branch)
//            .equipmentType(Car.EquipmentType.MEDIUM)
//            .mark("BMW")
//            .price(new BigDecimal(200))
//            .type(Car.Type.D)
//            .build();
//
//        Car bmw2 = Car.builder()
//            .currentBranch(branch)
//            .mainBranch(branch)
//            .equipmentType(Car.EquipmentType.HIGH)
//            .mark("BMW")
//            .price(new BigDecimal(300))
//            .type(Car.Type.PREMIUM)
//            .build();
//
//        List<Car> cars = Arrays.asList(fiat, fiat2, bmw, bmw2);
//        branch.getAvailableCars().addAll(cars);
//        branch.getMainCars().addAll(cars);
//
//        branchRepository.save(branch);
//    }

}
