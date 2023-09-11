package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.HashSet;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;
    @ManyToMany
    @JoinTable(name = "Address_Customer", joinColumns = @JoinColumn(name = "Address_id"), inverseJoinColumns = @JoinColumn(name = "Customer_id"))
    private Collection<Customer> owners = new HashSet<>();
}