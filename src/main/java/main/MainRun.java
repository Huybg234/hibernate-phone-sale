package main;

import billTable.Bill;
import entity.Client;
import entity.Phone;
import repository.ClientDAOImp;
import repository.PhoneDAOImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainRun {
    public static List<Client> clients = new ArrayList<>();
    public static List<Phone> phones = new ArrayList<>();
    public static List<Bill> bills = new ArrayList<>();

    public static final ClientDAOImp clientDAO = new ClientDAOImp();
    public static final PhoneDAOImp phoneDAO = new PhoneDAOImp();

    private static final ClientCreator clientCreator = new ClientCreator();
    private static final PhoneCreator phoneCreator = new PhoneCreator();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    createNewClient();
                    printClient();
                    break;
                case 2:
                    createNewPhone();
                    printPhone();
                    break;
            }
        } while (true);
    }

    public static int functionChoice() {
        System.out.println("-----QUẢN LÝ BÁN ĐIỆN THOẠI DI ĐỘNG-----");
        System.out.println("1.Nhập danh sách khách hàng");
        System.out.println("2.Nhập danh sách sản phẩm");
        System.out.println("3.Nhập danh sách mua hàng cho mỗi khách hàng");
        System.out.println("4.Sắp xếp danh sách mua hàng");
        System.out.println("5.Lập bảng thống kê tổng tiền phải trả cho mỗi khách hàng: ");
        System.out.println("6.Thoát");
        System.out.println("Nhập sự lựa chọn của bạn: ");
        int functionChoice = 0;
        boolean checkFunction = true;
        do {
            try {
                functionChoice = new Scanner(System.in).nextInt();
                checkFunction = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                continue;
            }
            if (functionChoice <= 0 || functionChoice > 6) {
                System.out.print("Nhập số trong khoảng từ 1 đến 6! Nhập lại: ");
                checkFunction = false;
            } else break;
        } while (!checkFunction);
        return functionChoice;
    }

    public static void createNewClient() {
        clientCreator.createNewClient();
    }

    public static void printClient() {
        clients.forEach(System.out::println);
    }

    public static void createNewPhone() {
        phoneCreator.createNewPhone();
    }

    public static void printPhone() {
        phones.forEach(System.out::println);
    }
}
