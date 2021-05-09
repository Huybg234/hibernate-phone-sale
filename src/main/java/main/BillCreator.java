package main;

import billTable.Bill;
import billTable.ClientBill;
import entity.BillEntity;
import entity.Client;
import entity.NewBillEntity;
import entity.Phone;
import repository.BillDAO;
import util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillCreator {
    public boolean isValidClientAndPhone() {
        return !MainRun.clients.isEmpty() && !MainRun.phones.isEmpty();
    }

    public void createBillTable() {
        if (!isValidClientAndPhone()) {
            System.out.println("bạn cần nhập khách hàng và điện thoại trước khi thống kế");
            return;
        }
        List<Bill> tmpBill = new ArrayList<>();
        List<BillEntity> billEntities = new ArrayList<>();
//        List<NewBillEntity> newBillEntities = new ArrayList<>();
        for (int i = 0; i < MainRun.clients.size(); i++) {
            Client client = MainRun.clients.get(i);
            String clientName = client.getName();
            System.out.println("-------Thống kê hóa đơn cho khách hàng " + clientName + "------");
            System.out.println("Nhập số điện thoại khách hàng muốn mua: ");
            int phoneQuantity = inputPhoneQuantity();
            if (phoneQuantity == 0) {
                continue;
            }
            List<ClientBill> clientBills = new ArrayList<>();
            for (int j = 0; j < phoneQuantity; j++) {
                System.out.println("Nhập id loại điện thoại thứ " + (j + 1) + " mà khách hàng " + clientName + " muốn mua: ");
                Phone phone = inputPhoneID();
                System.out.println("Nhập số lượng điện thoại loại này muốn mua: ");
                int amount = inputBuyPhoneNumber();
                clientBills.add(new ClientBill(phone, amount));
                billEntities.add(new BillEntity(client.getId(), phone.getId(), amount));
//                newBillEntities.add(new NewBillEntity(client, phone, amount));
            }
            Bill bill = new Bill(client, clientBills);
            tmpBill.add(bill);
        }
        MainRun.bills.addAll(tmpBill);
        MainRun.billDAO.addNewBill(billEntities);
//        MainRun.billDAO.addNewBill(newBillEntities);
    }

    private int inputBuyPhoneNumber() {
        int buyPhoneNumber = 0;
        boolean isValidBuyPhoneNumber = true;
        do {
            try {
                buyPhoneNumber = new Scanner(System.in).nextInt();
                isValidBuyPhoneNumber = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                isValidBuyPhoneNumber = false;
                continue;
            }
            if (buyPhoneNumber < 0) {
                System.out.print("Số lượng muốn mua không được nhỏ hơn 0! Nhập lại: ");
                isValidBuyPhoneNumber = false;
            }
        } while (!isValidBuyPhoneNumber);
        return buyPhoneNumber;
    }

    private Phone inputPhoneID() {
        int phoneId = 0;
        boolean isValidPhoneId = false;
        do {
            try {
                phoneId = new Scanner(System.in).nextInt();
                isValidPhoneId = true;
            } catch (Exception e) {
                System.out.println("không được có ký tự khác ngoài số! Nhập lại: ");
                isValidPhoneId = false;
                continue;
            }
            Phone phone = searchPhoneId(phoneId);
            if (ObjectUtil.isEmpty(phone)) {
                System.out.print("Không có id loại điện thoại vừa nhập! Nhập lại: ");
                isValidPhoneId = false;
                continue;
            }
            return phone;
        } while (!isValidPhoneId);
        return null;
    }

    private Phone searchPhoneId(int phoneId) {
        System.out.println(MainRun.phones.size());
        for (int i = 0; i < MainRun.phones.size(); i++) {
            if (MainRun.phones.get(i).getId() == phoneId) {
                return MainRun.phones.get(i);
            }
        }
        return null;
    }

    private int inputPhoneQuantity() {
        boolean isValidPhoneQuantity = true;
        int phoneQuantity = 0;
        do {
            try {
                phoneQuantity = new Scanner(System.in).nextInt();
                isValidPhoneQuantity = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                isValidPhoneQuantity = false;
                continue;
            }
            if (phoneQuantity < 0 || phoneQuantity > MainRun.phones.size()) {
                System.out.print("Số điện thoại muốn mua phải lớn hơn 0 và nhỏ hơn tổng số điện thoại! Nhập lại: ");
                isValidPhoneQuantity = false;
            }

        } while (!isValidPhoneQuantity);
        return phoneQuantity;
    }

}
