package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bill")
public class NewBillEntity implements Serializable {

    @ManyToOne(targetEntity = "entity.Client")
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @JoinColumn(name = "phone_id", nullable = false)
    @ManyToOne(targetEntity = "entity.Phone", fetch = FetchType.LAZY)
    private Phone phone;

    @Column(nullable = false)
    private int amount;

    public NewBillEntity() {
    }

    public NewBillEntity(Client client, Phone phone, int amount) {
        this.client = client;
        this.phone = phone;
        this.amount = amount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
