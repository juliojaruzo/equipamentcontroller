package manutencao.equipamento.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.io.Serializable;

@Entity
@Table(name = "equipament")
public class Equipament implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "type")
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "equipament")
    private List<OrderService> ordersServices;

    public Equipament() {
    }

    public Equipament(Long id, String brand, String type) {
        this.id = id;
        this.brand = brand;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<OrderService> getOrdersServices() {
        return ordersServices;
    }

    public void setOrdersServices(List<OrderService> ordersServices) {
        this.ordersServices = ordersServices;
    }
}
