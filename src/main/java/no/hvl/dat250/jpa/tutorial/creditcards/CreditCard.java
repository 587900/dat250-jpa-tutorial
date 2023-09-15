package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer creditLimit;
    private Integer balance;
    @ManyToMany
    private Collection<Customer> customers = new ArrayList<>();
    @ManyToOne
    private Pincode pincode;
    @ManyToOne
    private Bank bank;

    public Bank getOwningBank() { return getBank(); }
}