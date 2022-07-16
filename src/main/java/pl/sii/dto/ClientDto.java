package pl.sii.dto;

import java.util.List;
import lombok.Builder;
import lombok.Value;
import pl.sii.model.Client;

@Value
@Builder
public class ClientDto {
    Long id;
    Client.Type type;
    String name;
    List<ClientDto> users;
    ClientDto organization;
}
