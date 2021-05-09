package repository;

import entity.Client;
import entity.Phone;

import java.util.List;

public interface PhoneDAO {
    void addNewPhone(List<Phone> phones);
}
