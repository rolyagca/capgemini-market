package com.capgemini.market.domain.repository;

import com.capgemini.market.domain.Client;

import java.util.List;
import java.util.Optional;


public interface ClientRepository {
    List<Client> getAll();
    Optional<Client> getClientByEmail(String email);
    Optional<Client> getClient(String id);
    Optional<List<Client>> getClientsByNameAndLastName(String name, String lastName);
    Client save(Client client);
    void delete(String id);

    Optional<Client> updateNameClient(String name, String lastName, String id);
}
