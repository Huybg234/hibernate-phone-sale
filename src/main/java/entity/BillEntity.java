package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "bill")
public class BillEntity implements Serializable {

    @Column(name = "client_id", nullable = false)
    private int clientId;

    @Column(name = "phone_id", nullable = false)
    private int phoneId;

    @Column(nullable = false)
    private int amount;

    public BillEntity() {
    }

    public BillEntity(int clientId, int phoneId, int amount) {
        this.clientId = clientId;
        this.phoneId = phoneId;
        this.amount = amount;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
