package pl.sii.dto;

import java.util.stream.Collectors;
import pl.sii.model.Client;

public class ClientMapper {

    public static ClientDto toDto(Client client) {
        if (Client.Type.PERSON.equals(client.getType())) {
            return ClientDto.builder()
                .type(client.getType())
                .name(client.getName())
                .id(client.getId())
                .organization(ClientDto.builder()
                    .type(client.getOrganization().getType())
                    .name(client.getOrganization().getName())
                    .build())
                .build();
        } else {
            return ClientDto.builder()
                .type(client.getType())
                .name(client.getName())
                .id(client.getId())
                .users(client.getUsers().stream()
                    .map(person -> ClientDto.builder()
                        .type(person.getType())
                        .name(person.getName())
                        .build())
                    .collect(Collectors.toList()))
                .build();
        }


    }

}
