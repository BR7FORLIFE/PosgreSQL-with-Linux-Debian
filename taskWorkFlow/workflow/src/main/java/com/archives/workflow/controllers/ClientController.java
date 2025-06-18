package com.archives.workflow.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.archives.workflow.models.Client;
import com.archives.workflow.services.ClientService;


@RestController
@RequestMapping("/api")
public class ClientController {
    
    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping("/client/all")
    public ResponseEntity<List<Client>> getAllClient(){
        List<Client> listClient = clientService.getAllClient();
        return ResponseEntity.ok().body(listClient);
    }
}
