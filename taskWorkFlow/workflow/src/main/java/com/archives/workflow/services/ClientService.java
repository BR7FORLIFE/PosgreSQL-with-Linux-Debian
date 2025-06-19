package com.archives.workflow.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.archives.workflow.models.Client;
import com.archives.workflow.repository.ClientRepositoryImp;

@Service
public class ClientService {
    private final ClientRepositoryImp clientRepositoryImp;

    public ClientService(ClientRepositoryImp clientRepositoryImp) {
        this.clientRepositoryImp = clientRepositoryImp;
    }

    public List<Client> getAllClient() {
        return clientRepositoryImp.getAllClient();
    }

    public Client getClientById(UUID id) {
        return clientRepositoryImp.getClientbyId(id);
    }

    public Client getForRol(Client client) {
        return clientRepositoryImp.getForRol(client);
    }

    public void saveClient(Client client) {
        clientRepositoryImp.saveClient(client);
    }

    public void updateClient(Client client) {
        clientRepositoryImp.updateClient(client);
    }

    public void deleteClient(UUID id) {
        clientRepositoryImp.deleteClient(id);
    }
}
