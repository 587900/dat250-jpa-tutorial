package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.basicexample.Todo;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    Bank bank = new Bank(); // infer id 1
    bank.setName("Pengebank");

    Pincode pincode = new Pincode(); // infer id 1
    pincode.setPincode("123");
    pincode.setCount(1);

    CreditCard card1 = new CreditCard(); // infer id 1
    card1.setNumber(12345);
    card1.setBalance(-5000);
    card1.setCreditLimit(-10000);

    CreditCard card2 = new CreditCard(); // infer id 2
    card2.setNumber(123);
    card2.setBalance(1);
    card2.setCreditLimit(2000);

    Customer customer = new Customer(); // infer id 1
    customer.setName("Max Mustermann");

    Address address = new Address(); // infer id 1
    address.setStreet("Inndalsveien");
    address.setNumber(28);

    // relations
    customer.getAddresses().add(address);
    address.getOwners().add(customer);
    customer.getCreditCards().add(card1);
    customer.getCreditCards().add(card2);
    card1.getCustomers().add(customer);
    card2.getCustomers().add(customer);
    card1.setPincode(pincode);
    card2.setPincode(pincode);
    pincode.getCreditCards().add(card1);
    pincode.getCreditCards().add(card2);
    card1.setBank(bank);
    card2.setBank(bank);
    bank.getCreditCards().add(card1);
    bank.getCreditCards().add(card2);

    // persist
    em.persist(address);
    em.persist(customer);
    em.persist(card1);
    em.persist(card2);
    em.persist(pincode);
    em.persist(bank);
  }
}
