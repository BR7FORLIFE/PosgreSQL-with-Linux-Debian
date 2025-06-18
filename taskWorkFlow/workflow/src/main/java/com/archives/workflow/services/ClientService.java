package com.archives.workflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.archives.workflow.models.Client;
import com.archives.workflow.repository.ClientRepositoryImp;

@Service
public class ClientService {
    private final ClientRepositoryImp clientRepositoryImp;

    public ClientService(ClientRepositoryImp clientRepositoryImp){
        this.clientRepositoryImp = clientRepositoryImp;
    }

    public List<Client> getAllClient(){
        return clientRepositoryImp.getAllClient();
    }
}
