package ua.com.mangostore;

import javax.persistence.*;

@Entity
@Table(name = "CreditCards")
public class CreditCard {
    @Id
    @Column(nullable = false, name = "CARDS_ID")
    private long cardId;

    @Column(nullable = false, name = "NAME_OWNER")
    private String name;

    @Column(nullable = false, name = "SURNAME_OWNER")
    private String surname;

    @Column(nullable = false, name = "EXPIRES_END")
    private String expiresEnd;

    @Column(nullable = false, name = "CODE")
    private int code;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    public CreditCard() {
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getExpiresEnd() {
        return expiresEnd;
    }

    public void setExpiresEnd(String expiresEnd) {
        this.expiresEnd = expiresEnd;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
