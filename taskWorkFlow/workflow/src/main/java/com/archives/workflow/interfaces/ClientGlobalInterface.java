package com.archives.workflow.interfaces;

import java.util.List;
import java.util.UUID;

import com.archives.workflow.models.Client;

public interface ClientGlobalInterface {
    // read
    List<Client> getAllClient();

    Client getClientbyId(UUID id);

    Client getForRol(Client client);

    Boolean getExitsForClient(UUID id);

    // create
    void saveClient(Client client);

    // update
    void updateClient(Client client);

    // delete
    void deleteClient(UUID id);
}
