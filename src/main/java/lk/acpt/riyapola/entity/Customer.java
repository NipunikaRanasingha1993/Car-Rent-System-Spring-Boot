package lk.acpt.riyapola.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String city;
    private int contact;
    private String email;

    public Customer(Integer id, String name, String city, int contact, String email) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.contact = contact;
        this.email = email;
    }

    public Customer() {
    }

    public Customer(String name, String city, int contact, String email) {
        this.name = name;
        this.city = city;
        this.contact = contact;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


        public int getContact() {
            return contact;
        }

        public void setContact(int contact) {
            this.contact = contact;
        }





    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
