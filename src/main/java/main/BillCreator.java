package main;

import billTable.Bill;
import billTable.ClientBill;
import entity.Phone;
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
        for (int i = 0; i < MainRun.clients.size(); i++) {
            String clientName = MainRun.clients.get(i).getName();
            System.out.println("-------Thống kê hóa đơn cho khách hàng " + clientName + "------");
            System.out.println("Nhập số loại điện thoại khách hàng muốn mua: ");
            int typePhoneNumber = inputTypePhoneNumber();
            if (typePhoneNumber == 0) {
                continue;
            }
            List<ClientBill> clientBills = new ArrayList<>();
            for (int j = 0; j < typePhoneNumber; j++) {
                System.out.println("Nhập id loại điện thoại thứ " + (j + 1) + " mà khách hàng " + clientName + " muốn mua: ");
                Phone phone = inputPhoneID();
                System.out.println("Nhập số lượng điện thoại loại này muốn mua: ");
                int buyPhoneNumber = inputBuyPhoneNumber();
                clientBills.add(new ClientBill(phone,buyPhoneNumber));
            }
            Bill bill = new Bill(MainRun.clients.get(i),clientBills);
            tmpBill.add(bill);
            MainRun.bills.add(bill);
        }
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
        boolean isValidPhoneId = true;
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
            } else return phone;
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

    private int inputTypePhoneNumber() {
        boolean isValidTypePhoneNumber = true;
        int typePhoneNumber = 0;
        do {
            try {
                typePhoneNumber = new Scanner(System.in).nextInt();
                isValidTypePhoneNumber = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                isValidTypePhoneNumber = false;
                continue;
            }
            if (typePhoneNumber < 0 || typePhoneNumber > MainRun.phones.size()) {
                System.out.print("Số điện thoại muốn mua phải lớn hơn 0 và nhỏ hơn tổng số điện thoại! Nhập lại: ");
                isValidTypePhoneNumber = false;
            }

        } while (!isValidTypePhoneNumber);
        return typePhoneNumber;
    }
}
