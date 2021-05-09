package billTable;

import entity.Client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bill")

public class Bill {

    private Client client;
    private List<ClientBill> clientBills = new ArrayList<>();

    @Column(name = "client_id", nullable = false)
    private int client_id;

    @Column(name = "phone_id", nullable = false)
    private int phone_id;

    @Column(name = "amount", nullable = false)
    private int amount;

    public Bill() {
    }

    public Bill(Client client, List<ClientBill> clientBills) {
        this.client = client;
        this.clientBills = clientBills;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ClientBill> getClientBills() {
        return clientBills;
    }

    public void setClientBills(List<ClientBill> clientBills) {
        this.clientBills = clientBills;
    }
}
