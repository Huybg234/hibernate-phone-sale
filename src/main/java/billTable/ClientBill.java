package billTable;

import entity.Phone;

public class ClientBill {
    private Phone phone;
    private int amount;

    public ClientBill() {
    }

    public ClientBill(Phone phone, int amount) {
        this.phone = phone;
        this.amount = amount;
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

    @Override
    public String toString() {
        return "ClientBill{" +
                "phone=" + phone +
                ", amount=" + amount +
                '}';
    }
}
