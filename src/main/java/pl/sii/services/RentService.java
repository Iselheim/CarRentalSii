package pl.sii.services;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sii.api.RentController;
import pl.sii.model.Client;
import pl.sii.repository.BranchRepository;
import pl.sii.repository.ClientRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class RentService {

    private final BranchRepository branchRepository;
    private final ClientRepository clientRepository;

    public void rent(RentController.RentRequest rentRequest) {
        Optional<Client> clientByName = clientRepository.getClientByName(rentRequest.getClientName());

    }

}
