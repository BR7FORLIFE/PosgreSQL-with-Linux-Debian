package com.archives.workflow.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.archives.workflow.models.Client;
import com.archives.workflow.repository.interfaces.ClientRepositoryInterface;

@Repository
public class ClientRepositoryImp implements ClientRepositoryInterface {
    
    @Override
    public List<Client> getAllClient(){
        return null;
    }

    @Override
    public Client getClientbyId(UUID id){
        return null;
    }

    @Override
    public Client getForRol(Client client){
        return null;
    }

    @Override
    public void saveClient(Client client){
        
    }

    @Override
    public Client updateClient(UUID id){
        return null;
    }

    @Override
    public void deleteClient(UUID id){
        
    }
}
