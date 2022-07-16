package pl.sii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sii.model.Client;
import pl.sii.repository.ClientRepository;

@Service
@RequiredArgsConstructor
class InitService {

    private final ClientRepository clientRepository;

    @PostConstruct
    public void initDatabase() {
        Client sii = Client.builder()
            .type(Client.Type.ORGANIZATION)
            .name("Sii")
            .users(new ArrayList<>())
            .build();

        Client client1 = Client.builder()
            .type(Client.Type.PERSON)
            .organization(sii)
            .name("Halina")
            .users(new ArrayList<>())
            .build();

        Client client2 = Client.builder()
            .type(Client.Type.PERSON)
            .name("Grażyna")
            .users(new ArrayList<>())
            .organization(sii)
            .build();

        sii.getUsers().addAll(Arrays.asList(client1, client2));

        clientRepository.save(sii);
    }
}
