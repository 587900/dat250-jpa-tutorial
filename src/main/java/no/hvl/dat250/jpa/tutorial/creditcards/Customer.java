package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "Address_Customer", joinColumns = @JoinColumn(name = "Customer_id"), inverseJoinColumns = @JoinColumn(name = "Address_id"))
    private Collection<Address> addresses = new ArrayList<>();
    @ManyToMany
    @JoinTable(name="Customer_CreditCard", joinColumns = @JoinColumn(name = "Customer_id"), inverseJoinColumns = @JoinColumn(name = "CreditCard_id"))
    private Collection<CreditCard> creditCards = new ArrayList<>();
}