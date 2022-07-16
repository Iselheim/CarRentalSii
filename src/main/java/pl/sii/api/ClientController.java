package pl.sii.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.sii.dto.ClientDto;
import pl.sii.dto.ClientMapper;
import pl.sii.repository.ClientRepository;

@RestController
@RequiredArgsConstructor
class ClientController {

    private final ClientRepository clientRepository;

    @GetMapping("/client/{id}")
    public ClientDto getClient(@PathVariable("id") Long id) {
        return clientRepository.findById(id)
            .map(ClientMapper::toDto)
            .orElseThrow(() -> new RuntimeException("can't find Client"));
    }

}
