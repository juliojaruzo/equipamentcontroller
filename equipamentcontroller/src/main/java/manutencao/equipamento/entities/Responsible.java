package manutencao.equipamento.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.io.Serializable;


@Entity
@Table(name = "responsible")
public class Responsible implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "responsible")
    private List<OrderService> ordersServices;

    public Responsible(){
    }

    public Responsible(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public List<OrderService> getOrdersServices() {
        return ordersServices;
    }

    public void setOrdersServices(List<OrderService> ordersServices) {
        this.ordersServices = ordersServices;
    }
}
