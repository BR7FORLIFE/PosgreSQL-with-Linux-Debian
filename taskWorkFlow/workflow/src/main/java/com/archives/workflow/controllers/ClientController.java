package com.archives.workflow.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.archives.workflow.models.Client;
import com.archives.workflow.services.ClientService;

@RestController
@RequestMapping("/api")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/client/all")
    public ResponseEntity<List<Client>> getAllClient() {
        List<Client> listClient = clientService.getAllClient();
        return ResponseEntity.ok().body(listClient);
    }

    @GetMapping("/client/{id}")
    public Client getClientById(@PathVariable UUID id) {
        return clientService.getClientById(id);
    }

    @GetMapping("/client/rol/{client}")
    public Client getForRol(@PathVariable Client client) {
        return null;
    }

    @GetMapping("/client/exists/{id}")
    public Boolean getExitsForClient(@PathVariable UUID id) {
        return null;
    }

    @PostMapping("/client/create")
    public void saveClient(@RequestBody Client client) {

    }

    @PutMapping("/client/create/{id}")
    public void updateClient(@PathVariable UUID id, @RequestBody Client client) {

    }

    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable UUID id) {

    }
}
