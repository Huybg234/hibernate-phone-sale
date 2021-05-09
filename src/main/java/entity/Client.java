package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Scanner;

@Entity
@Table(name = "client")

public class Client implements Serializable {

    @Id
    @Column(name = "id")
    private int id = 10000;

    @Column(name = "client_group", nullable = false)
    private String clientGroup;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    private static int AUTO_ID = 10000;
    private static final String RETAIL = "mua lẻ";
    private static final String TRADE = "mua buôn";
    private static final String ONLINE = "mua qua mạng";

    public Client() {
    }

    public Client(int id, String clientGroup, String name, String address, String phoneNumber) {
        this.id = id;
        this.clientGroup = clientGroup;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientGroup() {
        return clientGroup;
    }

    public void setClientGroup(String clientGroup) {
        this.clientGroup = clientGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static String getRETAIL() {
        return RETAIL;
    }

    public static String getTRADE() {
        return TRADE;
    }

    public static String getONLINE() {
        return ONLINE;
    }

    public void insertInfo() {
        this.setId(Client.AUTO_ID);

        System.out.println("Nhập họ tên: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ: ");
        this.address = new Scanner(System.in).nextLine();
        System.out.println("Nhập số điện thoại: ");
        this.phoneNumber = new Scanner(System.in).nextLine();
        System.out.println("Nhập nhóm khách hàng hàng: ");
        System.out.println("1.Mua lẻ");
        System.out.println("2.Mua buôn");
        System.out.println("3.Mua online");
        System.out.println("Nhập sự lựa chọn của bạn: ");
        boolean check = true;
        do {
            int choice;
            try {
                choice = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Không thể có ký tự khác ngoài số! Nhập lại: ");
                check = false;
                continue;
            }
            if (choice <= 0 || choice > 3) {
                System.out.println("Chọn từ 1 đến 3!Nhập lại: ");
                check = false;
            }
            switch (choice) {
                case 1:
                    this.setClientGroup(Client.RETAIL);
                    check = true;
                    break;
                case 2:
                    this.setClientGroup(Client.TRADE);
                    check = true;
                    break;
                case 3:
                    this.setClientGroup(Client.ONLINE);
                    check = true;
                    break;
                default:
                    System.out.println("lựa chọn không hợp lệ! Nhập lại: ");
                    check = false;
                    break;
            }
        } while (!check);
        Client.AUTO_ID++;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientGroup='" + clientGroup + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
