package com.archives.workflow.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.archives.workflow.interfaces.ClientGlobalInterface;
import com.archives.workflow.models.Client;
import com.archives.workflow.repository.ClientRepositoryImp;

@Service
public class ClientService implements ClientGlobalInterface {
    private final ClientRepositoryImp clientRepositoryImp;

    public ClientService(ClientRepositoryImp clientRepositoryImp) {
        this.clientRepositoryImp = clientRepositoryImp;
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepositoryImp.getAllClient();
    }

    @Override
    public Client getClientbyId(UUID id) {
        if (!(id instanceof UUID))
            return null;
        return clientRepositoryImp.getClientbyId(id);
    }

    @Override
    public Client getForRol(Client client) {
        if (client == null)
            return null; // <-- por si el cliente es vacio
        return clientRepositoryImp.getForRol(client);
    }

    @Override
    public Boolean getExitsForClient(UUID id) {
        return null;
    }

    @Override
    public void saveClient(Client client) {
        clientRepositoryImp.saveClient(client);
    }

    @Override
    public void updateClient(Client client) {
        clientRepositoryImp.updateClient(client);
    }

    @Override
    public void deleteClient(UUID id) {
        clientRepositoryImp.deleteClient(id);
    }
}
