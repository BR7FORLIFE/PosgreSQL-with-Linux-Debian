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
    public ResponseEntity<Client> getClientById(@PathVariable UUID id) {
        if (!(id instanceof UUID))
            return ResponseEntity.badRequest().body(new Client());
        Client _client = clientService.getClientbyId(id);
        return ResponseEntity.ok().body(_client);
    }

    @GetMapping("/client/rol/{client}")
    public ResponseEntity<Client> getForRol(@PathVariable Client client) {
        if (client == null)
            return ResponseEntity.badRequest().body(new Client());
        Client _client = clientService.getForRol(client);
        return ResponseEntity.ok().body(_client);
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
