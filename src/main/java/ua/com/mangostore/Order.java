package ua.com.mangostore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private long orderId;

    @Column(nullable = false, name = "DATE_CREATED")
    Date dateCreated ;

    @Column(nullable = false, name = "NAME_RECIPIENT")
    String nameRecipient;

    @Column(nullable = false, name = "SURNAME_RECIPIENT")
    String surnameRecipient;

    @Column(nullable = false, name = "ADDRESS_RECIPIENT")
    String addressRecipient;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "order")
    private Basket basket;

    public Order() {
    }

    public Order(String nameRecipient, String surnameRecipient, String addressRecipient) {
        this.dateCreated = new Date();
        this.nameRecipient = nameRecipient;
        this.surnameRecipient = surnameRecipient;
        this.addressRecipient = addressRecipient;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getNameRecipient() {
        return nameRecipient;
    }

    public void setNameRecipient(String nameRecipient) {
        this.nameRecipient = nameRecipient;
    }

    public String getSurnameRecipient() {
        return surnameRecipient;
    }

    public void setSurnameRecipient(String surnameRecipient) {
        this.surnameRecipient = surnameRecipient;
    }

    public String getAddressRecipient() {
        return addressRecipient;
    }

    public void setAddressRecipient(String addressRecipient) {
        this.addressRecipient = addressRecipient;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", dateCreated=" + dateCreated +
                ", nameRecipient='" + nameRecipient + '\'' +
                ", surnameRecipient='" + surnameRecipient + '\'' +
                ", addressRecipient='" + addressRecipient + '\'' +
                '}';
    }
}
