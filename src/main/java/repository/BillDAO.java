package repository;

import billTable.Bill;
import entity.Client;

import java.util.List;

public interface BillDAO {
    void addNewBill(List<Bill> bills);
}
