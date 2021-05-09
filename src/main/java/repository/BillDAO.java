package repository;

import entity.BillEntity;

import java.util.List;

public interface BillDAO {

    void addNewBill(List<BillEntity> bills);

}
