package manutencao.equipamento.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.List;
import java.io.Serializable;



@Table
@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "adress")
    private String adress;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<OrderService> ordersServices;

    public Client() {
    }

    public Client(Long id, String name, String adress, String email, String phone) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<OrderService> getOrdersServices() {
        return ordersServices;
    }

    public void setOrdersServices(List<OrderService> ordersServices) {
        this.ordersServices = ordersServices;
    }
}
