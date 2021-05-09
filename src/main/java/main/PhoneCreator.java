package main;

import entity.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneCreator {
    public void createNewPhone() {
        System.out.println("Nhập số lượng điện thoại muốn thêm mới: ");
        int phoneQuantity = 0;
        boolean isValidPhoneQuantity = true;
        do {
            try {
                phoneQuantity = new Scanner(System.in).nextInt();
                isValidPhoneQuantity = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                isValidPhoneQuantity = false;
                continue;
            }
            if (phoneQuantity <= 0) {
                System.out.print("Số lượng điện thoại không được nhỏ hơn 0! Nhập lại: ");
                isValidPhoneQuantity = false;
            }
        } while (!isValidPhoneQuantity);

        List<Phone> tmpPhone = new ArrayList<>();
        for (int i = 0; i < phoneQuantity; i++) {
            Phone phone = new Phone();
            phone.insertPhoneInfo();
            tmpPhone.add(phone);
        }
        MainRun.phones.addAll(tmpPhone);
        MainRun.phoneDAO.addNewPhone(tmpPhone);
    }
}
