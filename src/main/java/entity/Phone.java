package entity;

import javax.persistence.*;
import java.util.Scanner;

@Entity
@Table(name = "phone")

public class Phone {
    @Id
    @Column(name = "id")
    private int id = 10000;

    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "cost", nullable = false)
    private float cost;

    private static int AUTO_ID = 10000;

    public Phone() {
    }

    public Phone(int id, String manufacturer, String model, float cost) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void insertPhoneInfo() {
        this.setId(Phone.AUTO_ID);

        System.out.println("Nhập hãng sản xuất: ");
        this.manufacturer = new Scanner(System.in).nextLine();
        System.out.println("Nhập model sản phẩm: ");
        this.model = new Scanner(System.in).nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        this.cost = new Scanner(System.in).nextFloat();

        Phone.AUTO_ID++;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", cost=" + cost +
                '}';
    }
}
