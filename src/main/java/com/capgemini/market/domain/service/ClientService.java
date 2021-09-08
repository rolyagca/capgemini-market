package com.capgemini.market.domain.service;

import com.capgemini.market.domain.Client;
import com.capgemini.market.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(String id){
        System.out.println(clientRepository.getClient(id).get().getPurchases());
        return clientRepository.getClient(id);
    }

    public Optional<Client> getClientByEmail(String email){
        return clientRepository.getClientByEmail(email);
    }

    public Optional<List<Client>> getClientsByNameAndLastName(String name, String lastName){
        return clientRepository.getClientsByNameAndLastName(name, lastName);
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public boolean delete(String id){
        return  getClient(id).map(client -> {
            clientRepository.delete(id);
            return true;
        }).orElse(false);
    }

    public Optional<Client> updateNameClient(String name, String lastName, String id){
        return clientRepository.updateNameClient(name,lastName,id).map(a ->{
            return getClient(id);
        }).orElse(null);
    }
}
