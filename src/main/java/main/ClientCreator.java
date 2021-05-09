package main;

import entity.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientCreator {
    public void createNewClient() {
        System.out.println("Nhập số lượng khách hàng muốn thêm mới: ");
        int clientQuantity = 0;
        boolean isValidClientQuantity = true;
        do {
            try {
                clientQuantity = new Scanner(System.in).nextInt();
                isValidClientQuantity = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                isValidClientQuantity = false;
                continue;
            }
            if (clientQuantity <= 0) {
                System.out.print("Số lượng khách hàng không được nhỏ hơn 0! Nhập lại: ");
                isValidClientQuantity = false;
            }
        } while (!isValidClientQuantity);

        List<Client> tmpClient = new ArrayList<>();
        for (int i = 0; i < clientQuantity; i++) {
            Client client = new Client();
            client.insertInfo();
            tmpClient.add(client);
        }
        MainRun.clients.addAll(tmpClient);
        MainRun.clientDAO.addNewClient(tmpClient);
    }
}
