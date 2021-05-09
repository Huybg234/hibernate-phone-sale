package repository;

import entity.Client;

import java.util.List;

public interface ClientDAO {
    void addNewClient(List<Client> clients);
}
